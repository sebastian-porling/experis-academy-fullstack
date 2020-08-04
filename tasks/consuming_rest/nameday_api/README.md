# NameDay API Application
This solution is made by Sebastian Porling

## Compile
This is using maven! So you have to get the necassary dependecies, especielly the org.json!
Otherwise compile like this while in src/main/java:
```bash
javac -d ../../../out/ .*java 
```

## Execute
Either with IntelliJ or do this while in out:
```bash
java Application.java
or
java -jar NamedayAPI.jar
```

## Motivation
The HTTP request is really basic and does only do GET requests to the API. The way of making the requests for different countries are made with a stream through the **Country** Enum class. It has the country codes for each enum which makes it easy to loop through with streams.
