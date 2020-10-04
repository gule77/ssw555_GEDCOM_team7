import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.*;

import org.junit.jupiter.api.Test;

class US08and09Test extends HelperFuctions{
	
	Family f0 = new Family();
    Family f1 = new Family();
    Family f2 = new Family();
    Family f3 = new Family();
    Family f4 = new Family();
    
    Individual i50 = new Individual();
    Individual i51 = new Individual();
    
    Individual i52 = new Individual();
    Individual i53 = new Individual();
    
    Individual i54 = new Individual();
    Individual i55 = new Individual();
    
    Individual i56 = new Individual();
    Individual i57 = new Individual();
    
    Individual i58 = new Individual();
    Individual i59 = new Individual();
    
    Map<String, Individual> individualMap = new HashMap<String, Individual>();
    
	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		//parents of f0
		i50.setId("I50");
		i50.setDeath("2008-08-08");
		i51.setId("I51");
		i51.setDeath("2018-08-30");
		//parents of f1
		i52.setId("I52");
		i52.setDeath("1999-08-08");
		i53.setId("I53");
		//parents of f2
		i54.setId("I54");
		i55.setId("I55");
		//parents of f3
		i56.setId("I56");
		i57.setId("I57");
		i57.setDeath("2005-10-20");
		//parents of f4
		i58.setId("I58");
		i58.setDeath("2005-01-19");
		i59.setId("I59");
		
		
		individualMap.put("I50", i50);
		individualMap.put("I51", i51);
		individualMap.put("I52", i52);
		individualMap.put("I53", i53);
		individualMap.put("I54", i54);
		individualMap.put("I55", i55);
		individualMap.put("I56", i56);
		individualMap.put("I57", i57);
		individualMap.put("I58", i58);
		individualMap.put("I59", i59);

		
		f0.setHusbandId("I50");
		f0.setWifeId("I51");
		f0.setMarried("1994-02-22");
		f0.setDivorced("2008-09-19");
        f0.setChildren(new ArrayList<>());
	    f0.getChildren().add(individualWithIdAndBirthday(0, 1996, 2, 12));
	    f0.getChildren().add(individualWithIdAndBirthday(1, 1997, 8, 28));
	    f0.getChildren().add(individualWithIdAndBirthday(2, 1999, 7, 22));
	    f0.getChildren().add(individualWithIdAndBirthday(3, 2005, 10, 19));
	    
	    f1.setHusbandId("I52");
	    f1.setWifeId("I53");
	    f1.setMarried("1999-02-22");
		f1.setDivorced("2008-09-19");
        f1.setChildren(new ArrayList<>());
	    f1.getChildren().add(individualWithIdAndBirthday(4, 1996, 2, 12));
	    f1.getChildren().add(individualWithIdAndBirthday(5, 1997, 8, 28));
	    f1.getChildren().add(individualWithIdAndBirthday(6, 1999, 7, 22));
	    f1.getChildren().add(individualWithIdAndBirthday(7, 2005, 10, 19));
	    
	    f2.setHusbandId("I54");
	    f2.setWifeId("I55");
	    f2.setMarried("1994-02-22");
		f2.setDivorced("2001-09-19");
        f2.setChildren(new ArrayList<>());
	    f2.getChildren().add(individualWithIdAndBirthday(8, 1996, 2, 12));
	    f2.getChildren().add(individualWithIdAndBirthday(9, 1997, 8, 28));
	    f2.getChildren().add(individualWithIdAndBirthday(10, 1999, 7, 22));
	    f2.getChildren().add(individualWithIdAndBirthday(11, 2005, 10, 19));
	    
	    f3.setHusbandId("I56");
	    f3.setWifeId("I57");
	    f3.setMarried("1996-02-11");
		f3.setDivorced("2008-09-19");
        f3.setChildren(new ArrayList<>());
	    f3.getChildren().add(individualWithIdAndBirthday(12, 1996, 2, 12));
	    f3.getChildren().add(individualWithIdAndBirthday(13, 1997, 8, 28));
	    f3.getChildren().add(individualWithIdAndBirthday(14, 1999, 7, 22));
	    f3.getChildren().add(individualWithIdAndBirthday(15, 2005, 10, 19));
	    
	    f4.setHusbandId("I58");
	    f4.setWifeId("I59");
	    f4.setMarried("1994-02-22");
		f4.setDivorced("2005-01-19");
        f4.setChildren(new ArrayList<>());
	    f4.getChildren().add(individualWithIdAndBirthday(16, 2005, 10, 19));
	}
	
    @org.junit.jupiter.api.Test
    void US08() {
        System.out.println("US08-1-F0");
        assertTrue(US08and09.US08(f0));
        System.out.println("US08-1-F1");
        assertFalse(US08and09.US08(f1));
        System.out.println("US08-1-F2");
        assertFalse(US08and09.US08(f2));
        System.out.println("US08-1-F3");
        assertTrue(US08and09.US08(f3));
        System.out.println("US08-1-F4");
        assertTrue(US08and09.US08(f4));
    }
    
    @org.junit.jupiter.api.Test
    void US09() {
        System.out.println("US09-1-F0");
        assertTrue(US08and09.US09(f0, individualMap));
        System.out.println("US09-1-F1");
        assertFalse(US08and09.US09(f1, individualMap));
        System.out.println("US09-1-F2");
        assertTrue(US08and09.US09(f2, individualMap));
        System.out.println("US09-1-F3");
        assertTrue(US08and09.US09(f3, individualMap));
        System.out.println("US09-1-F4");
        assertTrue(US08and09.US09(f4, individualMap));
    } 
    
    

}
