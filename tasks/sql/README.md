# SQL task

This solution is made by Sebastian Porling

## Compile

This solution is made with maven so you could import this project to IntelliJ to compile.

## Execute

You can run it through IntelliJ with maven or install the package **org.xerial**, I have included a jar file so you can execute the program.

```bash
java -jar ChinookDatabaseSQL.jar
```

## Motivation

The project follows a MVC structure. The view handles all the input and the printout to the screen. The controller handles all the communication between the view and the model and integration layer.
The model has Java objects for the necissary data we get from the Chinook Database.
Most of the action happens in the integration layer as most of the logic is to gather data. It uses a simple java sql connection and handles it with prepared statements. We use SQL queries that gives us the data we need for the customer, "name", "id" and "popular genre". We calculate The total sales with a sum sql query.

The most interesting or "complex" query is done in **getCustomerMostPopularGenre(int customerId)**, which has three nestled select statements and then makes a inner join to get all the genres for the tracks the customer have bought.
