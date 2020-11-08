//package assignment04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

public class US30and31 {
	/*
	 * Bin Sun Test US30 Checks that the All living married people of a family
	 * 
	 * 
	 * @param family - an array of All living married members of families to check
	 * 
	 * @return - List All living married people
	 */

	public ArrayList US30(ArrayList<Individual> personArrayList) {
		ArrayList<Individual> res = new ArrayList<>();
		for (Individual p : personArrayList) {
			if (!p.getSpouse().equals("NA") && p.getIsAlive()) {// means this person is married and is alive
				res.add(p);
				System.out.println("DATA: US30: " + p.getId() + ": living married people " );
			}

		}
		return res;
	}

	/*
	 * Bin Sun Test US31 Checks that all living people over 30, who have never been
	 * married in a GEDCOM file; List all of them in a GEDCOM file
	 */
	public ArrayList US31(ArrayList<Individual> personArrayList) {
		ArrayList<Individual> res = new ArrayList<>();
		for (Individual p : personArrayList) {
			if (p.getAge() > 30) {
				if (p.getSpouse().equals("NA") && p.getIsAlive()) {// means this person does not have a spouse and
																	// single.
					res.add(p);
					System.out.println("DATA: US31: " + p.getId() +":living single people" );
				}
			}
		}

		return res;
	}
}


