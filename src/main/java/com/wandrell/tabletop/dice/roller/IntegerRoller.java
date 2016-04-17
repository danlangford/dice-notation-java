/**
 * Copyright 2014-2016 the original author or authors
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

package com.wandrell.tabletop.dice.roller;

import com.wandrell.tabletop.dice.Dice;
import com.wandrell.tabletop.dice.generator.DefaultRandomNumberGenerator;
import com.wandrell.tabletop.dice.generator.RandomNumberGenerator;
import com.wandrell.tabletop.dice.mapper.RollMapper;

public final class IntegerRoller implements Roller<Integer> {

	private final Roller<Integer> roller;

	public IntegerRoller() {
		super();

		roller = new MappedRoller<Integer>(getIntegerMapper(),
				new DefaultRandomNumberGenerator());
	}

	public IntegerRoller(final RandomNumberGenerator generator) {
		super();

		roller = new MappedRoller<Integer>(getIntegerMapper(), generator);
	}

	private final RollMapper<Integer> getIntegerMapper() {
		return new RollMapper<Integer>() {

			@Override
			public final Integer getValueFor(final Integer roll) {
				return roll;
			}

		};
	}

	private final Roller<Integer> getRoller() {
		return roller;
	}

	@Override
	public final RollerResult<Integer> roll(final Dice dice) {
		return getRoller().roll(dice);
	}

}
