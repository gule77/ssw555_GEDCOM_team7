import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class US15and28Test extends HelperFuctions {
    Family f0 = new Family();
    Family f1 = new Family();
    Family f2 = new Family();
    Family f3 = new Family();
    Family f4 = new Family();
    Individual i49 = individualWithIdAndBirthday(49, 1966, 2, 12);
    Individual i50 = individualWithIdAndBirthday(50, 1966, 11, 12);
    Individual i51 = individualWithIdAndBirthday(51, 1966, 2, 12);
    Individual i52 = individualWithIdAndBirthday(52, 1953, 12, 12);
    Individual i53 = individualWithIdAndBirthday(53, 2000, 1, 2);

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        /*
        F0: 0 siblings, U15 true, U28 return "Family F0 have no child"
        F1: 14 siblings, U15 true
        F2: 15 siblings, U15 false
        F3: 20 siblings, U15 false

        F4: i49 was born on 1966-02-12,
            i50 was born on 1966-11-12,
            i51 was born on 1966-02-12,
            i52 was born on 1953-12-12
            i53 was born on 2000-01-2
            U15 true
            U28 return "Sort family F4's children by their ages in decreasing order: <I52, I49, I51, I50, I53>"
         */
        f0.setID("F0");
        f0.setChildren(new ArrayList<>());

        f1.setID("F1");
        f1.setChildren(new ArrayList<>());
        for (Individual child : individualWithSameBirthday(0, 13, 1995, 9, 3))
            f1.getChildren().add(child);

        f2.setID("F2");
        f2.setChildren(new ArrayList<>());
        for (Individual child : individualWithSameBirthday(14, 28, 1996, 8, 4))
            f2.getChildren().add(child);

        f3.setID("F3");
        f3.setChildren(new ArrayList<>());
        for (Individual child : individualWithSameBirthday(29, 48, 1996, 8, 4))
            f3.getChildren().add(child);

        f4.setID("F4");
        f4.setChildren(new ArrayList<>());
        f4.getChildren().add(i49);
        f4.getChildren().add(i50);
        f4.getChildren().add(i51);
        f4.getChildren().add(i52);
        f4.getChildren().add(i53);
    }

    @org.junit.jupiter.api.Test
    void US15() {
        System.out.println("US15-0-F0");
        assertTrue(US15and28.US15(f0));
        System.out.println("US15-1-F1");
        assertTrue(US15and28.US15(f1));
        System.out.println("US15-2-F2");
        assertFalse(US15and28.US15(f2));
        System.out.println("US15-3-F3");
        assertFalse(US15and28.US15(f3));
        System.out.println("US15-4-F4");
        assertTrue(US15and28.US15(f4));
    }

    @org.junit.jupiter.api.Test
    void US28() {
        System.out.println("US28-0-F4");
        assertEquals(US15and28.US28(f0), "Family F0 have no child");
        System.out.println("US28-1-F4");
        assertEquals(US15and28.US28(f4),
                "Sort family F4's children by their ages in decreasing order: <I52, I49, I51, I50, I53>");
    }
}