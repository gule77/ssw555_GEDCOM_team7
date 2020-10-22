import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for user story 10
 * @author Ziyou Shang
 */
public class US10and11Test {

    /**
     * Test of us10 method, of class US10and11.
     */
    @org.junit.jupiter.api.Test
    public void testUs10() {
        System.out.println("us10");
        
        Family family1 = new Family();
        Family family2 = new Family();
        Family family3 = new Family();
        Family family4 = new Family();
        
        Individual indi1 = new Individual();
        Individual indi2 = new Individual();
        Individual indi3 = new Individual();
        Individual indi4 = new Individual();
        Individual indi5 = new Individual();
        Individual indi6 = new Individual();
        Individual indi7 = new Individual();
        Individual indi8 = new Individual();
        
        indi1.setId("I1");
        indi2.setId("I2");
        indi3.setId("I3");
        indi4.setId("I4");
        indi5.setId("I5");
        indi6.setId("I6");
        indi7.setId("I7");
        indi8.setId("I8");
        
        indi1.setName("TestI1");
        indi2.setName("TestI2");
        indi3.setName("TestI3");
        indi4.setName("TestI4");
        indi5.setName("TestI5");
        indi6.setName("TestI6");
        indi7.setName("TestI7");
        indi8.setName("TestI8");
        
        indi1.setBirthday("1960-01-10");
        indi2.setBirthday("1970-02-20");
        indi3.setBirthday("1980-04-13");
        indi4.setBirthday("1990-12-31");
        indi5.setBirthday("1975-11-23");
        indi6.setBirthday("1987-07-10");
        indi7.setBirthday("1994-02-14");
        indi8.setBirthday("1995-04-01");
        
        family1.setID("F1");
        family2.setID("F2");
        family3.setID("F3");
        family4.setID("F4");
        
        family1.setLine(1);
        family2.setLine(10);
        family3.setLine(100);
        family4.setLine(1000);
        
        family1.setMarried("1988-06-24");
        family2.setMarried("2004-07-11");
        family3.setMarried("2000-03-15");
        family4.setMarried("2005-05-30");
        
        family1.setHusbandId("I1");
        family1.setHusbandName("TestI1");
        family1.setWifeId("I2");
        family1.setWifeName("TestI2");
        
        family2.setHusbandId("I3");
        family2.setHusbandName("TestI3");
        family2.setWifeId("I4");
        family2.setWifeName("TestI4");
        
        family3.setHusbandId("I6");
        family3.setHusbandName("TestI6");
        family3.setWifeId("I5");
        family3.setWifeName("TestI5");
        
        family4.setHusbandId("I7");
        family4.setHusbandName("TestI7");
        family4.setWifeId("I8");
        family4.setWifeName("TestI8");
        
        ArrayList<Family> familyList1 = new ArrayList<>();
        ArrayList<Family> familyList2 = new ArrayList<>();
        ArrayList<Family> familyList3 = new ArrayList<>();
        ArrayList<Family> familyList4 = new ArrayList<>();
        ArrayList<Family> familyList5 = new ArrayList<>();
        
        familyList2.add(family1);
        
        familyList3.add(family1);
        familyList3.add(family2);
        
        familyList4.add(family1);
        familyList4.add(family3);
        
        familyList5.add(family1);
        familyList5.add(family2);
        familyList5.add(family3);
        familyList5.add(family4);
        
        ArrayList<Individual> individualList1 = new ArrayList<>();
        ArrayList<Individual> individualList2 = new ArrayList<>();
        individualList2.add(indi1);
        individualList2.add(indi2);
        individualList2.add(indi3);
        individualList2.add(indi4);
        individualList2.add(indi5);
        individualList2.add(indi6);
        individualList2.add(indi7);
        individualList2.add(indi8);
        
        // When no family is in the GEDCOM
        boolean expResult = true;
        boolean result = US10and11.us10(familyList1, individualList2);
        assertEquals(expResult, result);
        // When individuals are not successfully parsed
        assertFalse(US10and11.us10(familyList2, individualList1));
        // All marriages are 14 years after birth
        assertTrue(US10and11.us10(familyList2, individualList2));
        // Husband is less than 14 years old at marriage date
        assertFalse(US10and11.us10(familyList3, individualList2));
        // Wife is less than 14 years old at marriage date
        assertFalse(US10and11.us10(familyList4, individualList2));
        // Husband and wife from different families are less than 14 at marriage
        assertFalse(US10and11.us10(familyList5, individualList2));
        
    }

