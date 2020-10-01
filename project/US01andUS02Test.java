import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class US01andUS02Test {
    Individual i01 = new Individual();
    Individual i02 = new Individual();
    Individual i03 = new Individual();
    Individual i04 = new Individual();
    Individual i05 = new Individual();
    Family f1 = new Family();
    Family f2 = new Family();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //initial individual id and member
        i01.setId("i01");
        i02.setId("i02");
        i03.setId("i03");
        i04.setId("i04");
        i05.setId("i05");
        f1.setID("f1");
        f2.setID("f2");
        f1.setHusbandId("i01");
        f1.setWifeId("i02");
        f2.setHusbandId("i03");
        f2.setWifeId("i04");
        //initial birth date and dead date
        i01.setBirthday("1990-01-01");
        i02.setBirthday("1980-03-01");
        i03.setBirthday("1950-09-01");
        i03.setDeath("2010-12-10");
        i04.setBirthday("2099-01-01");
        i04.setDeath("2100-10-03");
        i05.setBirthday("2099-01-01");
        // initial family married and divorced date
        f1.setMarried("2010-02-10");
        f1.setDivorced("2019-10-13");
        f2.setMarried("1990-02-10");
        f2.setDivorced("2030-10-13");
        // initial individual Map
    }

    @org.junit.jupiter.api.Test
    void US01() throws ParseException {
        System.out.println("Test individual i01: ");
        assertTrue(US01and02.US01(i01));
        System.out.println("Test individual i02: ");
        assertTrue(US01and02.US01(i02));
        System.out.println("Test individual i03: ");
        assertTrue(US01and02.US01(i03));
        System.out.println("Test individual i04: ");
        assertFalse(US01and02.US01(i04));
        System.out.println("Test individual i05: ");
        assertFalse(US01and02.US01(i05));
        System.out.println("Test Family f1: ");
        assertTrue(US01and02.US01(f1));
        System.out.println("Test Family f2: ");
        assertFalse(US01and02.US01(f2));
    }

    @org.junit.jupiter.api.Test
    void US02() throws ParseException {
        System.out.println("Test family f1 and husband i01: ");
        assertTrue(US01and02.US02(f1, i01));
        System.out.println("Test family f1 and wife i02: ");
        assertTrue(US01and02.US02(f1, i02));
        System.out.println("Test family f1 and husband i03: ");
        assertTrue(US01and02.US02(f2, i03));
        System.out.println("Test family f2 and wife i04: ");
        assertFalse(US01and02.US02(f2, i04));
    }
}
