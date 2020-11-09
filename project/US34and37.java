import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class US34and37 {
	public static boolean US34(Family family,Map<String, Individual> individualMap) throws ParseException {
		boolean result = true;
		String HusbandID = family.getHusbandID();
		String WifeID = family.getWifeID();
    	Individual husband = individualMap.get(HusbandID);
    	Individual wife = individualMap.get(WifeID);
    	if(husband!=null&&wife!=null) {
    		String MarryDate = family.getMarried();
    		String HusbandBirth = husband.getBirthday();
    		String WifeBirth = wife.getBirthday();
    		int HusbandAge = getAgeByMarry(HusbandBirth,MarryDate);
    		int WifeAge = getAgeByMarry(WifeBirth,MarryDate);
//    		System.out.println(HusbandAge+"  "+WifeAge);
    		if(HusbandAge>WifeAge*2||WifeAge>HusbandAge*2) {
    			System.out.println("DATA: US34: "+family.getID()+
    					": Older spouses are more than twice as old as younger spouses when married");
    			result = false;
    		}
    	}


		return result;
	}
	
	public static boolean US37(Family family,Map<String, Individual> individualMap) throws ParseException {
		boolean result = true;
		String HusbandID = family.getHusbandID();
		String WifeID = family.getWifeID();
    	Individual husband = individualMap.get(HusbandID);
    	Individual wife = individualMap.get(WifeID);
    	List<Individual> childList = family.getChildren();
    	String survivors ="";
    	if(childList!=null) {
    		for (Individual c : childList) {
    			if(c.getIsAlive()) {
    				if(survivors == "") {
    					survivors = survivors+c.getId();
    				}else {
    					survivors = survivors+" "+c.getId();
    				}
    				
    			}
    		}
		}
    	
    	if(husband!=null&&wife!=null) {
        	String HusbandDeath = husband.getDeath();
        	String WifeDeath = wife.getDeath();
        	
        	if(!husband.getIsAlive()&&!wife.getIsAlive()) {    		
        		if(getDayByDeath(HusbandDeath)<30||getDayByDeath(WifeDeath)<30) {
//        			System.out.println(":"+survivors+":");
        			if(survivors!="") {
            			System.out.println("DATA: US37: "+family.getID()+
            					": All living spouses and descendants of a person who died in the last 30 days: descendants("+survivors+
            					") / spouse(none)");
                		result=false;
        			}
        		}
        	}else if(!husband.getIsAlive()) {
        		if(getDayByDeath(HusbandDeath)<30) {
        			if(survivors!="") {
            			System.out.println("DATA: US37: "+family.getID()+
            					": All living spouses and descendants of a person("+husband.getId()+
            					") who died in the last 30 days: descendants("+survivors+") / spouse("+WifeID+")");
        			}else {
            			System.out.println("DATA: US37: "+family.getID()+
            					": All living spouses and descendants of a person("+husband.getId()+
            					") who died in the last 30 days: descendants(none) / spouse("+WifeID+")");
        			}

        			result=false;
        		}
        	}else if(!wife.getIsAlive()) {
        		if(getDayByDeath(WifeDeath)<30) {
        			if(survivors!="") {
            			System.out.println("DATA: US37: "+family.getID()+
            					": All living spouses and descendants of a person("+wife.getId()+
            					") who died in the last 30 days: descendants("+survivors+") / spouse("+HusbandID+")");
        			}else {
            			System.out.println("DATA: US37: "+family.getID()+
            					": All living spouses and descendants of a person("+wife.getId()+
            					") who died in the last 30 days: descendants(none) / spouse("+HusbandID+")");
        			}

        			result=false;
        		}
        	}
    	}else if(husband!=null) {
    		String HusbandDeath = husband.getDeath();
    		if(!husband.getIsAlive()) {
        		if(getDayByDeath(HusbandDeath)<30) {
        			if(survivors!="") {
            			System.out.println("DATA: US37: "+family.getID()+
            					": All living spouses and descendants of a person("+husband.getId()+
            					") who died in the last 30 days: descendants("+survivors+") / spouse(none)");
            			result=false;
        			}
        		}
        	}
    	}else if(wife!=null) {
    		String WifeDeath = wife.getDeath();
    		if(!wife.getIsAlive()) {
        		if(getDayByDeath(WifeDeath)<30) {
        			if(survivors!="") {
            			System.out.println("DATA: US37: "+family.getID()+
            					": All living spouses and descendants of a person("+wife.getId()+
            					") who died in the last 30 days: descendants("+survivors+") / spouse(none)");
            			result=false;
        			}        			
        		}
        	}
    	}
		return result;		
	}
	
	private static int getAgeByMarry(String birthString,String marryString) throws ParseException {
        if (birthString.equals("NA") || marryString.equals("NA")) return 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = format.parse(birthString);
        Date marryDate = format.parse(marryString);
        
		int age = 0;
		try {
			Calendar marry = Calendar.getInstance();
			marry.setTime(marryDate);

			Calendar birth = Calendar.getInstance();
			birth.setTime(birthday);
//			System.out.println(marry.get(Calendar.DAY_OF_YEAR)-birth.get(Calendar.DAY_OF_YEAR));
//			System.out.println(birth.get(Calendar.YEAR));
			if (birth.after(marry)) {
				age = 0;
			} else {
				age = marry.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
				
				if (marry.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
					age -= 1;
				}
			}
			return age;
		} catch (Exception e) {
			return 0;
		}
	}
	
	private static int getDayByDeath(String deathString) throws ParseException {
        if (deathString.equals("NA")) return 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date deathDate = format.parse(deathString);
        int days = 999;
        try {
            Calendar now = Calendar.getInstance();
//			System.out.println(now.get(Calendar.DAY_OF_YEAR));
            now.setTime(new Date());
            Calendar death = Calendar.getInstance();
            death.setTime(deathDate);

            if (now.get(Calendar.YEAR) == death.get(Calendar.YEAR)) {
            	days = now.get(Calendar.DAY_OF_YEAR)-death.get(Calendar.DAY_OF_YEAR);
            } else if(now.get(Calendar.YEAR) - death.get(Calendar.YEAR)==1){
            	if(death.get(Calendar.YEAR)%4==0&&death.get(Calendar.YEAR)%100!=0) {
            		days = 366-death.get(Calendar.DAY_OF_YEAR)+now.get(Calendar.DAY_OF_YEAR);
            	}else {
            		days = 365-death.get(Calendar.DAY_OF_YEAR)+now.get(Calendar.DAY_OF_YEAR);
            	}
            }
//            System.out.println(days);
            return days;
        } catch (Exception e) {
           return 0;
        }
    }
	
//	public static void main(String[] args) throws ParseException {
//		Family f1 = new Family();
//		Individual i1 = new Individual();
//		Individual i2 = new Individual();
//		Individual i3 = new Individual();
//		Individual i4 = new Individual();
//		Map<String, Individual> individualMap = new HashMap<String, Individual>();
//		f1.setID("f011");
//		i1.setId("I105");
//		i1.setAlive(false);
//		i1.setDeath("2020-09-20");
//		i2.setId("I106");
//		i2.setAlive(false);
//		i2.setDeath("2020-10-6");
//		i3.setId("I107");
//		i3.setAlive(false);
//		i3.setDeath("2020-10-26");
//		i4.setId("I108");
//		i4.setAlive(true);
//		i4.setDeath("2020-09-26");
//		individualMap.put("I105", i1);
//		individualMap.put("I106", i2);
//		f1.setHusbandId("I105");
//		f1.setWifeId("I106");
//		List<Individual> children = new ArrayList<>();
//		children.add(i3);
//		children.add(i4);
//		f1.setChildren(children);
//    
//
//		System.out.println("\n--------------------US37--------------------");
//
//		System.out.println(US37(f1, individualMap));
//	}
}