    /**
     * Test of us11 method, of class US10and11.
     */
    @org.junit.jupiter.api.Test
    public void testUs11() {
        System.out.println("us11");
        Family family1 = new Family();
        Family family2 = new Family();
        Family family3 = new Family();
        Family family4 = new Family();
        Family family5 = new Family();
        
        Individual indi1 = new Individual();
        Individual indi2 = new Individual();
        Individual indi3 = new Individual();
        Individual indi4 = new Individual();
        Individual indi5 = new Individual();
        Individual indi6 = new Individual();
        
        indi1.setId("I1");
        indi2.setId("I2");
        indi3.setId("I3");
        indi4.setId("I4");
        indi5.setId("I5");
        indi6.setId("I6");
        
        indi1.setName("TestI1");
        indi2.setName("TestI2");
        indi3.setName("TestI3");
        indi4.setName("TestI4");
        indi5.setName("TestI5");
        indi6.setName("TestI6");
        
        indi1.setBirthday("1960-01-10");
        indi2.setBirthday("1970-02-20");
        indi3.setBirthday("1980-04-13");
        indi4.setBirthday("1990-12-31");
        indi5.setBirthday("1975-11-23");
        indi6.setBirthday("1987-07-10");
        
        indi1.setAlive(true);
        indi2.setAlive(true);
        indi3.setAlive(true);
        indi4.setAlive(true);
        indi5.setAlive(false);
        indi6.setAlive(false);
        
        indi5.setDeath("1990-01-10");
        indi6.setDeath("1990-11-12");
        
        family1.setID("F1");
        family2.setID("F2");
        family3.setID("F3");
        family4.setID("F4");
        family5.setID("F5");
        
        family1.setLine(1);
        family2.setLine(10);
        family3.setLine(100);
        family4.setLine(1000);
        family5.setLine(2000);
        
        family1.setMarried("1988-06-24");
        family2.setMarried("2004-07-11");
        family3.setMarried("2004-03-15");
        family4.setMarried("1987-05-30");
        family5.setMarried("1987-08-19");
        
        family1.setHusbandId("I1");
        family1.setHusbandName("TestI1");
        family1.setWifeId("I2");
        family1.setWifeName("TestI2");
        
        family2.setHusbandId("I1");
        family2.setHusbandName("TestI1");
        family2.setWifeId("I3");
        family2.setWifeName("TestI3");
        family1.setDivorced("2004-07-12");
        
        family3.setHusbandId("I4");
        family3.setHusbandName("TestI4");
        family3.setWifeId("I2");
        family3.setWifeName("TestI2");
        
        family4.setHusbandId("I1");
        family4.setHusbandName("TestI1");
        family4.setWifeId("I5");
        family4.setWifeName("TestI5");
        
        family5.setHusbandId("I6");
        family5.setHusbandName("TestI6");
        family5.setWifeId("I2");
        family5.setWifeName("TestI2");
        
        ArrayList<Family> familyList1 = new ArrayList<>();
        ArrayList<Family> familyList2 = new ArrayList<>();
        ArrayList<Family> familyList3 = new ArrayList<>();
        ArrayList<Family> familyList4 = new ArrayList<>();
        ArrayList<Family> familyList5 = new ArrayList<>();
        
        familyList1.add(family1);
        
        familyList2.add(family1);
        familyList2.add(family2);
        
        familyList3.add(family1);
        familyList3.add(family3);
        
        familyList4.add(family1);
        familyList4.add(family4);
        
        familyList5.add(family5);
        familyList5.add(family1);
        
        ArrayList<Individual> individualList1 = new ArrayList<>();
        ArrayList<Individual> individualList2 = new ArrayList<>();
        individualList2.add(indi1);
        individualList2.add(indi2);
        individualList2.add(indi3);
        individualList2.add(indi4);
        individualList2.add(indi5);
        individualList2.add(indi6);
        
        boolean expResult = true;
        boolean result = US10and11.us11(familyList1, individualList1);
        assertEquals(expResult, result);
        
        assertFalse(US10and11.us11(familyList2, individualList1));
        assertFalse(US10and11.us11(familyList2, individualList2));
        assertFalse(US10and11.us11(familyList3, individualList2));
        assertFalse(US10and11.us11(familyList4, individualList2));
        assertFalse(US10and11.us11(familyList5, individualList2));
        
    }
    
}
