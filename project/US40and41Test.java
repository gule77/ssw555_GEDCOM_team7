import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class US40and41Test {

	ArrayList<Family> fl;
  	ArrayList<Individual> il;


    
    
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
    void US40() {
        System.out.println("US40");
        assertEquals(US40and41.US40("I1"), 14);
        
    }
    
    @org.junit.jupiter.api.Test
    void US41() {
        System.out.println("US41");
        assertTrue(US40and41.US41(fl, il));
        
    } 

}
