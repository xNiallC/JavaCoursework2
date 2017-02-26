/*
 * Name: Niall Curtis
 * Student number: C1623580
 */

import java.util.*;

public class Zoo {
    // New HashMap for animals in the zoo
    private HashMap<String, Animal> zooAnimals;

    private int zooCapacity;

    public Zoo() {
        zooAnimals = new HashMap<String, Animal>();
        // -1 used as arbritary value for unlimited.
        this.zooCapacity = -1;
    }

    public Zoo( int inCapacity) {
        // Check if a zoo capacity of less than 0 is entered.
        if(inCapacity <= 0) {
            throw new IllegalArgumentException("Impossible Zoo Capacity Entered.");
        }
        zooAnimals = new HashMap<String, Animal>();
		this.zooCapacity = inCapacity;
    }

    // Iterate through numbers of animals in hashmap, sum them up, return the value.
    public int numberAvailableAnimals() {
        int availableAnimals = 0;
        for(Animal animal: zooAnimals.values()) {
            availableAnimals += animal.getAvailableAnimals();
        }
        return availableAnimals;
    }


    /*
        Begin by checking if the zoo is unlimited or not. If it is, simply add the animal name (converted to lower case
        for consistency), and the instance. If it isn't, call the getAvailableAnimals to use in a calculation to see if
        the addAnimal will go over the limit of the zoo. If it would go over the limit, throw a state exception.
     */
    public void addAnimal(Animal newAnimal) {
        if(zooCapacity == -1) {
            zooAnimals.put(newAnimal.getName().toLowerCase(), newAnimal);
        }
        else if (newAnimal.getAvailableAnimals() + this.numberAvailableAnimals() <= zooCapacity) {
            zooAnimals.put(newAnimal.getName().toLowerCase(), newAnimal);
        }
        else {
            throw new IllegalStateException("Zoo capacity, there are too many animals.");
        }
    }

    // Iterate through hashmap looking for an animal equal to animal name. If there is one, return true.
    public boolean hasAnimalWithName(String animalName) {
        for(String key: zooAnimals.keySet()) {
            if(animalName.toLowerCase().equals(key.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /*
     Takes input of animal name, converts it to lower case, then uses .containKey to check if the HashMap
    contains a key String equal to animalName. If so, returns the animal instance relating to the key, otherwise
    null.
    */
    public Animal getAnimalWithName(String animalName) {
        // Create field of lower case animal name, as we reference it twice. Better practice.
        String animalNameLower = animalName.toLowerCase();

        if(zooAnimals.containsKey(animalNameLower)) {
            return zooAnimals.get(animalNameLower);
        }
        else {
            return null;
        }

    }
}


