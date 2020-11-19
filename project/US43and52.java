import java.util.*;

/**
 * User Story 43 list males and females and User Story 52 list family with 
 * no children
 * @author Ziyou Shang
 */
public class US43and52 {
    
    /**
     * User story 43
     * @param individualList the list of individual
     * @return true if males and females are listed, false otherwise
     */
    public static boolean US43(ArrayList<Individual> individualList) {
        boolean result = false;
        if (individualList == null || individualList.isEmpty()) {
            System.out.println("ERROR: US43: Individual list is empty or null");
            return false;
        }
        
        for (Individual indi : individualList) {
            if (indi.getGender() == null) {
                continue;
            }
            if (indi.getGender().equals("M")) {
                System.out.println("DATA: US43: MALE: " + indi.getId());
                result = true;
            }
        }
        
        for (Individual indi2 : individualList) {
            if (indi2.getGender() == null) {
                continue;
            }
            if (indi2.getGender().equals("F")) {
                System.out.println("DATA: US43: FEMALE: " + indi2.getId());
                result = true;
            }
        }
        
        if (!result) {
            System.out.println("DATA: US43: There are no males or females");
        }
        return result;
    }
    
    
    /**
     * User story 52
     * @param familyList the list of family
     * @return true if family with no children are listed, false otherwise
     */
    public static boolean US52(ArrayList<Family> familyList) {
        boolean result = false;
        if (familyList == null || familyList.isEmpty()) {
            System.out.println("ERROR: US52: Family list is empty or null");
            return false;
        }
        
        for (Family family : familyList) {
            if (family.getChildren() == null || family.getChildren().isEmpty()) {
                System.out.println("DATA: US52: " + family.getID() + " has no children");
                result = true;
            }
        }
        
        if (!result) {
            System.out.println("DATA: US52: There are no families with no children");
        }
        return result;
    }
    
}
