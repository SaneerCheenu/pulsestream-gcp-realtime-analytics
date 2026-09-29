package com.google.cloud.solutions.realtimedash.pipeline;

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation;

/**
 * A Streaming pipeline option for the Metrics calculation pipeline.
 */
public interface MetricsPipelineOptions extends PipelineOptions {

  @Description("The Cloud Pub/Sub topic to read from.")
  @Validation.Required
  String getInputTopic();

  void setInputTopic(String value);

  @Description("Redis Host")
  @Validation.Required
  String getRedisHost();

  void setRedisHost(String redisHost);

  @Description("Redis Port")
  @Validation.Required
  Integer getRedisPort();

  void setRedisPort(Integer redisPort);
}
