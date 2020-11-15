import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class US48and49 {
	public static boolean US48(List<Individual> individualList) {
		boolean res = true;
		List<Individual> MinorList = new ArrayList<>();
		for(Individual person: individualList) {
			if(person.getIsAlive()) {
				int Age = person.getAge();
				if(Age<18) {
					MinorList.add(person);
				}
			}
		}
		if(MinorList.isEmpty()) {
			res = true;
		}else {
			for (Individual person : MinorList) {
				System.out.println("DATA: US48: "+person.getId()+"("+person.getAge()+")"+" is minor");				 
			}
			res = false;
		}
		return res;
	}
	
	public static boolean US49(Family family,Map<String, Individual> individualMap) throws ParseException {
		boolean result = true;
		String HusbandID = family.getHusbandID();
		String WifeID = family.getWifeID();
    	Individual husband = individualMap.get(HusbandID);
    	Individual wife = individualMap.get(WifeID);
    	if(husband!=null&&wife!=null&&husband.getIsAlive()&&wife.getIsAlive()) {
    		int HusbandAge = husband.getAge();
    		int WifeAge = wife.getAge();
    		if(HusbandAge==WifeAge) {
    			System.out.println("DATA: US49: "+family.getID()+": "+husband.getId()+"("+husband.getAge()+")"+" and "+wife.getId()+
    					"("+wife.getAge()+") are the same age");
    			result = false;
    		}
    	}
		return result;
	}
}
