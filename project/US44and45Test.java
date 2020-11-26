import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class US44and45Test {

	ArrayList<Family> fl;
  	ArrayList<Individual> il;
  	HashSet<String> set = new HashSet<>();
  	


    
    
	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		GedcomParse proj3 = new GedcomParse();
		proj3.readFile("TestForSprint1.ged");
		proj3.writeIntoIndividualList();
		proj3.writeIntofamilyList();
		fl = proj3.familyList;
		il = proj3.individualList;
	}
		
	
    @org.junit.jupiter.api.Test
    void US44() {
        System.out.println("US44");
        set.add("F2");   	
      	set.add("F3");
        assertEquals(US44and45.US44(fl, il), set);
        
    }
    
    @org.junit.jupiter.api.Test
    void US45() {
        System.out.println("US45");
        assertTrue(US44and45.US45(fl));
        
    } 

}
