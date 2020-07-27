# Polymorphism

This is the solutions made by Sebastian Porling.

## Compile
While in this folder you can run the following command to compile:
```bash
javac *.java characters/*.java characters/stats/*.java
```

## Execution
To run the program just do the following:
```bash
java Program
```

## Motivation
So the stats are set in the ranger, warrior and wizard classes. But are generated from the stats classes. In the stats classes we check so the stats is between 15 and 20. In the stat generator we check so the stat is correctly weightet. This is why I implemented the StatType class so we don't need to use strings.

Other than the stat classes the implementation looks identical to the class diagram. I just added a few **Setters** in the character class. It would have been troublesome otherwise. Either by adding the stats in the constructor or having a way for the character class to know what instance it is. But that kind of defeauts the purpose of inheritance.