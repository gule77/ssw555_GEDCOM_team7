//package assignment04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class US04and05 {
	/*
	 * Bin Sun Test US04 Checks that the divorce date does not occur before the
	 * marriage date
	 * 
	 * @param family - an array of families to check
	 * 
	 * @return - if the family's divorce date is after the marriage date -> true if
	 * the family's divorce date is before the marriage date -> false
	 */
	public static boolean US04(ArrayList<Family> family) {
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int f = 0;
		for (Family fam : family) {
			String marriageDate = fam.getMarried();
			String divorceDate = fam.getDivorced();
			if (fam.getDivorced().equals("NA")) {
				//System.out.println("ERROR: US04: No divorce date available for divorced family: " + fam.getID());
				continue;
			}

			long yearsBetween = HelperFuctions.yearsBetween(divorceDate, marriageDate);
			long monthsBetween = HelperFuctions.monthsBetween(divorceDate, marriageDate);
			long daysBetween = HelperFuctions.daysBetween(divorceDate, marriageDate);

			if (yearsBetween > 0) {
				System.out.println("ERROR: FAMILY: US04: " + fam.getID() + ": Divorced year" + divorceDate
						+ " before married year" + marriageDate);
				f = 1;
				continue;
			} else if (monthsBetween > 0) {
				System.out.println("ERROR: FAMILY: US04: " + fam.getID() + ": Divorced month" + divorceDate
						+ " before married month" + marriageDate);
				f = 1;
				continue;
			} else if (daysBetween > 0) {
				System.out.println("ERROR: FAMILY: US04: " + fam.getID() + ": Divorced day" + divorceDate
						+ " before married day" + marriageDate);
				f = 1;
				continue;
			}
		}
		if (f == 1)
			return false;
		return true;
	}

	/*
	 * Bin Sun Test US05 Checks that the death date does not occur before the
	 * marriage date
	 * 
	 * @param people, family - an array of families to check and an array of people to check
	 * 
	 * @return - if the family's death date is after the marriage date -> true 
	 * if the family's divorce date is before the death date -> false
	 */
	public static boolean US05(ArrayList<Individual> people, ArrayList<Family> family) {
		int f = 0;
		for (Family fam : family) {
			String hus = fam.getHusbandID();
			String wif = fam.getWifeID();
			boolean dadDead = false;
			String deathDate = "NA";
			boolean momDead = false;

			for (Individual p : people) {
				if (p.getId().equals(hus)) {
					dadDead = !p.getIsAlive();
					if (dadDead) {
						deathDate = p.getDeath();
					}
				}
				if (p.getId().equals(wif)) {
					momDead = !p.getIsAlive();
					if (momDead) {
						deathDate = p.getDeath();
					}
				}
			}
			String mDate = fam.getMarried();
			if (deathDate == "NA" && dadDead == false) {
				//System.out.println("ERROR: US05: No death date available for father");
				continue;
			}
			if (deathDate == "NA" && momDead == false) {
				//System.out.println("ERROR: US05: No death date available for mother");
				continue;
			}
			if (mDate == "NA") {
				//System.out.println("ERROR: US05: No marriage date available for the family");
				continue;

			}
			long yearsBetween = HelperFuctions.yearsBetween(deathDate, mDate);
			long monthsBetween = HelperFuctions.monthsBetween(deathDate, mDate);
			long daysBetween = HelperFuctions.daysBetween(deathDate, mDate);
			if (dadDead) {
				if (yearsBetween > 0 || monthsBetween > 0 || daysBetween > 0) {
					System.out.println("ERROR: FAMILY: US05 " + fam.getID() + " Married "
							+ fam.getMarried() + " after husband's " 
							+ " death on " + deathDate);
					f = 1;
					continue;
				}
			}
			if (momDead) {
				if (yearsBetween > 0 || monthsBetween > 0 || daysBetween > 0) {
					System.out.println("ERROR: FAMILY: US05 " + fam.getID() + " Married "
							+ fam.getMarried() + " after wife's " + " death on "
							+ deathDate);
					f = 1;
					continue;
				}
			}
		}
		if (f == 0)
			return true;
		else
			return false;
	}

}
