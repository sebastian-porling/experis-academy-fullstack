# Contact Application
This is Sebastian Porling solution for the contact application task at the Java Fullstack course.

## Compile
```bash
javac *.class person/*.java person/info/*.java util/*.java
```

## Execute
```bash
java Main
```
or
```
java -jar Persons.jar
```

## Motivation and explaination
The solution utilises a object oriented solution for handling the persons and their contact information. 

The main class generates persons and uses a list that can be used for the **PersonSearcher** class. The **PersonSearcher** class checks if the user search query matches the correct person info. It utilises Stream API for filtering and matching the person info.

The **Command** enum is used for easily understand what kind of search query is going to be made. 

The person info is hard coded, something that could be done differently is to read in the user info as a text or json file and then parse it instead.