package com.wandrell.tabletop.testing.dice.test.unit.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.notation.operation.constant.IntegerConstant;
import com.wandrell.tabletop.dice.parser.DiceExpressionParser;

public final class TestDiceFormulaParser {

    private final Parser<String, DiceExpression> parser;

    {
        parser = new DiceExpressionParser();
    }

    public TestDiceFormulaParser() {
        super();
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public final void testParseDice_Empty_Exception() throws Exception {
        parser.parse("");
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public final void testParseDice_Invalid_Exception() throws Exception {
        parser.parse("abc");
    }

    @Test
    public final void testParseDice_Number() throws Exception {
        final DiceExpression formula;
        final IntegerConstant value;

        formula = parser.parse("12");

        value = (IntegerConstant) formula.getComponents().iterator().next();

        Assert.assertEquals(value.getValue(), (Integer) 12);
    }

    @Test
    public final void testParseDice_Zero() throws Exception {
        final DiceExpression formula;
        final IntegerConstant value;

        formula = parser.parse("0");

        value = (IntegerConstant) formula.getComponents().iterator().next();

        Assert.assertEquals(value.getValue(), (Integer) 0);
    }

}
