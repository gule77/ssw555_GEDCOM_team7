package ssw555_GEDCOM_team7.project;

import java.util.*;

/**
 * User story Marriage after 14 and No bigamy
 * @author Ziyou Shang
 */
public class US10and11 {
    
    /**
     * function for Marriage after 14 user story
     * @param familyList family list parsed by GEDCOM parser
     * @param individualList individual list parsed by GEDCOM parser
     * @return Invalid husbandID or wifeID
     */
    public boolean us10(ArrayList<Family> familyList,
            ArrayList<Individual> individualList) {
        boolean result = true;
        if (familyList.isEmpty()) {
            System.out.println("Family list is empty");
            if (individualList.isEmpty()) {
                System.out.println("Individual list is empty");
            }
            return true;
        }
        if (individualList.isEmpty()) {
            System.out.println("Error: empty individual list");
            return false;
        }
        for (Family family : familyList) {
            String husbandID = family.getHusbandID();
            String wifeID = family.getWifeID();
            String marriageDate = family.getMarried();
            String husbandBirth = "";
            String wifeBirth = "";
            for (Individual individual : individualList) {
                if (husbandID.equals(individual.getId())) {
                    husbandBirth = individual.getBirthday();
                }
                else if (wifeID.equals(individual.getId())) {
                    wifeBirth = individual.getBirthday();
                }
            }
            if (husbandBirth.isEmpty() || wifeBirth.isEmpty() || marriageDate == null) {
                System.out.println("Error: date needed missing");
                result = false;
            }
            long marriageAgeH = HelperFuctions.yearsBetween(husbandBirth, marriageDate);
            long marriageAgeW = HelperFuctions.yearsBetween(wifeBirth, marriageDate);
            if (marriageAgeH < 14) {
                System.out.println("ERROR: FAMILY: US10: " + Integer.toString(family.getLine()) +
                        ": " + family.getID() + ": Marriage date " + marriageDate + 
                        " is within 14 years of husband's birthday " + husbandBirth);
                result = false;
            }
            if (marriageAgeW < 14) {
                System.out.println("ERROR: FAMILY: US10: " + Integer.toString(family.getLine()) +
                        ": " + family.getID() + ": Marriage date " + marriageDate + 
                        " is within 14 years of wife's birthday " + wifeBirth);
                result = false;
            }
        }
        return result;
    }
    
