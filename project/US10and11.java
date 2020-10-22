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
    public static boolean us10(ArrayList<Family> familyList,
            ArrayList<Individual> individualList) {
        boolean result = true;
        if (familyList.isEmpty()) {
            System.out.println("WARNING: US10: Family list is empty");
            if (individualList.isEmpty()) {
                System.out.println("WARNING: US10: Individual list is also empty");
            }
            return true;
        }
        if (individualList.isEmpty()) {
            System.out.println("ERROR: US10: empty individual list");
            return false;
        }
        for (Family family : familyList) {
            String husbandID = family.getHusbandID();
            String wifeID = family.getWifeID();
            String marriageDate = family.getMarried();
            String husbandBirth = "";
            String wifeBirth = "";
            if (husbandID == null || wifeID == null) {
                System.out.println("ERROR: FAMILY: US10: " + family.getID() + ": husband/wife ID in family missing");
                result = false;
                continue;
            }
            for (Individual individual : individualList) {
                if (individual.getId() == null) {
                    System.out.println("ERROR: INDIVIDUAL: US10: individual without id");
                    result = false;
                }
                else if (husbandID.equals(individual.getId())) {
                    husbandBirth = individual.getBirthday();
                }
                else if (wifeID.equals(individual.getId())) {
                    wifeBirth = individual.getBirthday();
                }
            }
            if (husbandBirth.isEmpty() || wifeBirth.isEmpty() || marriageDate == null) {
                System.out.println("ERROR: FAMILY: US10: birth or marriage date needed missing");
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
    public static boolean us11(ArrayList<Family> familyList,
            ArrayList<Individual> individualList) {
        boolean result = true;
        if (familyList.size() <= 1) {
            return result;
        }
        if (individualList.size() < 1) {
            System.out.println("ERROR: US11: Individual list is empty");
            return false;
        }
        
        for (int i = 0; i < familyList.size() - 1; i++) {
            Family family1 = familyList.get(i);
            if (family1.getMarried() == null || family1.getMarried().equals("NA")) {
                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) + ": " + family1.getID() + ": Family marriage date missing");
                result = false;
                continue;
            }
            else if (family1.getHusbandID() == null || family1.getWifeID() == null) {
                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) + ": Family member ID missing");
                result = false;
                continue;
            }
            for (int j = i + 1; j < familyList.size(); j++) {
                Family family2 = familyList.get(j);
                if (family2.getMarried() == null || family2.getMarried().equals("NA")) {
                    result = false;
                    }
                else if (family2.getHusbandID() == null || family2.getWifeID() == null) {
                    result = false;
                }
                else if (family1.getHusbandID().equals(family2.getHusbandID())) {
                    if (HelperFuctions.daysBetween(family1.getMarried(), family2.getMarried()) < 0) {
                        String wifeDeath = "";
                        for (Individual individual : individualList) {
                            if (individual.getId().equals(family2.getWifeID())) {
                                if (!individual.getIsAlive()) {
                                    wifeDeath = individual.getDeath();
                                }
                            }
                        }
                        if (wifeDeath.isEmpty()) {
                            if (family2.getDivorced() == null || family2.getDivorced().equals("NA")) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) +
                                ": " + family1.getID() + ": Husband re-marriage date " + family1.getMarried() + 
                                " without divorce ");
                                result = false;
                            }
                            else if (HelperFuctions.daysBetween(family2.getDivorced(), family1.getMarried()) < 0) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) +
                                ": " + family1.getID() + ": Husband re-marriage date " + family1.getMarried() + 
                                " is earlier than divorce date " + family2.getDivorced());
                                result = false;
                            }
                        }
                        else {
                            if (HelperFuctions.daysBetween(wifeDeath, family1.getMarried()) < 0) {
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
                            if (family1.getDivorced() == null || family1.getDivorced().equals("NA")) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family2.getLine()) +
                                ": " + family2.getID() + ": Husband re-marriage date " + family2.getMarried() + 
                                " without divorce ");
                                result = false;
                            }
                            else if (HelperFuctions.daysBetween(family1.getDivorced(), family2.getMarried()) < 0) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family2.getLine()) +
                                ": " + family2.getID() + ": Husband re-marriage date " + family2.getMarried() + 
                                " is earlier than divorce date " + family1.getDivorced());
                                result = false;
                            }
                        }
                        else {
                            if (HelperFuctions.daysBetween(wifeDeath, family2.getMarried()) < 0) {
                                 System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family2.getLine()) +
                                ": " + family2.getID() + ": Husband re-marriage date " + family2.getMarried() + 
                                " is earlier than ex-wife death date " + wifeDeath);
                                result = false;
                            }
                        }
                    }
                }
                else if (family1.getWifeID().equals(family2.getWifeID())) {
                    if (HelperFuctions.daysBetween(family1.getMarried(), family2.getMarried()) > 0) {
                        String husbandDeath = "";
                        for (Individual individual : individualList) {
                            if (individual.getId().equals(family2.getHusbandID())) {
                                if (!individual.getIsAlive()) {
                                    husbandDeath = individual.getDeath();
                                }
                            }
                        }
                        if (husbandDeath.isEmpty()) {
                            if (family2.getDivorced() == null || family2.getDivorced().equals("NA")) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) +
                                ": " + family1.getID() + ": Wife re-marriage date " + family1.getMarried() + 
                                " without divorce ");
                                result = false;
                            }
                            else if(HelperFuctions.daysBetween(family2.getDivorced(), family1.getMarried()) < 0) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family1.getLine()) +
                                ": " + family1.getID() + ": Wife re-marriage date " + family1.getMarried() + 
                                " is earlier than divorce date " + family2.getDivorced());
                                result = false;
                            }
                        }
                        else {
                            if (HelperFuctions.daysBetween(husbandDeath, family1.getMarried()) < 0) {
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
                            if (family1.getDivorced() == null || family1.getDivorced().equals("NA")) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family2.getLine()) +
                                ": " + family2.getID() + ": Wife re-marriage date " + family2.getMarried() + 
                                " without divorce ");
                                result = false;
                            }
                            else if (HelperFuctions.daysBetween(family1.getDivorced(), family2.getMarried()) < 0) {
                                System.out.println("ERROR: FAMILY: US11: " + Integer.toString(family2.getLine()) +
                                ": " + family2.getID() + ": Wife re-marriage date " + family2.getMarried() + 
                                " is earlier than divorce date " + family1.getDivorced());
                                result = false;
                            }
                        }
                        else {
                            if (HelperFuctions.daysBetween(husbandDeath, family2.getMarried()) < 0) {
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
    
}
