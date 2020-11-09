import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class US40and41 {
	  public static int US40(String id){
		  	
		  	
		    GedcomParse sp3 = new GedcomParse();
	        sp3.readFile("TestForSprint3.ged");
	        ArrayList<String> arr = sp3.dataGet;
	        
	        for (int i = 0; i < arr.size(); i++) {
	        	if (arr.get(i).contains(id)) {
	        		System.out.println("ERROR: FAMILY OR INDIVIDUAL: US40: 0: " + "Error about "  + id + " in line " + (i+1) + " in this GEDCOM file");

	        		return i + 1;
	        	}
	        }
    		System.out.println("The id not in the GEDCOM file");

			return 0;
	        
	   }
	  
	  public static boolean US41(ArrayList<Family> fl, ArrayList<Individual> il){
	        boolean res = true;

	        for (Family f : fl) {
	        	String marriageDate = f.getMarried();		       
	        	if (marriageDate.length() == 10 || marriageDate.length() == 9 || marriageDate.length() == 7 || marriageDate.length() == 4 || marriageDate == "NA") {
	        		res = true;
	        	}
	        	else {
	        		System.out.println("ERROR: FAMILY: US41: 0: " + f.getID() + " has a wrong format about the marriage date");

	        		res = false;
	        	}
	        	
	        	String divorceDate = f.getDivorced();
	        	if (divorceDate.length() == 10 || divorceDate.length() == 9 || divorceDate.length() == 7 || divorceDate.length() == 4 || divorceDate == "NA") {
	        		res = true;
	        	}
	        	else {
	        		System.out.println("ERROR: FAMILY: US41: 0: " + f.getID() + " has a wrong format about the divoece date");

	        		
	        		res = false;
	        	}
	        }
	        
	        for (Individual i : il) {
	        	String bitrh = i.getBirthday();
	        	if (bitrh.length() == 10 || bitrh.length() == 9 || bitrh.length() == 7 || bitrh.length() == 4 || bitrh == "NA") {
	        		res = true;
	        	}
	        	else {
	        		System.out.println("ERROR: INDIVIDUAL: US41: 0: " + i.getId() + " has a wrong format about the birth date");

	        		res = false;
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
			US40("I1");
			US41(fl, il);
	  }
}
