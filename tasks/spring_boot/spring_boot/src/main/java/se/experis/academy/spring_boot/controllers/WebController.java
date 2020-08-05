package se.experis.academy.spring_boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles all mapping of webpages
 */
@Controller()
public class WebController {

    /**
     * Returns the webpage at index.html
     * @return index.html
     */
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }
}
