import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.Period;

public class US06and07 {
	//Divorce can only occur before death of both spouses
	public static boolean US06(List<Family> familyList, Map<String, Individual> individualMap){
		boolean res = true;
		for (Family family : familyList) {
			if(!family.getDivorced().equals("NA")) {
				String divStr = family.getDivorced();
				String husbandID = family.getHusbandID();
				String wifeID = family.getWifeID();
				Individual husband,wife;
				
				if(husbandID != null) {
					husband = individualMap.get(husbandID);
					if(!husband.getIsAlive()) {
						String husbandDeathStr = husband.getDeath();
						if(!isDateValid(husbandDeathStr, divStr)) {
							System.out.println("ERROR: FAMILY: US06: " + family.getLine() + ": " + family.getID() + ": Divorced " + family.getDivorced() 
							+ " after husband's (" + husband.getId() + ") death on " + husband.getDeath()); 
							res = false;
						}
						
					}
				}
				if(wifeID != null) {
					wife = individualMap.get(wifeID);
					if(!wife.getIsAlive()) {
						String wifeDeathStr = wife.getDeath();
						if(!isDateValid(wifeDeathStr, divStr)) {
							System.out.println("ERROR: FAMILY: US06: " + family.getLine() + ": " + family.getID() + ": Divorced " + family.getDivorced() 
							+ " after wife's (" + wife.getId() + ") death on " + wife.getDeath()); 
							res = false;
						}
						
					}
				}
			}
		}
		return res;
	}
	
	//Death should be less than 150 years after birth for dead people, and current date should be 
	//less than 150 years after birth for all living people
	public static boolean US07(List<Individual> individualList) {
		boolean res = true;
		for(Individual person: individualList) {
			String birthStr = person.getBirthday();
			String yearbirthStr = birthStr.substring(0,4);
			int yearbirthInt = Integer.parseInt(yearbirthStr);
			String monthbirthStr = birthStr.substring(5,7);
			int monthbirthInt = Integer.parseInt(monthbirthStr);
			String daybirthStr = birthStr.substring(8);
			int daybirthInt = Integer.parseInt(daybirthStr);
			LocalDate birthDate = LocalDate.of(yearbirthInt, monthbirthInt, daybirthInt);
			// Death
			if(!person.getDeath().equals("NA")) {
				String deathStr = person.getDeath();
				// year month day
				String yeardeathStr = deathStr.substring(0,4);
				int yeardeathInt = Integer.parseInt(yeardeathStr);
				String monthddeathStr = deathStr.substring(5,7);
				int monthdeathInt = Integer.parseInt(monthddeathStr);
				String daydeathStr = deathStr.substring(8);
				int daydeathInt = Integer.parseInt(daydeathStr);
				LocalDate deathDate = LocalDate.of(yeardeathInt, monthdeathInt, daydeathInt);
				Period p = Period.between(birthDate, deathDate);
				if(p.getYears() >= 150) {
					System.out.println("ERROR: INDIVIDUAL: US07: " + person.getLine() + ": " + person.getId() + ": More than 150 years old at death - Brith " +
							birthDate + ": Death " + deathDate ); 
					res = false;
				}
			} else {//Alive
				LocalDate today = LocalDate.now();
				Period p = Period.between(birthDate, today);
				if(p.getYears() >= 150) {
					System.out.println("ERROR: INDIVIDUAL: US07: " + person.getLine() + ": " + person.getId() + ": More than 150 years old at death - Brith " +
							birthDate); 
					res = false;
				}
			}
		}
		return res;
	}
	
	public static boolean isDateValid(String endStr, String StartStr) {
		boolean flag = false;;
		String yearstartStr = StartStr.substring(0,4);
		String yearendStr = endStr.substring(0,4);
		int yearstartInt = Integer.parseInt(yearstartStr);
		int yearendInt = Integer.parseInt(yearendStr);
		String monthstartStr = StartStr.substring(5,7);
		String monthendStr = endStr.substring(5,7);
		int monthBirthInt = Integer.parseInt(monthstartStr);
		int monthendInt = Integer.parseInt(monthendStr);
		String daystartStr = StartStr.substring(8);
		String dayendStr = endStr.substring(8);
		int dayBirthInt = Integer.parseInt(daystartStr);
		int dayendInt = Integer.parseInt(dayendStr);
		if(yearendInt > yearstartInt) {
			flag = true;
		}else if(yearendInt == yearstartInt) {
			if(monthBirthInt < monthendInt) {
				flag = true;
			}else if(monthBirthInt == monthendInt) {
				if(dayBirthInt <= dayendInt) {
					flag = true;
				}
			}
		}		
		return flag;
	}
}