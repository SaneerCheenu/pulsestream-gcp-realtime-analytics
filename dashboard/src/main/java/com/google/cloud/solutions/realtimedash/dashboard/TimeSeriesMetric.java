package com.google.cloud.solutions.realtimedash.dashboard;

import com.google.auto.value.AutoValue;
import org.joda.time.DateTime;

@AutoValue
public abstract class TimeSeriesMetric {

  public abstract DateTime getTimestamp();

  public abstract Double getMetric();

  public static Builder builder() {
    return new AutoValue_TimeSeriesMetric.Builder();
  }


  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder setTimestamp(DateTime newTimestamp);

    public abstract Builder setMetric(Double newMetric);

    public Builder setMetric(float newMetric) {
      return setMetric((double) newMetric);
    }

    public Builder setMetric(int newMetric) {
      return setMetric((double) newMetric);
    }

    public Builder setMetric(long newMetric) {
      return setMetric((double) newMetric);
    }

    public abstract TimeSeriesMetric build();
  }
}
