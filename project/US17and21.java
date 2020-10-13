import java.util.*;

public class US17and21 {
	/*
	 * If parents do not marry their descendant, return true
	 */
	public static boolean US17(Family family) {
		boolean result = true;
		String HusbandID = family.getHusbandID();
		String WifeID = family.getWifeID();
		
		List<Individual> ChildList = family.getChildren();
		
		if(ChildList!=null) {
			for(Individual child: ChildList) {
				
					String ChildID=child.getId();
					
					//If there is a husband, and the husband ID and child ID are the same, output error message
					if(HusbandID!=null&&!HusbandID.equals("NA")&&HusbandID.equals(ChildID)){
//						System.out.println(ID1+" "+ID3);
						result = printError(family, HusbandID, ChildID);
					
					//If there is a wife, and the wife ID and child ID are the same, output error message	
					}else if(WifeID!=null&&!WifeID.equals("NA")&&WifeID.equals(ChildID)){
//						System.out.println(ID2+" "+ID3);
						result = printError(family, WifeID, ChildID);
					}
				
			}
		}
		return result;	
	}

	private static boolean printError(Family family, String ParentID, String ChildID) {
		boolean result;
		System.out.println("ERROR: FAMILY: US17: "+family.getLine()+": "+family.getID()+
				": "+"Parent ("+ParentID+") should not marry the child ("+ChildID+")");
		result = false;
		return result;
	}
	
	public static boolean US21(Family f, Map<String, Individual> individualMap){
		boolean res = true;
		String husbandID = f.getHusbandID();
    	String wifeID = f.getWifeID();
    	Individual husband = individualMap.get(husbandID);
    	Individual wife = individualMap.get(wifeID);
    	String husbandGender= husband.getGender();
    	String wifeGender=wife.getGender();
    	if(!husbandGender.equals("M")||!wifeGender.equals("F")) {
    		System.out.println("ERROR: FAMILY: US21: "+f.getLine()+": "+f.getID()+": Gender errors in family members");
    		res = false;
    	}
		return res;	
	}
	
//	public static void main(String[] args) {
//		Family f1 = new Family();
//		Individual i1 = new Individual();
//		Individual i2 = new Individual();
//		Map<String, Individual> individualMap = new HashMap<String, Individual>();
//		f1.setID("f001");
//		i1.setId("I101");
//		i1.setSpouse("f001");
//		i1.setChild("f001");
//		i1.setBirthday("1908-01-01");
//		i2.setId("I102");
//		i2.setSpouse("f001");
//		i2.setBirthday("1918-01-30");
//		individualMap.put("I101", i1);
//		individualMap.put("I102", i2);
//		f1.setHusbandId("I101");
//		f1.setWifeId("I102");
//		f1.setChildren(new ArrayList<>());
//		f1.getChildren().add(i1);
//		
//		System.out.println("\n--------------------US17--------------------");
//
//		System.out.println(US17(f1, individualMap));
//	}
}
