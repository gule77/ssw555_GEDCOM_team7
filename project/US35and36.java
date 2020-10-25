import java.time.LocalDate;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class US35and36 {
	public static boolean US35(List<Individual> individualList) {
		boolean res = false;
		for(Individual person: individualList) {
			String birthStr = person.getBirthday();
			LocalDate birthDate = StrToLocalDate(birthStr);
			LocalDate today = LocalDate.now();
			long noOfDaysBetween = ChronoUnit.DAYS.between(birthDate, today);
			if(noOfDaysBetween <= 30) {
				System.out.println("Data: US35: " + person.getId() + ": Born in the last 30 days "); 
				res = true;
			}
		}
		return res;	
	}
	
	public static boolean US36(List<Individual> individualList) {
		boolean res = false;
		for(Individual person: individualList) {
			if(!person.getDeath().equals("NA")) {
				String deathStr = person.getDeath();
				LocalDate birthDate = StrToLocalDate(deathStr);
				LocalDate today = LocalDate.now();
				long noOfDaysBetween = ChronoUnit.DAYS.between(birthDate, today);
				if(noOfDaysBetween <= 30) {
					System.out.println("Data: US36: " + person.getId() + ": Death in the last 30 days "); 
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
