package src;

import java.util.ArrayList;
import java.util.Random;
import src.animal.animalType.*;
import src.animal.*;

/**
 * A program that chooses a random animal and shows what sounds it makes 
 * and what it eats.
 */
public class AnimalProgram {

    /**
     * The main program, ignores all arguments.
     */
    public static void main(String[] args) {
        ArrayList<Animal> animals = generateAnimalList();

        Animal animal = getRandomAnimal(animals);

        printAnimalInfo(animal);
    }

    /**
     * Generates an ArrayList of animals
     * @return ArrayList of animals
     */
    private static ArrayList<Animal> generateAnimalList(){
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Cat());
        animals.add(new Mouse());
        animals.add(new Sheep());
        return animals;
    }

    /**
     * Gets a random animal from the animal list
     * @param animals List of animal
     * @return A random Animal
     */
    private static Animal getRandomAnimal(ArrayList<Animal> animals) {
        Random random = new Random();
        return animals.get(random.nextInt(animals.size()));
    }

    /**
     * Prints out information about an animal
     * @param animal The animal that we should show information about
     */
    private static void printAnimalInfo(Animal animal) {
        System.out.print("This animal sounds like: ");
        animal.makeNoise();
        System.out.println("The animal walks like: " + animal.walk());
        System.out.println("The animal runs like: " + animal.run());
        System.out.println(animal.eats());
    }
}