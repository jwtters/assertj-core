/*
 * Created on Sep 26, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.assert4j.core.assertions.error;

import static junit.framework.Assert.assertEquals;

import static org.assert4j.core.assertions.error.ShouldBeInSameSecond.shouldBeInSameSecond;
import static org.assert4j.core.util.Dates.ISO_DATE_TIME_FORMAT;

import java.text.ParseException;

import org.assert4j.core.assertions.description.*;
import org.assert4j.core.assertions.error.ErrorMessageFactory;
import org.assert4j.core.assertions.error.ShouldBeInSameSecond;
import org.junit.Test;


/**
 * Tests for <code>{@link ShouldBeInSameSecond#create(Description)}</code>.
 * 
 * @author Joel Costigliola
 */
public class ShouldBeInSameSecond_create_Test {

  @Test
  public void should_create_error_message() throws ParseException {
    ErrorMessageFactory factory = shouldBeInSameSecond(ISO_DATE_TIME_FORMAT.parse("2011-01-01T05:00:01"),
        ISO_DATE_TIME_FORMAT.parse("2011-01-01T05:00:02"));

    String message = factory.create(new TextDescription("Test"));
    assertEquals(
        "[Test] expected <2011-01-01T05:00:01> to be on same year, month, day, hour, minute and second as <2011-01-01T05:00:02>",
        message);
  }

}