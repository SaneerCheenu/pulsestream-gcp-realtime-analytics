package com.google.cloud.solutions.realtimedash.dashboard;

import java.util.Arrays;
import org.joda.time.DateTime;

public class TimeSeriesKeyBuilder {

  private final String dateTimeFormatter;

  private TimeSeriesKeyBuilder(String prefix) {
    this.dateTimeFormatter = "'" + prefix + "'" + "_yyyy_MM_dd'T'HH_mm";
  }

  public String buildTimeKey(DateTime dateTime) {
    return dateTime.toString(dateTimeFormatter);
  }

  public String[] buildTimeKeys(DateTime[] dateTimes) {
    return Arrays.stream(dateTimes)
        .map(this::buildTimeKey)
        .toArray(String[]::new);
  }

  public static TimeSeriesKeyBuilder forPrefix(String prefix) {
    return new TimeSeriesKeyBuilder(prefix);
  }
}
