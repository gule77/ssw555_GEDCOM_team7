import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

public class US38and39 {
	
	public static boolean US38(List<Individual> individualList) {
		boolean res = false;
		for(Individual person: individualList) {
			if(person.getDeath().equals("NA")) {
				String birthStr = person.getBirthday();
				LocalDate birthDate = StrToLocalDate(birthStr);
				LocalDate today = LocalDate.now();
				LocalDate nextBDay = birthDate.withYear(today.getYear());
		        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
		            nextBDay = nextBDay.plusYears(1);
		        }
				long noOfDaysBetween = ChronoUnit.DAYS.between(today, nextBDay);
				if(noOfDaysBetween <= 30) {
					System.out.println("Data: US38: " + person.getId() + ": Birthdays occur in the next 30 days "); 
					res = true;
				}
			}
		}
		return res;	
	}
	
	public static boolean US39(List<Family> familyList, Map<String, Individual> individualMap) {
		boolean res = false;
		for (Family family : familyList) {
			if(!family.getMarried().equals("NA")) {
				String husbandID = family.getHusbandID();
				String wifeID = family.getWifeID();
				Individual husband = individualMap.get(husbandID);
				Individual wife = individualMap.get(wifeID);
				if(husband.getIsAlive() && wife.getIsAlive()) {
					String MarriedStr = family.getMarried();
					LocalDate MarriedDate = StrToLocalDate(MarriedStr);
					LocalDate today = LocalDate.now();
					LocalDate nextMDay = MarriedDate.withYear(today.getYear());
			        if (nextMDay.isBefore(today) || nextMDay.isEqual(today)) {
			        	nextMDay = nextMDay.plusYears(1);
			        }
			        long noOfDaysBetween = ChronoUnit.DAYS.between(today, nextMDay);
			        System.out.println(noOfDaysBetween);
					if(noOfDaysBetween <= 30) {
						System.out.println("Data: US39: " + family.getID() + ": Marriage anniversaries occur in the next 30 days "); 
						res = true;
					}
				}
			}
		}
		return res;	
	}
	public static LocalDate StrToLocalDate(String date) {
		String yearStr = date.substring(0,4);
		int yearInt = Integer.parseInt(yearStr);
		String monthStr = date.substring(5,7);
		int monthInt = Integer.parseInt(monthStr);
		String dayStr = date.substring(8);
		int dayInt = Integer.parseInt(dayStr);
		return LocalDate.of(yearInt, monthInt, dayInt);
	}
}
