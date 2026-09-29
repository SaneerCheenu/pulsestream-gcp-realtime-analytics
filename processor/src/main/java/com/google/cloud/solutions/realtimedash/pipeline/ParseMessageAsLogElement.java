package com.google.cloud.solutions.realtimedash.pipeline;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.common.flogger.FluentLogger;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.beam.sdk.transforms.DoFn;

/**
 * Pipeline operation to parse the Pub/Sub message as JSON into a POJO.
 */
public final class ParseMessageAsLogElement extends DoFn<String, LogEvent> {

  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  @ProcessElement
  public void parseStringToLogElement(ProcessContext context) {
    try {
      context.output(buildReader().readValue(context.element()));
    } catch (IOException ioexp) {
      logger.atWarning().atMostEvery(10, TimeUnit.SECONDS).withCause(ioexp).log();
    }
  }

  private ObjectReader buildReader() {
    return new ObjectMapper()
        .registerModule(new JodaModule())
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        .readerFor(LogEvent.class);
  }
}
