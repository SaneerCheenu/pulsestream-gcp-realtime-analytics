package com.google.cloud.solutions.realtimedash.pipeline;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.auto.value.AutoValue;
import java.io.Serializable;
import org.joda.time.DateTime;

/**
 * Data model represents the message sent to Pub/Sub Module.
 */
@JsonDeserialize(builder = AutoValue_LogEvent.Builder.class)
@AutoValue
public abstract class LogEvent implements Serializable {

  public static Builder builder() {
    return new AutoValue_LogEvent.Builder();
  }

  public abstract String getUid();

  public abstract String getExperimentId();

  public abstract String getVariant();

  public abstract DateTime getTimestamp();

  @JsonPOJOBuilder(withPrefix = "set")
  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder setUid(String newUid);

    public abstract Builder setExperimentId(String newExperimentId);

    public abstract Builder setVariant(String newVariant);

    public abstract Builder setTimestamp(DateTime newTimestamp);

    public abstract LogEvent build();
  }
}
