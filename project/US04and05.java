package assignment04;

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
	public boolean US04(ArrayList<Family> family) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int f = 0;
		for (Family fam : family) {
			if (fam.getDivorced() == "n") { // If divorced, it will skip the return statement
				continue;
			}
			Date mDate = fam.getMarriageDate();
			Date dDate = fam.getDivorcedDate();
			if (mDate == null) {
				System.out.println("ERROR: US04: No marriage date available for family: " + fam.getID());
				continue;
			}
			if (dDate == null) {
				System.out.println("ERROR: US04: No divorce date available for divorced family: " + fam.getID());
				continue;
			}
			if (dDate.before(mDate)) {
				System.out.println("ERROR: FAMILY: US04: " + fam.getID() + ": Divorced "
						+ simpleDateFormat.format(dDate) + " before married " + simpleDateFormat.format(mDate));
				f = 1;
				continue;
			}
		}
		if (f == 0)
			return true;
		else
			return false;
	}

	public boolean US05(ArrayList<Individual> people, ArrayList<Family> family) {
		int f = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (Family fam : family) {
			String dad = fam.getDad().getID();
			String mom = fam.getMom().getID();
			boolean dadDead = false;
			Date dadDeathDate = null;
			boolean momDead = false;
			Date momDeathDate = null;
			for (Individual p : people) {
				
				if (p.getID().equals(dad)) {
					dadDead = p.isDeath();
					System.out.println("DadDead: "+ dadDead);
					if (dadDead) {
						dadDeathDate = p.getDeathDate();
					}
				}
				if (p.getID().equals(mom)) {
					momDead = p.isDeath();
					if (momDead) {
						momDeathDate = p.getDeathDate();
					}
				}
			}
			Date mDate = fam.getMarriageDate();
			if (dadDeathDate == null && dadDead) {
				System.out.println("ERROR: US05: No death date available for father");
				continue;
			}
			if (momDeathDate == null && momDead) {
				System.out.println("ERROR: US05: No death date available for mother");
				continue;
			}
			if (mDate == null) {
				System.out.println("ERROR: US05: No marriage date available for the family");
				continue;

			}
			System.out.println(dadDead + "=======");
			if (dadDead) {
				if (dadDeathDate.before(mDate)) {
					System.out.println("ERROR: FAMILY: US05 " + fam.getID() + " Married "
							+ simpleDateFormat.format(fam.getMarriageDate()) + " after husband's (" + dad
							+ ") death on " + simpleDateFormat.format(dadDeathDate));
					f = 1;
					continue;
				}
			}
			if (momDead) {
				if (momDeathDate.before(mDate)) {
					System.out.println("ERROR: FAMILY: US05 " + fam.getID() + " Married "
							+ simpleDateFormat.format(fam.getMarriageDate()) + " after wife's (" + mom + ") death on "
							+ simpleDateFormat.format(momDeathDate));
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
