/*
 * Created on Dec 20, 2010
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
package org.assert4j.core.assertions.api.floatarray;

import static org.mockito.Mockito.verify;


import org.assert4j.core.assertions.api.FloatArrayAssert;
import org.assert4j.core.assertions.api.FloatArrayAssertBaseTest;
import org.junit.Test;

/**
 * Tests for <code>{@link FloatArrayAssert#isEmpty()}</code>.
 * 
 * @author Alex Ruiz
 */
public class FloatArrayAssert_isEmpty_Test extends FloatArrayAssertBaseTest {
  @Override
  protected FloatArrayAssert invoke_api_method() {
    assertions.isEmpty();
    return null;
  }

  @Override
  protected void verify_internal_effects() {
    verify(arrays).assertEmpty(getInfo(assertions), getActual(assertions));
  }

  @Override
  @Test
  public void should_return_this() {
    // Disable this test since isEmpty is void
  }
}