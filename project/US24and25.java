import java.util.*;

/*
    Sprint2
    US24 and 25
    @author Yichao Jia
    @date Oct 22 2020
 */


public class US24and25 {
	  public static boolean US24(ArrayList<Family> fl){
	        boolean res = true;
	        Map<String, String> map  = new HashMap<String, String>();

	        for (Family f : fl) {
	        	String familyId = f.getID();
	        	String marriageDate = f.getMarried();
	 	        String hasbandName = f.getHusbandName();
	 	        String wifeName = f.getWifeName();
	 	        String info = hasbandName + " " + wifeName + " " + marriageDate;
	 	        if (map.get(info) == null) {
		 	        map.put(info, familyId);
	 	        }
	 	        else {
	        		System.out.println("ANOMALY: FAMILY: US24: 0: " + map.get(info) + " and " + familyId + ": " + "The two families have same spouses by name and tmarriage date");

	 	        	res = false;
	 	        }
	        }
	        return res;
	   }
	  
	  public static boolean US25(ArrayList<Family> fl){
	        boolean res = true;

	        for (Family f : fl) {
	        	String familyId = f.getID();
	        	List<Individual> childrenList = f.getChildren();
	        	//each family has a map to store the 
		        Map<String, String> map  = new HashMap<String, String>();
		        if (childrenList != null) {
		        	for (Individual i : childrenList) {
		        		
		        		String childId = i.getId();
		        		String childName = i.getName();
		        		String childBirth = i.getBirthday();
			 	        String info = childName + " " + childBirth;
			 	     
			 	        
			 	       if (map.get(info) == null) {
				 	        map.put(info, familyId);
			 	        }
			 	        else {
			        		System.out.println("ANOMALY: FAMILY: US25: 0: " + familyId + ": " + "child " + map.get(info) + " and " + "child " + childId + " have same name and bith date");

			 	        	res = false;
			 	        }

		        	}
		        }
	        	
	 	        
	        }
	        return res;
	   }
	  
	  public static void main(String[] args) {
			ArrayList<Family> fl;

			GedcomParse proj3 = new GedcomParse();
			proj3.readFile("TestForSprint1.ged");
			proj3.writeIntoIndividualList();
			proj3.writeIntofamilyList();
			fl = proj3.familyList;
			
			US25(fl);
	  }
}
