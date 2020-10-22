import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.*;

import org.junit.jupiter.api.Test;

class US24and25Test extends HelperFuctions{
	
	ArrayList<Family> fl;

    
    Map<String, Individual> individualMap = new HashMap<String, Individual>();
    
	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		GedcomParse proj3 = new GedcomParse();
		proj3.readFile("TestForSprint1.ged");
		proj3.writeIntoIndividualList();
		proj3.writeIntofamilyList();
		fl = proj3.familyList;
	}
		
	
    @org.junit.jupiter.api.Test
    void US24() {
        System.out.println("US24");
        assertTrue(US24and25.US24(fl));
        
    }
    
    @org.junit.jupiter.api.Test
    void US25() {
        System.out.println("US25");
        assertTrue(US24and25.US25(fl));
        
    } 
    
    

}
