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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.TransformableDiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceNotationExpressionParser;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking
 * that it parses substractions with dice.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserSubstractionDice {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserSubstractionDice() {
        super();
    }

    /**
     * Verifies that a subtraction using only dice is parsed correctly.
     */
    @Test
    public final void testParse_Sub_Dice_Structure() {
        final String notation;                // Input to parse
        final SubtractionOperation operation; // Parsed operation
        final DiceOperand diceLeft;           // Left parsed dice
        final DiceOperand diceRight;          // Right parsed dice

        notation = "1d20-2d6";

        operation = (SubtractionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        diceLeft = (DiceOperand) operation.getLeft();
        diceRight = (DiceOperand) operation.getRight();

        Assertions.assertEquals((Integer) 1, diceLeft.getDice().getQuantity());
        Assertions.assertEquals((Integer) 20, diceLeft.getDice().getSides());

        Assertions.assertEquals((Integer) 2, diceRight.getDice().getQuantity());
        Assertions.assertEquals((Integer) 6, diceRight.getDice().getSides());
    }

    /**
     * Verifies that a subtraction using only dice is parsed correctly.
     */
    @Test
    public final void testParse_Sub_Dice_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "1d1-2d1";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) (-1), root.roll());
    }

    /**
     * Verifies that a subtraction with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Sub_LeftNumber_Structure() {
        final String notation;                // Input to parse
        final SubtractionOperation operation; // Parsed operation
        final IntegerOperand integer;         // Integer operand
        final DiceOperand dice;               // Dice operand

        notation = "5-2d6";

        operation = (SubtractionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        integer = (IntegerOperand) operation.getLeft();
        dice = (DiceOperand) operation.getRight();

        Assertions.assertEquals((Integer) 2, dice.getDice().getQuantity());
        Assertions.assertEquals((Integer) 6, dice.getDice().getSides());

        Assertions.assertEquals((Integer) 5, integer.getValue());
    }

    /**
     * Verifies that a subtraction with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Sub_LeftNumber_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "5-2d1";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) 3, root.roll());
    }

    /**
     * Verifies that a subtraction with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Sub_RightNumber_Structure() {
        final String notation;                // Input to parse
        final SubtractionOperation operation; // Parsed operation
        final IntegerOperand integer;         // Integer operand
        final DiceOperand dice;               // Dice operand

        notation = "2d6-5";

        operation = (SubtractionOperation) new DefaultDiceNotationExpressionParser()
                .parse(notation).getRoot();

        dice = (DiceOperand) operation.getLeft();
        integer = (IntegerOperand) operation.getRight();

        Assertions.assertEquals((Integer) 2, dice.getDice().getQuantity());
        Assertions.assertEquals((Integer) 6, dice.getDice().getSides());

        Assertions.assertEquals((Integer) 5, integer.getValue());
    }

    /**
     * Verifies that a subtraction with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Sub_RightNumber_Value() {
        final String notation;                 // Input to parse
        final TransformableDiceNotationExpression root; // Parsed operation

        notation = "2d1-5";

        root = new DefaultDiceNotationExpressionParser().parse(notation);

        Assertions.assertEquals((Integer) (-3), root.roll());
    }

}
