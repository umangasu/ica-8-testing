import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;

import static org.junit.jupiter.api.Assertions.*;


class urinalsTest {

    urinals urinals;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        urinals = new urinals();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void inputMethod() throws Exception {
        System.out.println("====== Umang Sahastransu == TEST ONE EXECUTED =======");
        String testInputMethodString = "disk";
        assertEquals("-1", urinals.inputMethod(testInputMethodString));
    }

    @Test
    void openFile() {
        System.out.println("====== Umang Sahastransu == TEST TWO EXECUTED =======");
        String path = ".";
        assertThrows(IllegalArgumentException.class, () -> urinals.openFile(path));
    }

    @Test
    void validateString() {
        System.out.println("====== Umang Sahastransu == TEST THREE EXECUTED =======");
        String testString1 = "100001";
        assertThrows(IllegalArgumentException.class, () -> urinals.validateString(testString1));


        System.out.println("====== Umang Sahastransu == TEST FOUR EXECUTED =======");
        String testString2 = "";
        assertThrows(IllegalArgumentException.class, () -> urinals.validateString(testString2));

    }

    @Test
    void writeFile() {
        System.out.println("====== Umang Sahastransu == TEST FIVE EXECUTED =======");
        String output = "1011000";
        assertThrows(FileNotFoundException.class, () -> urinals.writeFile(output));
    }

    @Test
    void maxFreeUrinals() {
        System.out.println("====== Umang Sahastransu == TEST SIX EXECUTED =======");
        String inputString = "011";
        assertEquals(Integer.parseInt("-1"), urinals.maxFreeUrinals(inputString));
    }
}