package assignment04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

// Test by Bin Sun on 10/22/2020

class US16and29Test {
// Test US16
	@org.junit.jupiter.api.Test
    public void testUS16(){
        US16and29 sprint2 = new US16and29();
        Individual p1 = new Individual();
        p1.setId("001");
        p1.setLastName("Sun");
        Individual p2 = new Individual();
        p2.setId("002");
        p2.setLastName("Wang");
        ArrayList<Individual> childrenList = new ArrayList<>();
        childrenList.add(p1);
        childrenList.add(p2);
        Family f1 = new Family();
        f1.setMarried("2021-01-01");
        f1.setChildren(childrenList);
        f1.setHusbandLastName("Sun");
        f1.setID("F007");
        ArrayList<Individual> person = new ArrayList<Individual>();
        person.add(p1);
        person.add(p2);
        ArrayList<Family> fam = new ArrayList<Family>();
        fam.add(f1);
        assertEquals(false, sprint2.US16(fam, person));
    }
// Test US29
	@org.junit.jupiter.api.Test
	public void testUS29()
    {
		US16and29 sprint2 = new US16and29();
        Individual p1 = new Individual();
        Individual p2 = new Individual();
        Individual p3 = new Individual();
        ArrayList<Individual> person = new ArrayList<Individual>();

        p1.setId("Sp3I1");
        p2.setId("Sp3I2");
        p3.setId("Sp3I3");
        p1.setFirstName("ABC");
        p2.setFirstName("DEF");
        p3.setFirstName("GHI");
        p1.setLastName("XYZ");
        p2.setLastName("XYZ");
        p3.setLastName("XYZ");

        p1.setDeath("2000-08-01");
        p2.setDeath("2000-10-01");
        p3.setDeath("2000-09-01");

        
        p1.setAlive(false);
        p2.setAlive(false);
        p3.setAlive(false);
        
        person.add(p1);
        person.add(p2);
        person.add(p3);

        assertEquals(true, sprint2.US29(person));
    }
	
}
