# Luhn Algorithm
Solution made by Sebastian Porling

## Compile
Either import the project to IntelliJ or run the following when in src:
```bash
javac -d ../out se/experis/academy/*.java se/experis/academy/Luhn/*.java 
```

## Execute
Either with IntelliJ or with the following while in out:
```bash
java se.experis.academy.Main <number>
or
java se.experis.academy.Main
```

## Tests
Not sure how to run tests outside Intellij. But we sanity check most kind of data for all classes, even check what the user can input through the arguments or by standard input. 

## Motivation
The **Main** class can either take input from arguments or by standard input which is captured with a scanner. It is then parsed to a Integer array, all non numerics are replaced with "". It then uses the **LuhnAlgorithm** class to calculate the checksum and to see if it is the same as the provided checksum. We use Streams API to calculate and parse most of the data. The **Util** class has a method to see if the number is a valid credit card number or not. I utilize the exception class **NotValidLuhnException** when we can't calculate the checksum, when the number is outside the range 0-9 or null or empty we will throw the exception.