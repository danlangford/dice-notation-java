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

package com.bernardomg.tabletop.dice.notation;

import com.bernardomg.tabletop.dice.notation.transformer.DiceNotationTransformer;

/**
 * A dice notation expression which allows transformations. This way any value
 * can be generated from an expression tree.
 * <p>
 * By default it offers support to rolling the expression, which will generate a
 * value from the expression in the tree, simulating rolls as needed.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public interface TransformableDiceNotationExpression
        extends DiceNotationExpression {

    /**
     * Returns the wrapped expression, which is the root node in the expression
     * tree.
     * 
     * @return the root node
     */
    public DiceNotationExpression getRoot();

    /**
     * Returns a value generated from the expression, simulating rolls as
     * needed.
     * 
     * @return a value generated from the expression
     */
    public Integer roll();

    /**
     * Returns a value from the expression
     * <p>
     * This allows acquiring custom data from the expression tree.
     * 
     * @param <V>
     *            type to transform into
     * @param interpreter
     *            contains the logic to transform the expression
     * @return transformed result
     */
    public <V> V transform(final DiceNotationTransformer<V> interpreter);

}
