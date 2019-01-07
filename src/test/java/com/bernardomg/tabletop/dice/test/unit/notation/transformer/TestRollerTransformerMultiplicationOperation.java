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

package com.bernardomg.tabletop.dice.test.unit.notation.transformer;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.MultiplicationOperation;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.notation.transformer.RollerTransformer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * Unit tests for {@link MultiplicationOperation}, checking that it works as expected
 * with its operands.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestRollerTransformerMultiplicationOperation {

    /**
     * Default constructor.
     */
    public TestRollerTransformerMultiplicationOperation() {
        super();
    }

    /**
     * Verifies that the value is generated correctly.
     */
    @Test
    public final void testValue() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        // 1 * 2
        operation = new MultiplicationOperation(left, right);

        Assertions.assertEquals(Integer.valueOf(2),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that multiplications of negative values are handled correctly.
     */
    @Test
    public final void testValue_MultiplyNegative() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = new IntegerOperand(1);
        right = new IntegerOperand(-2);

        // 1 * -2
        operation = new MultiplicationOperation(left, right);

        Assertions.assertEquals(Integer.valueOf(-2),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that multiplications of negative values are handled correctly.
     */
    @Test
    public final void testValue_MultiplyNegative_Grouped() {
        final BinaryOperation grouped;      // Tested operation
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final DiceNotationExpression value; // Right operand

        value = new IntegerOperand(1);

        left = new IntegerOperand(2);
        right = new IntegerOperand(3);

        grouped = new SubtractionOperation(left, right);

        // 1 * (2 - 3)
        operation = new MultiplicationOperation(value, grouped);

        Assertions.assertEquals(Integer.valueOf(-1),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that multiplications of negative values are handled correctly.
     */
    @Test
    public final void testValue_MultiplyNegatives() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = new IntegerOperand(-1);
        right = new IntegerOperand(-2);

        // -1 * -2
        operation = new MultiplicationOperation(left, right);

        Assertions.assertEquals(Integer.valueOf(2),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that multiplications to negative values are handled correctly.
     */
    @Test
    public final void testValue_MultiplyToNegative() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand

        left = new IntegerOperand(-1);
        right = new IntegerOperand(2);

        // -1 * 2
        operation = new MultiplicationOperation(left, right);

        Assertions.assertEquals(Integer.valueOf(-2),
                new RollerTransformer().transform(operation));
    }

    /**
     * Verifies that multiplications to negative values are handled correctly.
     */
    @Test
    public final void testValue_MultiplyToNegative_Grouped() {
        final BinaryOperation grouped;      // Tested operation
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final DiceNotationExpression value; // Right operand

        left = new IntegerOperand(1);
        right = new IntegerOperand(2);

        grouped = new SubtractionOperation(left, right);

        value = new IntegerOperand(3);

        // (1 - 2) * 3
        operation = new MultiplicationOperation(grouped, value);

        Assertions.assertEquals(Integer.valueOf(-3),
                new RollerTransformer().transform(operation));
    }

}
