# Java Basics Assigments
This is the solutions created by Sebastian Porling.

## Compile
When in the java basic folder you can compile the solutions by using the following:
```bash
javac -d out a_b/*.java c/*.java d/*.java
```

## Execution

If you go to the "out" folder the following instructions for executions below should work.

### Task A and B
The first uses the same startup program.
It takes in three arguments, heigth, width and if it should be nested or not with true or false:
```bash
java java_basics.a_b.RectangleProgram 8 8 true
```

### Task C
You can run the program "PersonsProgram" to see it adds the persons to the list and then prints them out.
```bash
java java_basics.c.PersonProgram
```

### Task D
The class can be found in the "c" folder.

Motivation:

The name of the animal is represented by a string, as there are a lot of animals
and would be hard to make an enumirator for all of them.

The type of animal is represented with an enumirator, as their is six types of animals.
But if one wouldn't fint into the six of them they can be represented by "other".

Age is represented with an integer, as age is a number.

Weigth is represented with a double, just to be able to have decimal points.

Gender is represented with an enumirator, because their are two biological genders.
But if an animal wouldn't fit into to the male or female they can be placed as "other"
 
The legs of the animal is represented with an integer, as number of legs is represented by a number.
 
If the animal has fur is represented with a boolean, as it can have or not have fur. Only two values.
 
The noice is represented with a String, it has the same motivation as the name of the animal.
There are many animals and many can make unique sounds. It would be more convinient to use a enumirator or an object of some sort to be find animals that make the same sound easier.