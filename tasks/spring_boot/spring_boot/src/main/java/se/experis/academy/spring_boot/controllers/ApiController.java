package se.experis.academy.spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.experis.academy.spring_boot.models.Greeting;
import se.experis.academy.spring_boot.services.ApiService;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping(value = "/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Anonymous") String name) {
        return apiService.generateGreeting(name);
    }

    @GetMapping(value = "/reverseGreeting")
    public Greeting reverseGreeting(@RequestParam(value = "greeting", defaultValue = "") String greeting) {
        return apiService.reverseGreeting(greeting);
    }
}