    /**
     * function for No bigamy user story
     * @param familyList family list parsed by GEDCOM parser
     * @param individualList individual list parsed by GEDCOM parser
     * @return Invalid husbandID or wifeID
     */
    public boolean us11(ArrayList<Family> familyList,
            ArrayList<Individual> individualList) {
        boolean result = true;
        if (familyList.size() <= 1) {
            return result;
        }
        if (individualList.size() < 1) {
            System.out.println("Individual list is empty");
            return false;
        }
        
        for (int i = 0; i < familyList.size() - 1; i++) {
            for (int j = i + 1; j < familyList.size(); j++) {
                Family family1 = familyList.get(i);
                Family family2 = familyList.get(j);
                if (family1.getHusbandID().equals(family2.getHusbandID())) {
                    if (compareDate(family1.getMarried(), family2.getMarried())) {
                        String wifeDeath = "";
                        for (Individual individual : individualList) {
                            if (individual.getId().equals(family2.getWifeID())) {
                                if (!individual.getIsAlive()) {
                                    wifeDeath = individual.getDeath();
                                }
                            }
                        }
                        if (wifeDeath.isEmpty()) {
                            if (family2.getDivorced() == null ||
                                    compareDate(family2.getDivorced(), family1.getMarried())) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) +
                                ": " + family1.getID() + ": Husband re-marriage date " + family1.getMarried() + 
                                " is earlier than divorce date " + family2.getDivorced());
                                result = false;
                            }
                        }
                        else {
                            if (compareDate(wifeDeath, family1.getMarried())) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) +
                                ": " + family1.getID() + ": Husband re-marriage date " + family1.getMarried() + 
                                " is earlier than ex-wife death date " + wifeDeath);
                                result = false;
                            }
                        }
                    }
                    else if (family1.getMarried().equals(family2.getMarried())) {
                        System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) +
                                ": " + family1.getID() + ": Husband get married twice in a day " + family1.getMarried());
                        result = false;
                    }
                    else {
                        String wifeDeath = "";
                        for (Individual individual : individualList) {
                            if (individual.getId().equals(family1.getWifeID())) {
                                if (!individual.getIsAlive()) {
                                    wifeDeath = individual.getDeath();
                                }
                            }
                        }
                        if (wifeDeath.isEmpty()) {
                            if (family1.getDivorced() == null ||
                                    compareDate(family1.getDivorced(), family2.getMarried())) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family2.getLine()) +
                                ": " + family2.getID() + ": Husband re-marriage date " + family2.getMarried() + 
                                " is earlier than divorce date " + family1.getDivorced());
                                result = false;
                            }
                        }
                        else {
                            if (compareDate(wifeDeath, family2.getMarried())) {
                                 System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family2.getLine()) +
                                ": " + family2.getID() + ": Husband re-marriage date " + family2.getMarried() + 
                                " is earlier than ex-wife death date " + wifeDeath);
                                result = false;
                            }
                        }
                    }
                }
                else if (family1.getWifeID().equals(family2.getWifeID())) {
                    if (compareDate(family1.getMarried(), family2.getMarried())) {
                        String husbandDeath = "";
                        for (Individual individual : individualList) {
                            if (individual.getId().equals(family2.getHusbandID())) {
                                if (!individual.getIsAlive()) {
                                    husbandDeath = individual.getDeath();
                                }
                            }
                        }
                        if (husbandDeath.isEmpty()) {
                            if (family2.getDivorced() == null ||
                                    compareDate(family2.getDivorced(), family1.getMarried())) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) +
                                ": " + family1.getID() + ": Wife re-marriage date " + family1.getMarried() + 
                                " is earlier than divorce date " + family2.getDivorced());
                                result = false;
                            }
                        }
                        else {
                            if (compareDate(husbandDeath, family1.getMarried())) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) +
                                ": " + family1.getID() + ": Wife re-marriage date " + family1.getMarried() + 
                                " is earlier than ex-husband death date " + husbandDeath);
                                result = false;
                            }
                        }
                    }
                    else if (family1.getMarried().equals(family2.getMarried())) {
                        System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) +
                                ": " + family1.getID() + ": Wife get married twice in a day " + family1.getMarried());
                        result = false;
                    }
                    else {
                        String husbandDeath = "";
                        for (Individual individual : individualList) {
                            if (individual.getId().equals(family1.getHusbandID())) {
                                if (!individual.getIsAlive()) {
                                    husbandDeath = individual.getDeath();
                                }
                            }
                        }
                        if (husbandDeath.isEmpty()) {
                            if (family1.getDivorced() == null ||
                                    compareDate(family1.getDivorced(), family2.getMarried())) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family2.getLine()) +
                                ": " + family2.getID() + ": Wife re-marriage date " + family2.getMarried() + 
                                " is earlier than divorce date " + family1.getDivorced());
                                result = false;
                            }
                        }
                        else {
                            if (compareDate(husbandDeath, family2.getMarried())) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family2.getLine()) +
                                ": " + family2.getID() + ": Wife re-marriage date " + family2.getMarried() + 
                                " is earlier than ex-husband death date " + husbandDeath);
                                result = false;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * helper function that can be added to helperFunction class
     * @param deathStr death date
     * @param birthStr birth date
     * @return true if death date later than birth date
     */
    public boolean compareDate(String deathStr, String birthStr) {
		
	boolean flag = false;
                
	String yearBirthStr = birthStr.substring(0,4);
	String yearDeathStr = deathStr.substring(0,4);
	int yearBirthInt = Integer.parseInt(yearBirthStr);
	int yearDeathInt = Integer.parseInt(yearDeathStr);
	String monthBirthStr = birthStr.substring(5,7);
	String monthDeathStr = deathStr.substring(5,7);
	int monthBirthInt = Integer.parseInt(monthBirthStr);
	int monthDeathInt = Integer.parseInt(monthDeathStr);
	String dayBirthStr = birthStr.substring(8);
	String dayDeathStr = deathStr.substring(8);
	int dayBirthInt = Integer.parseInt(dayBirthStr);
	int dayDeathInt = Integer.parseInt(dayDeathStr);
	if(yearDeathInt > yearBirthInt) {
		flag = true;
	}else if(yearDeathInt == yearBirthInt) {
		if(monthBirthInt < monthDeathInt) {
			flag = true;
		}else if(monthBirthInt == monthDeathInt) {
			if(dayBirthInt < dayDeathInt) {
				flag = true;
			}
		}
	}		
	return flag;
    }
    
}
