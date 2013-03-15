/*
 * Created on Dec 2, 2010
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

import static org.assert4j.core.assertions.error.ShouldStartWith.shouldStartWith;
import static org.assert4j.core.util.Lists.newArrayList;

import org.assert4j.core.assertions.description.Description;
import org.assert4j.core.assertions.description.TextDescription;
import org.assert4j.core.assertions.error.ErrorMessageFactory;
import org.assert4j.core.assertions.error.ShouldStartWith;
import org.assert4j.core.assertions.internal.ComparatorBasedComparisonStrategy;
import org.assert4j.core.assertions.util.CaseInsensitiveStringComparator;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests for <code>{@link ShouldStartWith#create(Description)}</code>.
 * 
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
public class ShouldStartWith_create_Test {

  private ErrorMessageFactory factory;

  @Before
  public void setUp() {
    factory = shouldStartWith(newArrayList("Yoda", "Luke"), newArrayList("Han", "Leia"));
  }

  @Test
  public void should_create_error_message() {
    String message = factory.create(new TextDescription("Test"));
    assertEquals("[Test] expecting\n" + "<['Yoda', 'Luke']>\n" + " to start with\n" + "<['Han', 'Leia']>\n", message);
  }

  @Test
  public void should_create_error_message_with_custom_comparison_strategy() {
    factory = shouldStartWith(newArrayList("Yoda", "Luke"), newArrayList("Han", "Leia"), new ComparatorBasedComparisonStrategy(
        CaseInsensitiveStringComparator.instance));
    String message = factory.create(new TextDescription("Test"));
    assertEquals("[Test] expecting\n" + "<['Yoda', 'Luke']>\n" + " to start with\n" + "<['Han', 'Leia']>\n"
        + " according to 'CaseInsensitiveStringComparator' comparator", message);
  }
}