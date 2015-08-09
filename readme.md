# Dice Notation Tools for Java
With the use of this library dice notation and algebra, using expressions such as "1d6+5" or "2d10*2", can be parsed and operated.

This notation is widely used on tabletop games, such as wargames or RPGs, and was created on the late 70s for Dungeons & Dragons.

With the pass of years it has evolved, and while it never underwent a formal standarization process a core set of rules is kept among all the variations:

* A dice is represented as xdy. Where 'x' is the number of dice and 'y' the number of sides they have.
* Integer numbers can be added and substracted from the results.
* It is possible to swap a dice for a constant. They are both the same kind of term inside a dice algebra operation.

To handle this, and a few additional modifications, a grammar has been created using ANTLR4, which can be found in the path [src/main/antlr4/DiceNotation.g4](src/main/antlr4/DiceNotation.g4).

## Features

The library contains the following features:

- ANTLR4 grammar
- Model for dice and dice notation, along classes to generate values from them
- Parser to create model instances from the notation

## Documentation

Documentation is always generated for the latest release, kept in the 'master' branch:

- The [latest release documentation page][site-release].
- The [the latest release Javadoc site][javadoc-release].

Documentation is also generated from the latest snapshot, taken from the 'develop' branch:

- The [the latest snapshot documentation page][site-develop].
- The [the latest snapshot Javadoc site][javadoc-develop].

The documentation site sources come along the source code (as it is a Maven site), so it is always possible to generate them using the following Maven command:

```
$ mvn verify site
```

The verify phase is required, as otherwise some of the reports won't be created.

## Usage

The application is coded in Java, using Maven to manage the project.

### Prerequisites

The project has been tested on the following Java versions:
* JDK 7
* JDK 8
* OpenJDK 7

All other dependencies are handled through Maven, and noted in the included POM file.

### Installing

The recommended way to install the project is by setting up your preferred dependencies manager. To get the configuration information for this check the [Bintray repository][bintray-repo], or the [Maven Central Repository][maven-repo].

If for some reason manual installation is necessary, just use the following Maven command:

```
$ mvn install
```

## Collaborate

Any kind of help with the project will be well received, and there are two main ways to give such help:

- Reporting errors and asking for extensions through the issues management
- or forking the repository and extending the project

### Issues management

Issues are managed at the GitHub [project issues tracker][issues], where any Github user may report bugs or ask for new features.

### Getting the code

If you wish to fork or modify the code, visit the [GitHub project page][scm], where the latest versions are always kept. Check the 'master' branch for the latest release, and the 'develop' for the current, and stable, development version.

## License

The project has been released under version 2.0 of the [Apache License][license].

[bintray-repo]: https://bintray.com/bernardo-mg/tabletop-toolkits/dice/view
[maven-repo]: http://mvnrepository.com/artifact/com.wandrell.tabletop/dice
[issues]: https://github.com/Bernardo-MG/tabletop-dice-java/issues
[javadoc-develop]: http://docs.wandrell.com/development/maven/tabletop-dice/apidocs
[javadoc-release]: http://docs.wandrell.com/maven/tabletop-dice/apidocs
[license]: http://www.apache.org/licenses/LICENSE-2.0
[scm]: http://github.com/Bernardo-MG/tabletop-dice-java
[site-develop]: http://docs.wandrell.com/development/maven/tabletop-dice
[site-release]: http://docs.wandrell.com/maven/tabletop-dice