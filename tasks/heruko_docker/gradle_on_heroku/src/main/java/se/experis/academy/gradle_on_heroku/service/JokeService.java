package se.experis.academy.gradle_on_heroku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.experis.academy.gradle_on_heroku.model.Joke;
import se.experis.academy.gradle_on_heroku.repository.JokeRepository;

import java.util.List;
import java.util.Random;

@Service
public class JokeService {

     @Autowired
    JokeRepository jokeRepository;

     public Joke getRandomJoke() {
         Random random = new Random();
         List<Joke> jokes = jokeRepository.findAll();
         return jokes.get(random.nextInt(jokes.size()-1));
     }

}
