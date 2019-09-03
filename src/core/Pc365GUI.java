package core;

import core.props.PropertyService;
import core.props.Props;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.FileDescriptor;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.URI;
import java.security.Permission;

public class Pc365GUI extends Application {
    private static final String ICON_LOCATION = "/images/pc365_overlay_logo.png";
    private static final String FAILED_TO_START_MESSAGE = "Pc365GUI caught exception starting CORE";
    private static final String UNEXPECTED_EXIT_MESSAGE = "CORE Quit unexpectedly! Exit code ";

    private static final int OUTPUT_MAX_LINES = 500;

    private static final Logger LOGGER = LoggerFactory.getLogger(Pc365GUI.class);
    private static String[] args;

    private boolean userClosed = false;
    private Stage stage;
    private TrayIcon trayIcon = null;

    public static void main(String[] args) {
        Pc365GUI.args = args;
        Platform.setImplicitExit(false);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        System.setSecurityManager(new Pc365GUISecurityManager());
        primaryStage.setTitle("Pc365 Reference Software version " + Pc365.VERSION);
        TextArea textArea = new TextArea() {
            @Override
            public void replaceText(int start, int end, String text) {
                super.replaceText(start, end, text);
                while(getText().split("\n", -1).length > OUTPUT_MAX_LINES) {
                    int fle = getText().indexOf('\n');
                    super.replaceText(0, fle+1, "");
                }
                positionCaret(getText().length());
            }
        };
        textArea.setEditable(false);
        sendJavaOutputToTextArea(textArea);
        primaryStage.setScene(new Scene(textArea, 800, 450));
        primaryStage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream(ICON_LOCATION)));
        stage = primaryStage;
        showTrayIcon();
        new Thread(this::runCore).start();
    }

    private void shutdown() {
        userClosed = true;
        if (trayIcon != null && SystemTray.isSupported()) {
            SystemTray.getSystemTray().remove(trayIcon);
        }
        System.exit(0); // CORE shutdown handled by exit hook
    }

    private void showTrayIcon() {
        if (trayIcon == null) { // Don't start running in tray twice
            trayIcon = createTrayIcon();
            if (trayIcon != null) {
                stage.setOnCloseRequest(event -> hideWindow());
            } else {
                stage.show();
                stage.setOnCloseRequest(event -> shutdown());
            }
        }
    }

    private TrayIcon createTrayIcon() {
        try {
            SystemTray systemTray = SystemTray.getSystemTray();
            PopupMenu popupMenu = new PopupMenu();

            MenuItem openWebUiButton = new MenuItem("Open Web GUI");
            MenuItem showItem = new MenuItem("Show CORE output");
            MenuItem shutdownItem = new MenuItem("Shutdown CORE");

            openWebUiButton.addActionListener(e -> openWebUi());
            showItem.addActionListener(e -> showWindow());
            shutdownItem.addActionListener(e -> shutdown());

            popupMenu.add(openWebUiButton);
            popupMenu.add(showItem);
            popupMenu.add(shutdownItem);

            TrayIcon newTrayIcon = new TrayIcon(Toolkit.getDefaultToolkit().createImage(Pc365GUI.class.getResource(ICON_LOCATION)), "Pc365 Reference Software", popupMenu);
            newTrayIcon.setImage(newTrayIcon.getImage().getScaledInstance(newTrayIcon.getSize().width, -1, Image.SCALE_SMOOTH));
            newTrayIcon.addActionListener(e -> openWebUi());
            systemTray.add(newTrayIcon);
            return newTrayIcon;
        } catch (Exception e) {
            LOGGER.error("Could not create tray icon", e);
            return null;
        }
    }

    private void showWindow() {
        Platform.runLater(stage::show);
    }

    private void hideWindow() {
        Platform.runLater(stage::hide);
    }

    private void openWebUi() {
        try {
            PropertyService propertyService = Pc365.getPropertyService();
            int port = propertyService.getBoolean(Props.DEV_TESTNET) ? propertyService.getInt(Props.DEV_API_PORT) : propertyService.getInt(Props.API_PORT);
            String httpPrefix = propertyService.getBoolean(Props.API_SSL) ? "https://" : "http://";
            String address = httpPrefix + "localhost:" + port;
            try {
                Desktop.getDesktop().browse(new URI(address));
            } catch (Exception e) { // Catches parse exception or exception when opening browser
                LOGGER.error("Could not open browser", e);
                showMessage("Error opening web UI. Please open your browser and navigate to " + address);
            }
        } catch (Exception e) { // Catches error accessing PropertyService
            LOGGER.error("Could not access PropertyService", e);
            showMessage("Could not open web UI as could not read CORE configuration.");
        }
    }

    private void runCore() {
        try {
            Pc365.main(args);
            try {
                if (Pc365.getPropertyService().getBoolean(Props.DEV_TESTNET)) {
                    onTestNetEnabled();
                }
            } catch (Exception t) {
                LOGGER.error("Could not determine if running in testnet mode", t);
            }
        } catch (SecurityException ignored) {
        } catch (Exception t) {
            LOGGER.error(FAILED_TO_START_MESSAGE, t);
            showMessage(FAILED_TO_START_MESSAGE);
            onCoreStopped();
        }
    }

    private void onTestNetEnabled() {
        Platform.runLater(() -> stage.setTitle(stage.getTitle() + " (TESTNET)"));
        trayIcon.setToolTip(trayIcon.getToolTip() + " (TESTNET)");
    }

    private void onCoreStopped() {
        Platform.runLater(() -> stage.setTitle(stage.getTitle() + " (STOPPED)"));
        trayIcon.setToolTip(trayIcon.getToolTip() + " (STOPPED)");
    }

    @SuppressWarnings("squid:S106")
    private void sendJavaOutputToTextArea(TextArea textArea) {
        System.setOut(new PrintStream(new TextAreaOutputStream(textArea, System.out)));
        System.setErr(new PrintStream(new TextAreaOutputStream(textArea, System.err)));
    }

    @SuppressWarnings("squid:S106")
    private void showMessage(String message) {
        Platform.runLater(() -> {
            System.err.println("Showing message: " + message);
            Dialog dialog = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
            dialog.setGraphic(null);
            dialog.setHeaderText(null);
            dialog.setTitle("CORE Message");
            dialog.show();
        });
    }

    private static class TextAreaOutputStream extends OutputStream {
        private final TextArea textArea;
        private final PrintStream actualOutput;

        private StringBuilder lineBuilder = new StringBuilder();

        private TextAreaOutputStream(TextArea textArea, PrintStream actualOutput) {
            this.textArea = textArea;
            this.actualOutput = actualOutput;
        }

        @Override
        public void write(int b) {
            writeString(new String(new byte[]{(byte)b}));
        }

        @Override
        public void write(byte[] b) {
            writeString(new String(b));
        }

        @Override
        public void write(byte[] b, int off, int len) {
            writeString(new String(b, off, len));
        }

        private void writeString(String string) {
            lineBuilder.append(string);
            String line = lineBuilder.toString();
            if (line.contains("\n")) {
                actualOutput.print(line);
                if (textArea != null) {
                    Platform.runLater(() -> textArea.appendText(line));
                }
                lineBuilder.delete(0, lineBuilder.length());
            }
        }
    }

    private class Pc365GUISecurityManager extends SecurityManager {

        @Override
        public void checkExit(int status) {
            if (!userClosed) {
                LOGGER.error("{} {}", UNEXPECTED_EXIT_MESSAGE, status);
                Platform.runLater(() -> stage.show());
                showMessage(UNEXPECTED_EXIT_MESSAGE + String.valueOf(status));
                onCoreStopped();
                throw new SecurityException();
            }
        }

        @Override
        public void checkPermission(Permission perm) {
            // No need to check.
        }

        @Override
        public void checkPermission(Permission perm, Object context) {
            // No need to check.
        }

        @Override
        public void checkCreateClassLoader() {
            // No need to check.
        }

        @Override
        public void checkAccess(Thread t) {
            // No need to check.
        }

        @Override
        public void checkAccess(ThreadGroup g) {
            // No need to check.
        }

        @Override
        public void checkExec(String cmd) {
            // No need to check.
        }

        @Override
        public void checkLink(String lib) {
            // No need to check.
        }

        @Override
        public void checkRead(FileDescriptor fd) {
            // No need to check.
        }

        @Override
        public void checkRead(String file) {
            // No need to check.
        }

        @Override
        public void checkRead(String file, Object context) {
            // No need to check.
        }

        @Override
        public void checkWrite(FileDescriptor fd) {
            // No need to check.
        }

        @Override
        public void checkWrite(String file) {
            // No need to check.
        }

        @Override
        public void checkDelete(String file) {
            // No need to check.
        }

        @Override
        public void checkConnect(String host, int port) {
            // No need to check.
        }

        @Override
        public void checkConnect(String host, int port, Object context) {
            // No need to check.
        }

        @Override
        public void checkListen(int port) {
            // No need to check.
        }

        @Override
        public void checkAccept(String host, int port) {
            // No need to check.
        }

        @Override
        public void checkMulticast(InetAddress maddr) {
            // No need to check.
        }

        @Override
        public void checkPropertiesAccess() {
            // No need to check.
        }

        @Override
        public void checkPropertyAccess(String key) {
            // No need to check.
        }

        @Override
        public void checkPrintJobAccess() {
            // No need to check.
        }

        @Override
        public void checkPackageAccess(String pkg) {
            // No need to check.
        }

        @Override
        public void checkPackageDefinition(String pkg) {
            // No need to check.
        }

        @Override
        public void checkSetFactory() {
            // No need to check.
        }

        @Override
        public void checkSecurityAccess(String target) {
            // No need to check.
        }
    }
}
