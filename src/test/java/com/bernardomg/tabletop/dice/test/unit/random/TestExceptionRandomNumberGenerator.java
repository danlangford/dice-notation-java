/**
 * Copyright 2014-2018 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.bernardomg.tabletop.dice.test.unit.random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.roller.random.NumberGenerator;
import com.bernardomg.tabletop.dice.roller.random.RandomNumberGenerator;

/**
 * Units tests for {@code RandomNumberGenerator}, checking that it throws
 * exceptions when required.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestExceptionRandomNumberGenerator {

    /**
     * Default constructor.
     */
    public TestExceptionRandomNumberGenerator() {
        super();
    }

    /**
     * Verifies that generating a value for a negative max throws an exception.
     */
    @Test
    public final void testGenerate_NegativeMax() {
        final NumberGenerator generator; // Tested generator
        final Executable closure;

        generator = new RandomNumberGenerator();

        closure = () -> generator.generate(-1);

        Assertions.assertThrows(IllegalArgumentException.class, closure);
    }

}
