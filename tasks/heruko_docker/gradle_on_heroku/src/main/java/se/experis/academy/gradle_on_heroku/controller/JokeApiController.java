package se.experis.academy.gradle_on_heroku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.experis.academy.gradle_on_heroku.model.Joke;
import se.experis.academy.gradle_on_heroku.repository.JokeRepository;
import se.experis.academy.gradle_on_heroku.service.JokeService;


@RestController
public class JokeApiController {

    @Autowired
    JokeService jokeService;

    @GetMapping("/joke")
    public Joke getRandomJoke() {
        return jokeService.getRandomJoke();
    }
}
