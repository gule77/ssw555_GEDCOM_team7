import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class US53and54 {
	public static boolean US53(List<Individual> individualList) {
		boolean res = false;
		for(Individual person: individualList) {
			if(!person.getDeath().equals("NA")) {
				String deathStr = person.getDeath();
				LocalDate deathDate = StrToLocalDate(deathStr);
				String birthStr = person.getBirthday();
				LocalDate birthDate = StrToLocalDate(birthStr);
				long noOfDaysBetween = ChronoUnit.DAYS.between(deathDate, birthDate);
				if(noOfDaysBetween == 0) {
					System.out.println("Data: INDIVIDUAL: US53: " + person.getId() + ": Death and birth same day. "); 
					res = true;
				}
			}
		}
		return res;	
	}
	
	public static boolean US54(List<Individual> individualList) {
		boolean res = false;
		for(Individual person: individualList) {
			if(!person.getDeath().equals("NA")) {
				String deathStr = person.getDeath();
				LocalDate deathDate = StrToLocalDate(deathStr);
				String birthStr = person.getBirthday();
				LocalDate birthDate = StrToLocalDate(birthStr);
				Period p = Period.between(birthDate, deathDate);
				if(p.getYears() < 18) {
					System.out.println("Data: INDIVIDUAL: US54: " + person.getId() + ": Death under 18."); 
					res = true;
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
