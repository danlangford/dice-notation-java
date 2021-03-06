# Dice notation parser

The main feature of the project is a parser capable of transforming dice notation expressions into the dice notation model.

## Default Parser

![Dice notation parser class diagram][dice_notation_parser-class_diagram]

The [DiceNotationExpressionParser][dice_notation_parser] interface is implemented by the [DefaultDiceNotationExpressionParser][default_dice_notation_parser]. This makes use of the [ANTRL grammar][grammar-doc] to transform a string into the [dice notation model][dice_notation_model-doc].

### Visitor

![Dice expression builder class diagram][dice_expression_builder-class_diagram]

Most of the parsing is handled by ANTLR, and then adapted to the returned dice notation with the use of a visitor pattern. This visitor is a [DiceExpressionBuilder][dice_expression_buider] which extends over the DiceNotationListener which is automatically generated from the ANTLR grammar file.

The [DefaultDiceExpressionBuilder][default_dice_expression_buider] implements the visitor, and makes use of  a stack to hold all the operands for any operation which may appear during parsing.

The way this works is simple, each time it visits a node from the parse tree it stores the value from it into the stack. If the visited node is a constant it is stored as it was found, if it is a dice expression then a dice class is generated.

If the visited node is a binary operation then this changes a bit. First the last two values are taken back from the stack, and they are used to generate the operation, based on the operator, which tells which actual operation will be used.

[dice_notation_parser]: ./apidocs/com/bernardomg/tabletop/dice/parser/DiceNotationExpressionParser.html
[default_dice_notation_parser]: ./apidocs/com/bernardomg/tabletop/dice/parser/DefaultDiceNotationExpressionParser.html
[dice_expression_buider]: ./apidocs/com/bernardomg/tabletop/dice/parser/listener/DiceExpressionBuilder.html
[default_dice_expression_buider]: ./apidocs/com/bernardomg/tabletop/dice/parser/listener/DefaultDiceExpressionBuilder.html

[dice_notation_parser-class_diagram]: ./images/dice_notation_parser_class_diagram.png
[dice_expression_builder-class_diagram]: ./images/dice_expression_builder_class_diagram.png

[grammar-doc]: ./grammar.html
[dice_notation_model-doc]: ./notation.html
