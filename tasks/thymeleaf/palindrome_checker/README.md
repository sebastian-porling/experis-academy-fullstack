# Palindrome Checker Task

This solution is made by Sebastian Porling.

## Compile

You can import this project to an IDE and import the necassary packages with maven.

## Execute

Either through IDE or you can use the jar file!:

```bash
java -jar palindrome_checker-1.jar
```

## Motivation

The class **WebController** handles all the web requests that are valid, for **/** and **/getPalindrom**, the rest is handled by the **BasicErrorController** which redirects the user to a error page.

The service **PalindromeService** is basically the same as the one I made in the kata. The difference is that it take it splits the string at spaces and newlines and checks the array of strings and returns a list of **Palindrome** objects. The **Palindrome** object consists of the original text, boolean if it is a palindrome and then the palindrome text.

These palindromes are set as an attribute and then the user is redirected to the same page, except that the table is now shown which was also set in the attributes.

The **index.html** uses thymeleaf to generate the table and show the table. I use the **th:each** to iterate the list.