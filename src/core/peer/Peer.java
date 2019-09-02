package core.peer;

import core.Version;
import core.grpc.proto.CoreApi;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public interface Peer extends Comparable<Peer> {

  void connect(int currentTime);

  enum State {
    NON_CONNECTED, CONNECTED, DISCONNECTED;

    public static State fromProtobuf(CoreApi.PeerState peer) {
      switch (peer) {
        case NON_CONNECTED:
          return NON_CONNECTED;
        case CONNECTED:
          return CONNECTED;
        case DISCONNECTED:
          return DISCONNECTED;
        default:
          return null;
      }
    }

    public CoreApi.PeerState toProtobuf() {
      switch (this) {
        case NON_CONNECTED:
          return CoreApi.PeerState.NON_CONNECTED;
        case CONNECTED:
          return CoreApi.PeerState.CONNECTED;
        case DISCONNECTED:
          return CoreApi.PeerState.NON_CONNECTED;
        default:
          return CoreApi.PeerState.UNRECOGNIZED;
      }
    }
  }

  String getPeerAddress();

  String getAnnouncedAddress();

  State getState();

  void updateUploadedVolume(long volume);

  Version getVersion();

  String getApplication();

  String getPlatform();

  String getSoftware();

  boolean shareAddress();

  int getPort();

  boolean isWellKnown();

  boolean isRebroadcastTarget();

  boolean isBlacklisted();

  boolean isAtLeastMyVersion();

  boolean isHigherOrEqualVersionThan(Version version);

  void blacklist(Exception cause, String description);

  void blacklist(String description);

  void blacklist();

  void unBlacklist();

  void updateBlacklistedStatus(long curTime);

  void remove();

  boolean isState(State cmpState);

  void setState(State state);

  long getDownloadedVolume();

  void updateDownloadedVolume(long volume);

  long getUploadedVolume();

  int getLastUpdated();

  JsonObject send(JsonElement request);

  static boolean isHigherOrEqualVersion(Version ourVersion, Version possiblyLowerVersion) {
    if (ourVersion == null || possiblyLowerVersion == null) {
      return false;
    }

    return possiblyLowerVersion.isGreaterThanOrEqualTo(ourVersion);
  }
}
