package se.experis.academy;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    void provideInput(String data){
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(sysOut);
    }

    @Test
    void printCorrectOutput() {
        String sb = "\nInput: 4242424242424242\n" +
                "Provided checksum: 2\n" +
                "Expected checksum: 2\n\n" +
                "Checksum: Valid\n" +
                "Digits: 16 (credit card)\n";
        String expected = sb.replaceAll("\n", "").replaceAll("\r", "");
        Integer[] numbers = {4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2};
        int providedChecksum = 2;
        int calculatedChecksum = 2;
        Main.print(numbers, providedChecksum, calculatedChecksum, true, true);
        final String cleanOutput = outContent.toString().replaceAll("\n", "").replaceAll("\r", "");
        assertEquals(expected, cleanOutput);
    }

    @Test
    void getUserInputFromArguments() {
        Integer[] expectedNumbers = {4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2};
        Integer[] numbers = Main.getUserInput("4242424242424242");
        for (int i = 0; i < expectedNumbers.length; i++) {
            assertEquals(expectedNumbers[i], numbers[i]);
        }
    }

    @Test
    void getUserInputFromScanner() {
        Integer[] expectedNumbers = {5, 1, 2, 3, 5, 1, 6, 2, 3, 1, 5, 6, 1, 8};
        provideInput("51235162315618");
        Integer[] numbers = Main.getUserInput();
        assertArrayEquals(expectedNumbers, numbers);
    }

    @Test
    void getUserInputHandlesEmpty() {
        provideInput("\n\r");
        Integer[] numbers = Main.getUserInput();
        assertEquals(0, numbers.length);
    }

    @Test
    void getUserInputHandlesNonNumeric() {
        provideInput("asba_)(!\"'sd'*^^");
        Integer[] numbers = Main.getUserInput();
        assertEquals(0, numbers.length);
    }

    @Test
    void getUserInputRemovesOtherCharactersFromArguments() {
        Integer[] expectedNumbers = {1, 2, 3, 4};
        Integer[] numbers = Main.getUserInput("abc1s2kh3.@!4");
        assertArrayEquals(expectedNumbers, numbers);
    }

    @Test
    void getUserInputHandlesNull() {
        provideInput("1");
        Integer[] numbers = Main.getUserInput( null);
        assertEquals(1, numbers.length);
    }

    @Test
    void getUserInputReturnsEmptyArray() {
        Integer[] numbers = Main.getUserInput("");
        assertEquals(0, numbers.length);
    }
}