//package src;
import java.util.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


public class US46and47Test{
    //initiate test data
    Family fam1 = new Family();
    Family fam2 = new Family();
    Individual p11 = new Individual();
    Individual p12 = new Individual();
    Individual p21 = new Individual();
    Individual p212 = new Individual();
    Individual p31 = new Individual();
    Individual p32 = new Individual();
    List<Individual> individualList = new ArrayList<>();
    List<Family> familyList = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        new US46and47();
        p11.setId("p11");
        p11.setName("p11");
        p11.setAge(70);
        p11.setAlive(true);
        p12.setId("p12");
        p12.setName("p12");
        p12.setAge(68);
        p12.setAlive(false);
        p21.setId("p21");
        p21.setName("p21");
        p21.setAge(50);
        p21.setAlive(true);
        p212.setId("p212");
        p212.setName("p212");
        p212.setAge(48);
        p212.setAlive(true);
        p31.setId("p31");
        p31.setName("p31");
        p31.setAge(27);
        p31.setAlive(true);
        p32.setId("p31");
        p32.setName("p31");
        p32.setAge(25);
        p32.setAlive(true);
        individualList.add(p11);
        individualList.add( p12);
        individualList.add( p21);
        individualList.add(p212);
        individualList.add(p31);
        individualList.add(p32);
        fam1.setID("fam1");
        fam1.setHusbandName("p11");
        fam1.setWifeName("p12");
        List<Individual> fam1_children = new ArrayList<>();
        fam1_children.add(p21);
        fam1.setChildren(fam1_children);
        fam2.setID("fam2");
        fam2.setHusbandName("p21");
        fam2.setWifeName("p212");
        List<Individual> fam2_children = new ArrayList<>();
        fam2_children.add(p31);
        fam2_children.add(p32);
        fam2.setChildren(fam2_children);
        familyList.add(fam1);
        familyList.add(fam2);


    }

    //US46
    @org.junit.jupiter.api.Test
    void US46() {
        assertEquals(US46and47.US46(individualList), "DATA: US46: DATA: INDIVIDUAL: p11: 70; p12: 68; p21: 50; p212: 48; p31: 27; p31: 25;");
    }

    @org.junit.jupiter.api.Test
    void US47() {
        assertEquals(US46and47.US47(familyList), "DATA US47: DATA: Family ID: fam2 has the most children with 2 children");
    }

}
