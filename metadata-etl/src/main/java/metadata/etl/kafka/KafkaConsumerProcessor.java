/**
 * Copyright 2015 LinkedIn Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package metadata.etl.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.avro.generic.GenericData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wherehows.common.schemas.Record;


/**
 * Abstract class for Kafka consumer message processor.
 *
 */
public abstract class KafkaConsumerProcessor {

  protected static final Logger logger = LoggerFactory.getLogger(KafkaConsumerProcessor.class);

  /**
   * Abstract method 'process' to be implemented by specific processor
   * input Kafka record, process information and write to DB.
   * @param record
   * @param topic
   * @throws Exception
   */
  public abstract Record process(GenericData.Record record, String topic) throws Exception;


  /**
   * Parse Long value from a String, if null or exception, return 0
   * @param text String
   * @return long
   */
  protected long parseLong(String text) {
    try {
      return Long.parseLong(text);
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  /**
   * Parse Integer value from a String, if null or exception, return 0
   * @param text String
   * @return int
   */
  protected int parseInteger(String text) {
    try {
      return Integer.parseInt(text);
    } catch (NumberFormatException e) {
      return 0;
    }
  }
}
