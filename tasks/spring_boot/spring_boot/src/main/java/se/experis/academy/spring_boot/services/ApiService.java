package se.experis.academy.spring_boot.services;

import org.springframework.stereotype.Service;
import se.experis.academy.spring_boot.models.Greeting;
import java.util.Random;

/**
 * Handles all the API requests
 */
@Service("ApiService")
public class ApiService {
    private final String template = "Dear %s, we hope you will have an awesome day!";
    private final Random random = new Random();

    /**
     * Creates a greeting with the name
     * @param name string
     * @return greeting
     */
    public Greeting generateGreeting(String name) {
        return new Greeting(random.nextInt(Integer.MAX_VALUE), String.format(template, name));
    }

    /**
     * Reverses the greeting
     * @param greeting as string
     * @return reversed greeting
     */
    public Greeting reverseGreeting(String greeting) {
        String reversed = new StringBuilder(greeting).reverse().toString();
        return new Greeting(random.nextInt(Integer.MAX_VALUE), reversed);
    }
}
