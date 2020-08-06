package se.experis.academy.palindrome_checker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.experis.academy.palindrome_checker.models.Palindrome;
import se.experis.academy.palindrome_checker.services.PalindromeService;
import java.util.List;

/**
 * The web controller handles all web requests.
 */
@Controller
public class WebController {

    private final PalindromeService palindromeService;

    /**
     * Constructor
     * @param palindromeService for handling logic
     */
    public WebController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    /**
     * Gives the index page to the user
     * @param model used for mapping attribute
     * @return to index
     */
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("hideTable", true);
        return "index";
    }

    /**
     * Gets a list of palindromes and displays the table
     * @param sequences multiple sequences of words, characters, integers seperated with space
     * @param model used for mapping the attribute
     * @return to index
     */
    @GetMapping("/getPalindrome")
    public String getPalindromes(@RequestParam(value = "sequences") String sequences, Model model) {
        List<Palindrome> palindromes = palindromeService.getPalindromes(sequences);
        model.addAttribute("sequences", palindromes);
        model.addAttribute("hideTable", false);
        return "index";
    }
}
