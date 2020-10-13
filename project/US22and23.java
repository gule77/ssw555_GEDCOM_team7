import java.util.*;

/**
 * User story Unique IDs and Unique name and birth date
 * @author Ziyou Shang
 */
public class US22and23 {
    
    
    /**
     * Function for user story 22 Unique IDs
     * @param individualList the list of individual 
     * @param familyList the list of family
     * @return true if the IDs are unique
     */
    public static boolean US22(ArrayList<Individual> individualList, ArrayList<Family> familyList) {
        boolean result = true;
        if (individualList.isEmpty() || familyList.isEmpty()) {
            return true;
        }
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        
        for (Individual indi : individualList) {
            String id = indi.getId();
            // bad smell 1: duplicate of code
            if (id == null) {
                System.out.println("ERROR: INDIVIDUAL: US22: Individual id does not exist");
                result = false;
            }
            if (s1.contains(id)) {
                System.out.println("ERROR: INDIVIDUAL: US22: " + Integer.toString(indi.getLine()) +
                        ": id " + id + " has already existed");
                result = false;
            }
            else {
                s1.add(id);
            }
        }
        
        for (Family family : familyList) {
            String id = family.getID();
            if (id == null) {
                System.out.println("ERROR: FAMILY: US22: Family id does not exist");
                result = false;
            }
            if (s2.contains(id)) {
                System.out.println("ERROR: FAMILY: US22: " + Integer.toString(family.getLine()) +
                        ": id " + id + " has already existed");
                result = false;
            }
            else {
                s2.add(id);
            }
        }
        return result;
    }
    
    /**
     * Function for user story 23 Unique name and birth date
     * @param individualList the list of individual
     * @return true if the name and birth date are unique
     */
    public static boolean US23(ArrayList<Individual> individualList) {
        boolean result = true;
        if (individualList.isEmpty()) {
            return true;
        }
        Map<String, ArrayList<String>> m1 = new HashMap<>();
        for (Individual indi : individualList) {
            String name = indi.getName();
            String birth = indi.getBirthday();
            if (name == null || birth == null || name.equals("NA") || birth.equals("NA")) {
                System.out.println("ERROR: INDIVIDUAL: US23: Individual information not complete");
                result = false;
            }
            else if (m1.containsKey(name)) {
                ArrayList<String> arr = m1.get(name);
                if (arr.contains(birth)) {
                    System.out.println("ERROR: INDIVIDUAL: US23: " + Integer.toString(indi.getLine()) +
                            ": Name " + name + " and birth date " + birth + " have already existed");
                    result = false;
                }
                else {
                    arr.add(birth);
                }
            }
            else {
                ArrayList<String> newArr = new ArrayList<>();
                newArr.add(birth);
                m1.put(name, newArr);
            }
        }
        return result;
    }
}
