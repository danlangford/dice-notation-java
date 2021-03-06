# Usage example


The project includes a model for dice and dice notation grammar. But the strong point are the parsers.

## Parsing Common Dice Notation

To parse generic dice notation, including algebraic operations use this:

```java
final DiceNotationExpressionParser parser;
final TransformableDiceNotationExpression parsed;

parser = new DefaultDiceNotationExpressionParser();

parsed = parser.parse("1d6+12");

System.out.println(parsed.roll());
```

The 'roll' method will generate a number from the expression each time it is called, simulating the dice being rolled, and applying any algebraic operation.

## Getting the Dice Set

If you need to get the dice from the expression:

```java
final TransformableDiceNotationExpression parsed;
final Dice dice;

parsed = new DefaultDiceNotationExpressionParser().parse("1d6");

dice = parsed.transform(new DiceSetsTransformer()).iterator().next();

System.out.println(dice.getQuantity());
System.out.println(dice.getSides());
```

This will print the number of dice (1) and the number of sides (6).

## Changing Random Number Generation on Parsed Dice

Random numbers, for rolling dice, are handled through an instance of [NumberGenerator][number_generator].

To use a custom generator you need to implement this and then set the new generator into the parser:

```java
final NumberGenerator numGen;
final Roller roller;
final DiceNotationExpressionParser parser;

numGen = new CustomNumberGenerator();
roller = new DefaultRoller(numGen);

parser = new DefaultDiceNotationExpressionParser(roller);
```

[number_generator]: ./apidocs/com/bernardomg/tabletop/dice/roller/random/NumberGenerator.html
