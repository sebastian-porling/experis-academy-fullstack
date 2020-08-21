package se.experis.academy.gradle_on_heroku.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.experis.academy.gradle_on_heroku.model.Joke;

import java.util.List;

public interface JokeRepository extends CrudRepository<Joke, Long> {

    @Override
    List<Joke> findAll();

}
