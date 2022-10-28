import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void getString() {
        System.out.println("====== Umang Sahastransu == TEST ONE EXECUTED =======");
        assertEquals(false, urinals.getString());
    }

    @org.junit.jupiter.api.Test
    void inputMethod() throws Exception {
        assertEquals("-1", urinals.inputMethod("disk"));
    }

    @Test
    void openFile() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> {urinals.openFile("/Users/umangsahastransu/Desktop/Foundation of Software Eng(SER 515)/Assignments/ICA_8_Testing");},
                "Exception was expected"
        );
        Assertions.assertEquals("urinal.dat file not found in the given path", thrown.getMessage());
    }

}