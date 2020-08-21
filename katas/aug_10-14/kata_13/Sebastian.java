
import java.util.*;

public class Sebastian {
    private static boolean running = true;
    private static final Interpreter  interpreter = new Interpreter();
    public static void main(String[] args) {
        registerOperations();
        run();
    }

    static void registerOperations() {
        interpreter.registerOperation("+", new Add());
        interpreter.registerOperation("-", new Sub());
        interpreter.registerOperation("/", new Div());
        interpreter.registerOperation("*", new Mul());
    }

    static String getOperator(String line) {
        String operator = "";
        if (line.contains("+")) operator = "+";
        else if (line.contains("-")) operator = "-";
        else if (line.contains("/")) operator = "/";
        else if (line.contains("*")) operator = "*";
        return operator;
    }

    static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the calculator!");
        while (running) {
            System.out.println("Enter a calculation like: 2+3 or 5/2, enter 'q' to quit;");
            String line = scanner.nextLine();
            String[] numbers = line.split("[-+*/]");
            String operator = getOperator(line);
            if (numbers.length == 2) {
                try {
                    Integer num1 = Integer.parseInt(numbers[0]);
                    Integer num2 = Integer.parseInt(numbers[1]);
                    interpreter.performOperation(operator, num1, num2);
                } catch (Exception e) {
                    System.out.println("Not valid numbers, try again.");
                    continue;
                }
            } else if (line.contains("q")) running = false;
        }
        System.out.println("Thank you for using the calculator! :D ");
        scanner.close();
    }
}

class Interpreter {
    private final HashMap<String, Operation> operations = new HashMap<>();

    public void registerOperation(String operationName, Operation operation) {
        operations.put(operationName, operation);
    }

    public void performOperation(String operationName, Integer num1, Integer num2) {
        Operation operation = operations.get(operationName);
        if (operation != null) {
            operation.getResult(num1, num2);
        }
    }
}

class ResultPrinter {
    public static void print(Integer result) {
        System.out.println(result);
    }
}

interface Operation {
    public void getResult(Integer num1, Integer num2);
}

class Add implements Operation{

    @Override
    public void getResult(Integer num1, Integer num2) {
        ResultPrinter.print(num1 + num2);
    }

}

class Sub implements Operation{

    @Override
    public void getResult(Integer num1, Integer num2) {
        ResultPrinter.print(num1 - num2);
    }

}

class Mul implements Operation{

    @Override
    public void getResult(Integer num1, Integer num2) {
        ResultPrinter.print(num1 * num2);
    }

}

class Div implements Operation{

    @Override
    public void getResult(Integer num1, Integer num2) {
        ResultPrinter.print(num1 / num2);
    }

}