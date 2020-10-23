package assignment04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class US16and29 {
	/*
	 * Bin Sun Test US16 Checks that the All male members of a family should have
	 * the same last name
	 * 
	 * @param family - an array of All male members of families to check
	 * 
	 * @return - if All male members of any family's Last Name are same -> true if
	 * exists One male member of any family's Last Name is not same to the rest ones
	 * -> false
	 */
	
	public static boolean US16(ArrayList<Family> family, ArrayList<Individual> people) {
		boolean res = true;
		for (Family fam : family) {
			String temp = fam.getHusbandLastName();
//			System.out.println(temp);
			for (Individual p : people) {
				if (fam.getChildren().contains(p)) {
					res = temp.equals(p.getLastName());
//					System.out.println("res=====: " + res);
					if (!res) {
						System.out.println("ERROR: FAMILY: US16: " + fam.getID()
								+ " Male family members do not have the same last names. ");
						res = false;
						break;
					}
				}
			}
		}
		return res;
	}

	/*
	 * Bin Sun Test US16 Checks that all deceased individuals 
	 * List all of them in a GEDCOM file
	 */

	public static boolean US29(ArrayList<Individual> perList) {
		boolean res = true;
		for (Individual p : perList) {   
			if (p.getIsAlive() == false) {
				System.out.println("Data: INDIVIDUAL: US29: "  + " Death: " +p.getDeath() );

			}
		}
		return res;
	}
}

