package se.experis.academy.maven_on_heroku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.experis.academy.maven_on_heroku.model.Animal;
import se.experis.academy.maven_on_heroku.repository.AnimalRepository;

import java.util.List;

/**
 *  RestController that gets animals from the animal repository
 */
@RestController
public class ApiController {

    @Autowired
    AnimalRepository animalRepository;

    /**
     *  Returns all animals in the database
     * @return List of animals
     */
    @GetMapping("/animal")
    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    /**
     *  Finds the animal by id
     * @param id id of animal
     * @return the animal
     */
    @GetMapping("/animal/{id}")
    public Animal getAnimal(@PathVariable(name = "id") long id) {
        return animalRepository.findById(id);
    }
}
