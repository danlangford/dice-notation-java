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

package com.bernardomg.tabletop.dice.test.integration.parser;

import com.bernardomg.tabletop.dice.notation.TransformableDiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.MultiplicationOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses numeric multiplications.
 * 
 * @author Dan '8bagels' Langford
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserMultiplicationNumber {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserMultiplicationNumber() {
        super();
    }

    /**
     * Verifies that long multiplications can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Multiply_Long_Structure() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        MultiplicationOperation multiply;
        IntegerOperand number;

        notation = "1*2*3";

        // ((1*2)*3)
        operation = (MultiplicationOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        number = (IntegerOperand) operation.getRight();
        Assertions.assertEquals((Integer) 3, number.getValue());

        multiply = (MultiplicationOperation) operation.getLeft();

        number = (IntegerOperand) multiply.getRight();
        Assertions.assertEquals((Integer) 2, number.getValue());

        number = (IntegerOperand) multiply.getLeft();
        Assertions.assertEquals((Integer) 1, number.getValue());
    }

    /**
     * Verifies that long multiplications can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Multiply_Long_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1*2*3*4";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 24, root.roll());
    }

    /**
     * Verifies that longer multiplications can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Multiply_Longer_Structure() {
        final String notation;             // Input to parse
        final MultiplicationOperation operation; // Parsed operation
        MultiplicationOperation multiply;
        IntegerOperand number;

        notation = "1*2*3*4*5";

        // ((((1*2)*3)*4)*5)
        operation = (MultiplicationOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        number = (IntegerOperand) operation.getRight();
        Assertions.assertEquals((Integer) 5, number.getValue());

        multiply = (MultiplicationOperation) operation.getLeft();

        number = (IntegerOperand) multiply.getRight();
        Assertions.assertEquals((Integer) 4, number.getValue());

        multiply = (MultiplicationOperation) multiply.getLeft();

        number = (IntegerOperand) multiply.getRight();
        Assertions.assertEquals((Integer) 3, number.getValue());

        multiply = (MultiplicationOperation) multiply.getLeft();

        number = (IntegerOperand) multiply.getRight();
        Assertions.assertEquals((Integer) 2, number.getValue());

        number = (IntegerOperand) multiply.getLeft();
        Assertions.assertEquals((Integer) 1, number.getValue());
    }

    /**
     * Verifies that longer multiplications can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Multiply_Longer_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1*2*3*4*5";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 120, root.roll());
    }

    /**
     * Verifies that a multiplication with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Multiply_Structure() {
        final String notation;             // Input to parse
        final MultiplicationOperation operation; // Parsed operation
        IntegerOperand number;

        notation = "1*2";

        // (1*2)
        operation = (MultiplicationOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        number = (IntegerOperand) operation.getRight();
        Assertions.assertEquals((Integer) 2, number.getValue());

        number = (IntegerOperand) operation.getLeft();
        Assertions.assertEquals((Integer) 1, number.getValue());
    }

    /**
     * Verifies that a multiplication with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Multiply_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1*2";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 2, root.roll());
    }

}
