package core.deeplink;

import core.feesuggestions.FeeSuggestionType;
import core.util.StringUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.Map;

public class DeeplinkQRCodeGenerator {

  private final QRCodeWriter qrCodeWriter = new QRCodeWriter();
  private final Map<EncodeHintType, ErrorCorrectionLevel> hints = new EnumMap<>(EncodeHintType.class);

  public DeeplinkQRCodeGenerator() {
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
  }

  public BufferedImage generateRequestPc365DeepLinkQRCode(String receiverId, long amountNQT, FeeSuggestionType feeSuggestionType, Long feeNQT, String message, boolean immutable)
      throws WriterException {
    final StringBuilder deeplinkBuilder = new StringBuilder("pc365://requestPc365");

    deeplinkBuilder.append("&receiver=").append(receiverId);
    deeplinkBuilder.append("&amountNQT=").append(amountNQT);

    if (feeNQT != null) {
      deeplinkBuilder.append("&feeNQT=").append(feeNQT);
    } else {
      deeplinkBuilder.append("&feeSuggestionType=").append(feeSuggestionType.getType());
    }

    if (!StringUtils.isEmpty(message)) {
      deeplinkBuilder.append("&message=").append(message);
    }

    deeplinkBuilder.append("&immutable=").append(immutable);

    return generatePc365QRCode(deeplinkBuilder.toString());
  }

  private BufferedImage generatePc365QRCode(String url) throws WriterException {
    return MatrixToImageWriter.toBufferedImage(qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 350, 350, hints), new MatrixToImageConfig());
  }
}
