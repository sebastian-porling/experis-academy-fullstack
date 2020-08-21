package se.experis.academy.maven_on_heroku.repository;

import org.springframework.data.repository.CrudRepository;
import se.experis.academy.maven_on_heroku.model.Animal;

import java.util.List;

/**
 *  Represents the methods that can be accesed in the database
 */
public interface AnimalRepository extends CrudRepository<Animal, Long> {

    /**
     *  Gets all animals
     * @return List of animals
     */
    @Override
    List<Animal> findAll();

    /**
     *  Find animal by id
     * @param id id of animal
     * @return an animal
     */
    Animal findById(long id);
}
