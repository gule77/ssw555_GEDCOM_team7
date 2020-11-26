import java.util.ArrayList;
import java.util.HashSet;

public class US44and45 {
	public static HashSet<String> US44(ArrayList<Family> fl, ArrayList<Individual> il){
        
        HashSet<String> set = new HashSet<>();
        
        for (Family f : fl) {
        	if (!f.getDivorced().equals("NA")) {
//	        	System.out.println("Family " + f.getID() + " is a single parent family, because divorced");
//	        	System.out.println(f.getDivorced());
        		set.add(f.getID());
        	}
        	String wifeID = f.getWifeID();
        	String husbandID = f.getHusbandID();
        	for (Individual i : il) {
        		if (i.getId().equals(wifeID)) {
        			if (!i.getIsAlive()) {
//        	        	System.out.println("Family " + f.getID() + " is a single parent family, because wife is not alive");

        				set.add(f.getID());
        			} 
            		
            	}
        		if (i.getId().equals(husbandID)) {
        			if (!i.getIsAlive()) {
//        	        	System.out.println("Family " + f.getID() + " is a single parent family, because husband is not alive");

        				set.add(f.getID());
        			}             	
        		}
        	}
        	
        }
        
        for (String s : set) {
        	System.out.println("Family " + s + " is a single parent family");
        }
        
        return set;
	}
	
public static Boolean US45(ArrayList<Family> fl){
        Boolean res = true;
        HashSet<String> set = new HashSet<>();
        
        for (Family f : fl) {
        	if (f.getChildren() != null) {
        		for (Individual i : f.getChildren()) {
        			if (set.contains(i.getId())) {
        				res = false;
        	        	System.out.println("ERROR: Individual: US45: 0: " + i.getId() + " is not a unique child");

        			}
        			set.add(i.getId());
        		}
        	}
        }
        
        
        return res;
	}
	
	 public static void main(String[] args) {
		  	ArrayList<Family> fl;
		  	ArrayList<Individual> il;

			GedcomParse proj3 = new GedcomParse();
			proj3.readFile("TestForSprint1.ged");
			proj3.writeIntoIndividualList();
			proj3.writeIntofamilyList();
			fl = proj3.familyList;
			il = proj3.individualList;
			US44(fl, il);
			US45(fl);
	  }
}
