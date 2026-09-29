package com.google.cloud.solutions.realtimedash.dashboard;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;

@AutoValue
public abstract class OverlapMetric {

  public abstract ImmutableSet<String> getDimensions();

  public abstract Double getMetric();


  public static Builder builder() {
    return new AutoValue_OverlapMetric.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {

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

    public abstract Builder setDimensions(ImmutableSet<String> dimensions);

    public abstract OverlapMetric build();
  }
}
