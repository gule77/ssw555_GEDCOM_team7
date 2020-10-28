package project;

import static org.junit.jupiter.api.Assertions.*;

public class US27and42Test extends HelperFuctions {
    @org.junit.jupiter.api.Test
    void US27() {
        Individual i0 = new Individual();
        i0.setId("i0");
        i0.setBirthday("1968-10-27");
        Individual i1 = new Individual();
        i1.setId("i1");
        i1.setBirthday("2000-05-9");
        Individual i2 = new Individual();
        i2.setId("i2");

        assertEquals(US27and42.US27(i0), "i0(52)");
        assertEquals(US27and42.US27(i1), "i1(20)");
        assertEquals(US27and42.US27(i2), "i2(unknown age)");
    }

    @org.junit.jupiter.api.Test
    void US42FamilyDate() {
        Family f0 = new Family();
        f0.setID("F0");
        f0.setMarried("1944-07-9");
        f0.setDivorced("2000-11-11");
        Family f1 = new Family();
        f1.setID("F1");
        f1.setMarried("1944-07-9");
        f1.setDivorced("2000-11-31");
        Family f2 = new Family();
        f2.setID("F2");
        f2.setMarried("1944-02-30");
        f2.setDivorced("2000-11-11");
        Family f3 = new Family();
        f3.setID("F3");
        Family f4 = new Family();
        f4.setID("F4");
        f4.setMarried("1944-02-30");
        f4.setDivorced("2000-11-31");

        assertTrue(US27and42.US42FamilyDate(f0));
        assertFalse(US27and42.US42FamilyDate(f1));
        assertFalse(US27and42.US42FamilyDate(f2));
        assertTrue(US27and42.US42FamilyDate(f3));
        assertFalse(US27and42.US42FamilyDate(f4));
    }

    @org.junit.jupiter.api.Test
    void US42IndividualDate() {
        Individual i0 = new Individual();
        i0.setId("i0");
        i0.setBirthday("1968-11-40");
        i0.setDeath("2000-11-31");
        Individual i1 = new Individual();
        i1.setId("i1");
        i1.setBirthday("2001-02-29");
        Individual i2 = new Individual();
        i2.setId("i2");
        Individual i3 = new Individual();
        i3.setId("i3");
        i3.setBirthday("1968-11-4");
        i3.setDeath("2000-11-3");
        Individual i4 = new Individual();
        i4.setId("i4");
        i4.setBirthday("1968-11-4");
        i4.setDeath("2000-11-34");

        assertFalse(US27and42.US42IndividualDate(i0));
        assertFalse(US27and42.US42IndividualDate(i1));
        assertTrue(US27and42.US42IndividualDate(i2));
        assertTrue(US27and42.US42IndividualDate(i3));
        assertFalse(US27and42.US42IndividualDate(i4));
    }
}
