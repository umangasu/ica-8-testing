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

}