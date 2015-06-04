package com.wandrell.tabletop.dice.notation;

import java.util.Collection;

public interface DiceExpression {

    public void
            addDiceNotationComponent(final DiceExpressionComponent component);

    public Collection<DiceExpressionComponent> getComponents();

    public String getPrintableText();

    public void removeDiceNotationComponent(
            final DiceExpressionComponent component);

}