package se.experis.academy.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

/**
 * An application that has a webpage at /
 * which can generate a greeting and reverse it.
 */
@SpringBootApplication
public class Application {

    /**
     * Main startup
     * @param args ignored
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
