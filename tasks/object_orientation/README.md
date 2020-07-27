# Object Orientation
This is the solutions created by Sebastian Porling at Experis Academy. You can contact me on Slack, Sebastian.Porling@se.experis.com or +46761893507 on WhatsApp or phone.

## Compile
For task_d you can compile like the following while in the "task_d" folder:
```bash
javac -d out src/*.java src/animal/*.java src/animal/animalType/*.java src/animal/movement/*.java
```

## Execution
To run the task d just do the following while inside "task_d/out":
```bash
java src.AnimalProgram
```

## Task A&B&C
We have the abstract super class called **Amimal** which uses the abstract methods ``eats()`` and ``makeNoice()``. It also implements the interfaces **Runable** and **Walkable** that will be implemented by the animals.

Then we have the abstract superclasses called **Carnivore**, **Herbivore** and **Omnivore** which implements the ``eats()`` method to show what that type of animal eats, but the ``walks()`` method is up to the sublcass to define.

The classes **Cat**, **Mouse** and **Sheep** has a variable of ``String sound`` which has a suitable sound for that animal. It also implements the methods from the interfaces **Runable** and **Walkable** to return a string of a sound that that movement makes for that animal.

## Task D
Compilation and execution can be found above.

This class uses the classes done in **Task A&B&C**. With the executable program **AnimalProgram**. It adds each animal to a list under the abstract class **Animal**. It then takes out a random element from the list and prints out the information on that animal.