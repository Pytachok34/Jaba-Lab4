import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReaderTests {

    @org.junit.jupiter.api.Test
    void testGetListFromFile() {
        Reader rd = new Reader();

        var list = rd.getListFromFile("src/files/foreign_names.csv");

        assertEquals(25898, list.size());
    }

    @org.junit.jupiter.api.Test
    void firstTestDataValidations() {
        Reader rd = new Reader();

        Exception ex = assertThrows(RuntimeException.class, ()->{
            rd.checkDataValidity(List.of("1","5"));
        });

        assertEquals("Invalid lines of data in file", ex.getMessage());
    }

    @org.junit.jupiter.api.Test
    void secondTestDataValidations() {
        Reader rd = new Reader();

        Exception ex = assertThrows(RuntimeException.class, ()->{
            rd.checkDataValidity(List.of("-55","Vasya", "Male", "15.02.2003", "A", "2000"));
        });

        assertEquals("Invalid employee id", ex.getMessage());
    }

    @org.junit.jupiter.api.Test
    void thirdTestDataValidations() {
        Reader rd = new Reader();

        Exception ex = assertThrows(RuntimeException.class, ()->{
            rd.checkDataValidity(List.of("55","Vasya", "email", "15.02.2003", "A", "2000"));
        });

        assertEquals("Invalid gender", ex.getMessage());
    }

    @org.junit.jupiter.api.Test
    void fourthTestDataValidations() {
        Reader rd = new Reader();

        Exception ex = assertThrows(RuntimeException.class, ()->{
            rd.checkDataValidity(List.of("55","Vasya", "Male", "1555.02.2003", "A", "2000"));
        });

        assertEquals("Invalid data", ex.getMessage());
    }
}