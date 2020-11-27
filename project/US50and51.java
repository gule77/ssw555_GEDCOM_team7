package assignment04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Map;
import java.util.*;

public class US50and51 {
	/*
	 * Bin Sun Test US04 Checks that who have ever divorced once or more generate
	 * all divorce dates they have
	 * 
	 * @param family - an array of families to check
	 * 
	 * @return - print all divorce date that people have
	 */

	public static void US50(ArrayList<Family> family) {
		int f = 0;
		for (Family fam : family) {
			String divorceDate = fam.getDivorced();
			if (!fam.getDivorced().equals("NA")) {
				// System.out.println("ERROR: US04: No divorce date available for divorced
				// family: " + fam.getID());
				System.out.println("US50: " + "Husband ID:" + fam.getHusbandID() + "Wife ID:" + fam.getWifeID()
						+ " " + fam.getDivorced() + ": is divorce date ");
				f = 1;
				continue;
			}

		}
	}

	/*
	 * Bin Sun Test US51 Checks that all female's age and male's age in a family
	 * compare their age
	 * 
	 * @param people, family - an array of families to check and an array of people
	 * to check
	 * 
	 * @return - print all female who is older than their husband
	 * 
	 */
	public static void US51(Family family, Map<String, Individual> individualMap) throws ParseException {
		boolean flag = true;
		String HusbandID = family.getHusbandID();
		String WifeID = family.getWifeID();
		Individual husband = individualMap.get(HusbandID);
		Individual wife = individualMap.get(WifeID);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (husband != null && wife != null) {
			String MarryDate = family.getMarried();
			Date HusbandBirth = format.parse(husband.getBirthday());
			Date WifeBirth = format.parse(wife.getBirthday());
			Date date = new Date(System.currentTimeMillis());
			if (WifeBirth.before(HusbandBirth)) {
				System.out.println("Family: " + family.getID() + "'s wife age is larger than husband");
			}
		}
	}
}
