import java.util.*;

/**
 * User story 32 list multiple births and User story 33 list orphans
 * @author Ziyou Shang
 */
public class US32and33 {
    
    /**
     * User story 32
     * @param familyList the list of family
     * @param individualList the list of individual
     * @return true if multiple births are listed, false if there's no multiple
     * births
     */
    public static boolean US32(ArrayList<Family> familyList) {
        boolean result = false;
        if (familyList == null || familyList.isEmpty()) {
            System.out.println("ERROR: US32: Family list is empty or null");
            return false;
        }
        
        for (Family family : familyList) {
            HashMap<String, ArrayList<Individual>> h = new HashMap<>();
            List<Individual> children = family.getChildren();
            if (children != null && !children.isEmpty()) {
                for (Individual child: children) {
                    if (h.containsKey(child.getBirthday())) {
                        h.get(child.getBirthday()).add(child);
                        result = true;
                    }
                    else {
                        ArrayList<Individual> c = new ArrayList<>();
                        c.add(child);
                        h.put(child.getBirthday(), c);
                    }
                }
            
                if (result) {
                    for (ArrayList<Individual> ch : h.values()) {
                        if (ch.size() > 1) {
                            System.out.print("DATA: US32: " + family.getID() + ": ");
                            for (int i = 0; i < ch.size(); i++) {
                                if (i != ch.size() - 1) {
                                    System.out.print(ch.get(i).getId() + " and ");
                                }
                                else {
                                    System.out.print(ch.get(i).getId() + " are multiple births in the family\n");
                                }
                            }
                        }
                    }
                }
            } 
        }
        
        if (!result) {
            System.out.println("DATA: US32: There are no multiple births");
        }
        return result;
    }
    
    /**
     * User story 33
     * @param familyList the list of family
     * @param individualList the list of individual
     * @return true if orphans are listed, false if there's no orphans
     */
    public static boolean US33(ArrayList<Family> familyList, 
            ArrayList<Individual> individualList) {
        boolean result = false;
        if (familyList == null || familyList.isEmpty() ||
                individualList == null || individualList.isEmpty()) {
            System.out.println("ERROR: US33: Family list is empty or null");
            return false;
        }
        
        for (Family family : familyList) {
            boolean resultInFamily = false;
            String husbandId = family.getHusbandID();
            String wifeId = family.getWifeID();
            boolean husbandDead = false;
            boolean wifeDead = false;
            for (Individual indi : individualList) {
                if (indi.getId().equals(husbandId)) {
                    if (!indi.getIsAlive()) {
                        husbandDead = true;
                    }
                }
                else if (indi.getId().equals(wifeId)) {
                    if (!indi.getIsAlive()) {
                        wifeDead = true;
                    }
                }
            }
            
            if (husbandDead && wifeDead) {
                List<Individual> children = family.getChildren();
                if (children != null && !children.isEmpty()) {
                    for (Individual child : children) {
                        if (child.getAge() < 18) {
                            result = true;
                            resultInFamily = true;
                        }
                    }
                    if (resultInFamily) {
                        if (children.size() == 1) {
                            System.out.println("DATA: US33: " + family.getID() + 
                                    ": " + children.get(0).getId() + " is the orphan in the family");
                        }
                        else {
                            System.out.print("DATA: US33: " + family.getID() + ": ");
                            for (int i = 0; i < children.size(); i++) {
                                if (i != children.size() - 1) {
                                    System.out.print(children.get(i).getId() + " and ");
                                }
                                else {
                                    System.out.print(children.get(i).getId() + " are orphans in the family\n");
                                }
                            }
                        }
                        
                    }
                }
            }
        }
        
        if (!result) {
            System.out.println("DATA: US33: There are no orphans");
        }
        return result;
    }
}
