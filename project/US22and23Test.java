import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for User story 22 and 23
 * @author Ziyou Shang
 */
public class US22and23Test {
    
    /**
     * Test of US22 method, of class US22and23.
     */
    @Test
    public void testUS22() {
        System.out.println("US22");
        Individual indi1 = new Individual();
        Individual indi2 = new Individual();
        Individual indi3 = new Individual();
        Individual indi4 = new Individual();
        Individual indi5 = new Individual();
        
        indi1.setId("I1");
        indi2.setId("I2");
        indi3.setId("I3");
        indi4.setId("I3");
        
        Family family1 = new Family();
        Family family2 = new Family();
        Family family3 = new Family();
        Family family4 = new Family();
        Family family5 = new Family();
        
        family1.setID("F1");
        family2.setID("F2");
        family3.setID("F3");
        family4.setID("F3");
        
        ArrayList<Individual> individualList1 = new ArrayList<>();
        ArrayList<Individual> individualList2 = new ArrayList<>();
        ArrayList<Individual> individualList3 = new ArrayList<>();
        ArrayList<Individual> individualList4 = new ArrayList<>();
        ArrayList<Individual> individualList5 = new ArrayList<>();
        
        ArrayList<Family> familyList1 = new ArrayList<>();
        ArrayList<Family> familyList2 = new ArrayList<>();
        ArrayList<Family> familyList3 = new ArrayList<>();
        ArrayList<Family> familyList4 = new ArrayList<>();
        ArrayList<Family> familyList5 = new ArrayList<>();
        
        individualList2.add(indi1);
        individualList2.add(indi2);
        individualList2.add(indi3);
        
        individualList3.add(indi1);
        individualList3.add(indi2);
        individualList3.add(indi3);
        individualList3.add(indi4);
        
        individualList4.add(indi1);
        individualList4.add(indi2);
        individualList4.add(indi3);
        individualList4.add(indi5);
        
        individualList5.add(indi1);
        individualList5.add(indi1);
        individualList5.add(indi2);
        individualList5.add(indi3);
        individualList5.add(indi3);
        individualList5.add(indi4);
        
        familyList2.add(family1);
        familyList2.add(family2);
        familyList2.add(family3);
        
        familyList3.add(family1);
        familyList3.add(family2);
        familyList3.add(family3);
        familyList3.add(family4);
        
        familyList4.add(family5);
        familyList4.add(family1);
        familyList4.add(family2);
        familyList4.add(family3);
        
        familyList5.add(family1);
        familyList5.add(family1);
        familyList5.add(family2);
        familyList5.add(family3);
        familyList5.add(family3);
        familyList5.add(family4);
        
        // test case with empty individual list and empty family list
        boolean expResult = true;
        boolean result = US22and23.US22(individualList1, familyList1);
        assertEquals(expResult, result);
        // normal situation with unique id
        assertTrue(US22and23.US22(individualList2, familyList2));
        // individualList contains 1 duplicate id
        assertFalse(US22and23.US22(individualList3, familyList2));
        // familyList contains 1 duplicate id
        assertFalse(US22and23.US22(individualList2, familyList3));
        // contains multiple duplicate id
        assertFalse(US22and23.US22(individualList4, familyList4));
        // contains individual and family without id
        assertFalse(US22and23.US22(individualList5, familyList5));
        
    }

    /**
     * Test of US23 method, of class US22and23.
     */
    @Test
    public void testUS23() {
        System.out.println("US23");
        Individual indi1 = new Individual();
        Individual indi2 = new Individual();
        Individual indi3 = new Individual();
        Individual indi4 = new Individual();
        Individual indi5 = new Individual();
        Individual indi6 = new Individual();
        
        indi1.setName("TI1");
        indi2.setName("TI2");
        indi3.setName("TI3");
        indi4.setName("TI3");
        indi5.setName("TI3");
        indi6.setName("TIE");
        
        indi1.setBirthday("1990-04-23");
        indi2.setBirthday("1998-04-23");
        indi3.setBirthday("1990-04-23");
        indi4.setBirthday("1990-04-20");
        indi5.setBirthday("1990-05-23");
        
        // test case with empty individual list
        ArrayList<Individual> individualList1 = new ArrayList<>();
        boolean expResult = true;
        boolean result = US22and23.US23(individualList1);
        assertEquals(expResult, result);
        
        ArrayList<Individual> individualList2 = new ArrayList<>();
        ArrayList<Individual> individualList3 = new ArrayList<>();
        ArrayList<Individual> individualList4 = new ArrayList<>();
        ArrayList<Individual> individualList5 = new ArrayList<>();
        
        individualList2.add(indi1);
        individualList2.add(indi2);
        individualList2.add(indi3);
        individualList2.add(indi4);
        
        individualList3.add(indi1);
        individualList3.add(indi2);
        individualList3.add(indi3);
        individualList3.add(indi4);
        individualList3.add(indi3);
        
        individualList4.add(indi1);
        individualList4.add(indi2);
        individualList4.add(indi3);
        individualList4.add(indi4);
        individualList4.add(indi2);
        individualList4.add(indi3);
        individualList4.add(indi5);
        
        individualList5.add(indi1);
        individualList5.add(indi2);
        individualList5.add(indi3);
        individualList5.add(indi4);
        individualList5.add(indi6);
        
        // normal situation without error
        assertTrue(US22and23.US23(individualList2));
        // contains 1 duplicate name and birth also 1 same name but different birth
        assertFalse(US22and23.US23(individualList3));
        // contains mutiple duplicate name and birth
        assertFalse(US22and23.US23(individualList4));
        // contains an individual with name but without birth
        assertFalse(US22and23.US23(individualList5));
    }
    
}
