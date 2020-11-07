import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for US32 and US33
 * @author Ziyou Shang
 */
public class US32and33Test {
    

    /**
     * Test of US32 method, of class US32and33.
     */
    @Test
    public void testUS32() {
        System.out.println("US32");
        
        Individual c11 = new Individual();
        Individual c12 = new Individual();
        Individual c13 = new Individual();
        Individual c21 = new Individual();
        Individual c22 = new Individual();
        Individual c31 = new Individual();
        c11.setId("C11");
        c12.setId("C12");
        c13.setId("C13");
        c21.setId("C21");
        c22.setId("C22");
        c31.setId("C31");
        
        Family f1 = new Family();
        Family f2 = new Family();
        Family f3 = new Family();
        Family f4 = new Family();
        f1.setID("F1");
        f2.setID("F2");
        f3.setID("F3");
        f4.setID("F4");
        
        c11.setBirthday("1980-05-23");
        c12.setBirthday("1980-05-23");
        c13.setBirthday("1980-05-23");
        c21.setBirthday("1985-06-23");
        c22.setBirthday("1985-06-23");
        c31.setBirthday("1987-07-22");
        
        List<Individual> ch1 = new ArrayList<>();
        ch1.add(c11);
        ch1.add(c12);
        ch1.add(c13);
        ch1.add(c31);
        
        List<Individual> ch2 = new ArrayList<>();
        ch2.add(c11);
        ch2.add(c22);
        ch2.add(c31);
        
        List<Individual> ch3 = new ArrayList<>();
        ch3.add(c11);
        ch3.add(c12);
        ch3.add(c13);
        ch3.add(c21);
        ch3.add(c22);
        ch3.add(c31);
        
        List<Individual> ch4 = new ArrayList<>();
        
        f1.setChildren(ch1);
        f2.setChildren(ch2);
        f3.setChildren(ch3);
        f4.setChildren(ch4);
        
        ArrayList<Family> familyList = new ArrayList<>();
        familyList.add(f1);
        familyList.add(f2);
        familyList.add(f3);
        familyList.add(f4);
        boolean expResult = true;
        boolean result = US32and33.US32(familyList);
        assertEquals(expResult, result);
        
        ArrayList<Family> familyList2 = new ArrayList<>();
        familyList2.add(f2);
        assertFalse(US32and33.US32(familyList2));
        
        ArrayList<Family> familyList3 = new ArrayList<>();
        assertFalse(US32and33.US32(familyList3));
    }

    /**
     * Test of US33 method, of class US32and33.
     */
    @Test
    public void testUS33() {
        System.out.println("US33");
        
        Individual c1 = new Individual();
        Individual c2 = new Individual();
        Individual c3 = new Individual();
        Individual h1 = new Individual();
        Individual h2 = new Individual();
        Individual w1 = new Individual();
        Individual w2 = new Individual();
        
        Family f1 = new Family();
        Family f2 = new Family();
        Family f3 = new Family();
        Family f4 = new Family();
        Family f5 = new Family();
        Family f6 = new Family();
        Family f7 = new Family();
        f1.setID("F1");
        f2.setID("F2");
        f3.setID("F3");
        f4.setID("F4");
        f5.setID("F5");
        f6.setID("F6");
        f7.setID("F7");
        
        c1.setAge(5);
        c2.setAge(10);
        c3.setAge(20);
        
        c1.setId("C1");
        c2.setId("C2");
        c3.setId("C3");
        h1.setId("H1");
        h2.setId("H2");
        w1.setId("W1");
        w2.setId("W2");
        
        h1.setAlive(true);
        h2.setAlive(false);
        w1.setAlive(true);
        w2.setAlive(false);
        
        List<Individual> ch1 = new ArrayList<>();
        ch1.add(c1);
        
        List<Individual> ch2 = new ArrayList<>();
        ch2.add(c1);
        ch2.add(c2);
        
        List<Individual> ch3 = new ArrayList<>();
        ch3.add(c3);
        
        List<Individual> ch4 = new ArrayList<>();
        
        f1.setHusbandId("H2");
        f1.setWifeId("W2");
        f2.setHusbandId("H2");
        f2.setWifeId("W2");
        f3.setHusbandId("H2");
        f3.setWifeId("W2");
        f4.setHusbandId("H2");
        f4.setWifeId("W2");
        f5.setHusbandId("H1");
        f5.setWifeId("W2");
        f6.setHusbandId("H2");
        f6.setWifeId("W1");
        f7.setHusbandId("H1");
        f7.setWifeId("W1");
        
        f1.setChildren(ch1);
        f2.setChildren(ch2);
        f3.setChildren(ch3);
        f4.setChildren(ch4);
        f5.setChildren(ch1);
        f6.setChildren(ch2);
        f7.setChildren(ch1);
        
        ArrayList<Family> familyList = new ArrayList<>();
        ArrayList<Individual> individualList = new ArrayList<>();
        individualList.add(h1);
        individualList.add(h2);
        individualList.add(w1);
        individualList.add(w2);
        individualList.add(c3);
        familyList.add(f1);
        familyList.add(f2);
        familyList.add(f3);
        familyList.add(f4);
        familyList.add(f5);
        familyList.add(f6);
        familyList.add(f7);
        
        ArrayList<Family> familyList2 = new ArrayList<>();
        familyList2.add(f5);
        familyList2.add(f6);
        familyList2.add(f7);
        
        boolean expResult = true;
        boolean result = US32and33.US33(familyList, individualList);
        assertEquals(expResult, result);
        assertFalse(US32and33.US33(familyList2, individualList));
        
        ArrayList<Family> familyList3 = new ArrayList<>();
        assertFalse(US32and33.US33(familyList3, individualList));
    }
    
}
