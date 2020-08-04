# Ice and Fire API
This solution is made by Sebastian Porling

## Compile
Not sure if it is possible to compile without IDEA... You would need to include the **Gson** and **org.json** package. But you could compile like this without the IDEA while in src/main/java:
```bash
javac -d ../../../out/  *.java api/*.java
```
## Execute
If not using a IDEA do the following when in the out folder:
```bash
java Application
or
java Application <id>
or
java -jar IcaAndFireAPI.jar
or
java -jar IceAndFireAPI.jar <id>
```
## Motivation

Instead of just using the **org.json** package this solution is utilizing the **Gson** package as well. This to easy parse the JSON data to java objects. The Objects **Book**, **Character** and **House** represents how the data looks like in the API. Which makes it easy to get the data. Instead of using multiple **get** statements...
The **IceAndFireAPI** class has all the methods used for the HTTP requests. The method **getRequest(String)** is the one doing most of the work. It handles the connection and returns the response from the API. The other methods creates the different urls needed for getting the correct information from the API and parses the data with **Gson**. MAny methods utilizes the Stream API to create sets for characters and books.
The **Application** class handles all the printout and input for the user. It takes in the user id and prints out the character information. Then prompts of the user wants to see sworn members of the characters house. The last thing the class does is to print out all the characters for the books published by Bantam Books. It orders them in the following format with monospace font:

|Book|Book|Book|Book|Book|Book|
|----|----|----|----|----|----|
|Character|Character|Character|Character|Character|Character|
|Character|Character|Character|Character|Character|Character|

Quite tricky to make it look good in a console...
