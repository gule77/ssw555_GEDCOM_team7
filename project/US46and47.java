//package src;

import java.text.ParseException;
import java.util.*;

public class US46and47 {
    public static String US46(List<Individual> individual) {
        /*
        print out the living person following the descending age sequence
         */
        ArrayList<Individual> copyList = new ArrayList<>();
        for(Individual person : individual) {
            if(person.getIsAlive()) {
                copyList.add(person);
            }
            copyList.sort((a, b) -> a.getAge() - b.getAge());
        }
        StringBuilder result = new StringBuilder();
        result.append("DATA: US46: DATA: INDIVIDUAL:");
        for(Individual person : individual) {
            if(person.getName() != null) {
                result.append(" ").append(person.getName()).append(": ").append(person.getAge()).append(";");
            }
        }
        return result.toString();
    }

    public static String US47(List<Family> familyList) {
        /*
        return the family which has the most number of children
         */
        Family largestFam = new Family();
        int numberOfChildren = 0;
        for(Family family : familyList) {
            if(family.getChildren() != null && family.getChildren().size() > numberOfChildren) {
                numberOfChildren = family.getChildren().size();
                largestFam = family;
            }
        }
        String result = "DATA US47: DATA: Family ID: " + largestFam.getID() + " has the most children with "
                + numberOfChildren + " children";
        return result;
    }
}
