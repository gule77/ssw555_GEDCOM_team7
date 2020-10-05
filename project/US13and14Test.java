//package ssw555_GEDCOM_team7.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class US13and14Test extends HelperFuctions{
    Family f0 = new Family();
    Family f1 = new Family();
    Family f2 = new Family();
    Family f3 = new Family();
    Family f4 = new Family();
    Family f5 = new Family();
    Family f6 = new Family();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        /*
        F0: 5 children were born at 1995-09-3, 6 children were born at 1995-01-4; U13false, U14false;
        F1: 6 born 1995-09-3, 7 born 1996-08-4, 8 born 2000-05-1; U13true, U14false;
        F2: 1 born 2001-01-1, 1 born 2001-09-1, U13false, U14true
        F3: 1 born 2006-01-1, 1 born 2006-09-31, U13false
        F4: 1 born 2016-02-12, 1 born 2006-11-12, U13true
        F5: 5 born 2011-08-8, U14true
        F6: 6 born 2011-08-8, U14false
         */
        f0.setID("F0");
        f0.setChildren(new ArrayList<>());
        for(Individual child: individualWithSameBirthday(0, 4, 1995, 9, 3))
            f0.getChildren().add(child);
        for(Individual child: individualWithSameBirthday(5, 10, 1995, 1, 4))
            f0.getChildren().add(child);

        f1.setID("F1");
        f1.setChildren(new ArrayList<>());
        for(Individual child: individualWithSameBirthday(11, 16, 1995, 9, 3))
            f1.getChildren().add(child);
        for(Individual child: individualWithSameBirthday(17, 23, 1996, 8, 4))
            f1.getChildren().add(child);
        for(Individual child: individualWithSameBirthday(24, 31, 2000, 5, 1))
            f1.getChildren().add(child);

        f2.setID("F2");
        f2.setChildren(new ArrayList<>());
        f2.getChildren().add(individualWithIdAndBirthday(32, 2001, 1, 1));
        f2.getChildren().add(individualWithIdAndBirthday(33, 2001, 9, 1));

        f3.setID("F3");
        f3.setChildren(new ArrayList<>());
        f3.getChildren().add(individualWithIdAndBirthday(34, 2006, 1, 1));
        f3.getChildren().add(individualWithIdAndBirthday(35, 2006, 8, 31));

        f4.setID("F4");
        f4.setChildren(new ArrayList<>());
        f4.getChildren().add(individualWithIdAndBirthday(36, 1966, 2, 12));
        f4.getChildren().add(individualWithIdAndBirthday(37, 1966, 11, 12));

        f5.setID("F5");
        f5.setChildren(new ArrayList<>());
        for(Individual child: individualWithSameBirthday(38, 42, 2011, 8, 8))
            f5.getChildren().add(child);

        f6.setID("F6");
        f6.setChildren(new ArrayList<>());
        for(Individual child: individualWithSameBirthday(43, 48, 2011, 8, 8))
            f6.getChildren().add(child);
    }

    @org.junit.jupiter.api.Test
    void US13() {
        System.out.println("US13-1-F0");
        assertFalse(US13and14.US13(f0));
        System.out.println("US13-1-F1");
        assertTrue(US13and14.US13(f1));
        System.out.println("US13-1-F2");
        assertFalse(US13and14.US13(f2));
        System.out.println("US13-1-F3");
        assertFalse(US13and14.US13(f3));
        System.out.println("US13-1-F4");
        assertTrue(US13and14.US13(f4));
    }

    @org.junit.jupiter.api.Test
    void US14() {
        System.out.println("US14-1-F0");
        assertFalse(US13and14.US14(f0));
        System.out.println("US14-1-F1");
        assertFalse(US13and14.US14(f1));
        System.out.println("US14-1-F2");
        assertTrue(US13and14.US14(f2));
        System.out.println("US14-1-F5");
        assertTrue(US13and14.US14(f5));
        System.out.println("US14-1-F6");
        assertFalse(US13and14.US14(f6));
    }


}
