import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for US43 and US52
 * @author Ziyou Shang
 */
public class US43and52Test {
    
    
    /**
     * Test of US43 method, of class US43and52.
     */
    @Test
    public void testUS43() {
        System.out.println("US43");
        
        Individual indi1 = new Individual();
        Individual indi2 = new Individual();
        Individual indi3 = new Individual();
        Individual indi4 = new Individual();
        Individual indi5 = new Individual();
        
        indi1.setId("I1");
        indi2.setId("I2");
        indi3.setId("I3");
        indi4.setId("I4");
        indi5.setId("I5");
        
        indi1.setGender("M");
        indi2.setGender("M");
        indi3.setGender("F");
        indi4.setGender("F");
        
        ArrayList<Individual> individualList = new ArrayList<>();
        boolean expResult = false;
        boolean result = US43and52.US43(individualList);
        assertEquals(expResult, result);
        
        ArrayList<Individual> individualList2 = new ArrayList<>();
        individualList2.add(indi1);
        individualList2.add(indi2);
        assertTrue(US43and52.US43(individualList2));
        
        ArrayList<Individual> individualList3 = new ArrayList<>();
        individualList3.add(indi3);
        individualList3.add(indi4);
        assertTrue(US43and52.US43(individualList3));
        
        ArrayList<Individual> individualList4 = new ArrayList<>();
        individualList4.add(indi1);
        individualList4.add(indi2);
        individualList4.add(indi3);
        individualList4.add(indi4);
        individualList4.add(indi5);
        assertTrue(US43and52.US43(individualList4));
        
        ArrayList<Individual> individualList5 = new ArrayList<>();
        individualList5.add(indi5);
        assertFalse(US43and52.US43(individualList5));
    }

    /**
     * Test of US52 method, of class US43and52.
     */
    @Test
    public void testUS52() {
        System.out.println("US52");
        
        Individual c1 = new Individual();
        
        c1.setId("C1");
        
        List<Individual> cList1 = new ArrayList<>();
        List<Individual> cList2 = new ArrayList<>();
        
        cList1.add(c1);
        
        Family f1 = new Family();
        Family f2 = new Family();
        Family f3 = new Family();
        
        f1.setID("F1");
        f2.setID("F2");
        f3.setID("F3");
        
        f2.setChildren(cList1);
        f3.setChildren(cList2);
         
        ArrayList<Family> familyList = new ArrayList<>();
        boolean expResult = false;
        boolean result = US43and52.US52(familyList);
        assertEquals(expResult, result);
        
        ArrayList<Family> familyList2 = new ArrayList<>();
        familyList2.add(f1);
        assertTrue(US43and52.US52(familyList2));
        
        ArrayList<Family> familyList3 = new ArrayList<>();
        familyList3.add(f2);
        assertFalse(US43and52.US52(familyList3));
        
        ArrayList<Family> familyList4 = new ArrayList<>();
        familyList4.add(f3);
        assertTrue(US43and52.US52(familyList4));
        
        ArrayList<Family> familyList5 = new ArrayList<>();
        familyList5.add(f1);
        familyList5.add(f2);
        familyList5.add(f3);
        assertTrue(US43and52.US52(familyList5));
    }
    
}
