# Spring Boot Task

This solution is made by Sebastian Porling

## Compile

You can import this project to an IDE and import the necassary packages with maven.

## Execute

Either through IDE or you can use the jar file!:

```bash
java -jar spring_boot.jar
```

## Motivation

The class **WebController** just takes care of the webmapping for the **Index.html**. While the **ApiController** handles all the requests for getting greetings and revearsing them. It uses the **ApiService** which actually generates and manipulates the greetings. It returns the **Greeting** object which will look like JSON data when returned. The **BasicErrorController** just redirects the user to a custom error page.
The **index.html** uses bootstrap and changes the **DOM** with javascript instead of using normal HTTP requests. The javascript file **main.js** handles the API requests and displayes the greeting. The css is mostly based on **Bootstrap** but some small changes have been made with **style.css** and **error.css**.
