package java_basics.d;

/**
 * This class represents an Animal
 * 
 * The name of the animal is represented by a string, as there are a lot of animals
 * and would be hard to make an enumirator for all of them.
 * 
 * The type of animal is represented with an enumirator, as their is six types of animals.
 * But if one wouldn't fint into the six of them they can be represented by "other".
 * 
 * Age is represented with an integer, as age is a number.
 * 
 * Weigth is represented with a double, just to be able to have decimal points.
 * 
 * Gender is represented with an enumirator, because their are two biological genders.
 * But if an animal wouldn't fit into to the male or female they can be placed as "other"
 * 
 * The legs of the animal is represented with an integer, as number of legs is represented by a number.
 * 
 * If the animal has fur is represented with a boolean, as it can have or not have fur. Only two values.
 * 
 * The noice is represented with a String, it has the same motivation as the name of the animal.
 * There are many animals and many can make unique sounds. It would be more convinient to use a enumirator
 * or an object of some sort to be find animals that make the same sound easier.
 */
public class Animal {
    private String fullName;
    private AnimalType animalType;
    private int age;
    private double weight;
    private Gender gender;
    private int amountOfLegs;
    private boolean hasFur;
    private String noise;

    /**
     * Constructor
     * @param fullName The name of the animal
     * @param animalType The type of animal, ex. mammal, fish etc.
     * @param age The age of the animal represented with a number.
     * @param weight The weigth of the animal, represented with a double to allow decimals.
     * @param gender The gender of the animal, male, female or other.
     * @param amountOfLegs The number of legs of the animal represented with a number.
     * @param hasFur Does the animal have fur, true or false
     * @param noise The noice the animal makes is represented with a string.
     */
    public Animal(  String fullName, AnimalType animalType, 
                    int age, double weight, Gender gender, 
                    int amountOfLegs, boolean hasFur, String noise) {
        this.fullName = fullName;
        this.animalType = animalType;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
        this.amountOfLegs = amountOfLegs;
        this.hasFur = hasFur;
        this.noise = noise;
    }

    public String getFullName() {
        return this.fullName;
    }

    public AnimalType getAnimalType() {
        return this.animalType;
    }

    public int getAge() {
        return this.age;
    }

    public double getWeight() {
        return this.weight;
    }

    public Gender getGender() {
        return this.gender;
    }

    public int getAmountOfLegs() {
        return this.amountOfLegs;
    }

    public boolean hasFur() {
        return this.hasFur;
    }

    public String getNoise() {
        return noise;
    }
}