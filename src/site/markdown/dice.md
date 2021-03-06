# Dice model and supporting classes

A simple dice model is offered as part of the project, including not only a representation for dice groups, but also a way to generate random values from them.

## Dice model

![Dice class diagram][dice-class_diagram]

The [Dice][dice] interface represents its namesake.

## Dice roller

![Roller class diagram][roller-class_diagram]

The [Roller][roller] generates random values from the dice classes. The default implemention of this interface, the [DefaultRoller][default_roller] makes use of a [NumberGenerator][number_generator] to actually take care of the random number generation concern.

### Rolling Dice

![Roller sequence diagram][roller-sequence_diagram]

The default roller generates a random value between one and the number of sides for the dice, and repeats as many times as the quantity of dice it has received, returning all these values inside an Iterable.

## Number generator

![Number generator class diagram][number_generator-class_diagram]

This allows customizing the random number generation used when simulating rolls. Most of the times the [RandomNumberGenerator][random_number_generator], which maeks use of the Java Random class, will handle the work neatly.

[dice-class_diagram]: ./images/dice_class_diagram.png
[number_generator-class_diagram]: ./images/number_generator_class_diagram.png
[roller-class_diagram]: ./images/roller_class_diagram.png
[roller-sequence_diagram]: ./images/roller_sequence_diagram.png

[dice]: ./apidocs/com/bernardomg/tabletop/dice/Dice.html

[roller]: ./apidocs/com/bernardomg/tabletop/dice/roller/Roller.html
[default_roller]: ./apidocs/com/bernardomg/tabletop/dice/roller/DefaultRoller.html

[number_generator]: ./apidocs/com/bernardomg/tabletop/dice/roller/random/NumberGenerator.html
[random_number_generator]: ./apidocs/com/bernardomg/tabletop/dice/roller/random/RandomNumberGenerator.html
