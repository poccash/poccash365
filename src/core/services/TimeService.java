package core.services;

import core.util.Time.FasterTime;

public interface TimeService {

  int getEpochTime();

  long getEpochTimeMillis();

  void setTime(FasterTime fasterTime);
}
