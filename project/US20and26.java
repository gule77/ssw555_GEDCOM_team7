import java.text.ParseException;
import java.util.*;

public class US20and26 {
    public static boolean US20(List<Family> familyList) {
        /*
        check if aunts and uncles marry their nieces or nephews
         */
        boolean res = true;
        HashSet<String> childrenSet = new HashSet<>();
        HashMap<Integer, HashSet<String>> generationMap = new HashMap<>();
        //get children set
        for(Family family: familyList) {
            if(family.getChildren() != null) {
                for(Individual individual: family.getChildren()) {
                    if(! childrenSet.contains(individual.getId())) {
                        childrenSet.add(individual.getId());
                    }
                }
            }
        }
        //find family tree root generation
        Integer curGeneration = 1;
        Integer nextGeneration = 2;
        for(Family family: familyList) {
            HashSet<String> curGenList = new HashSet<>();
            HashSet<String> nextGenList = new HashSet<>();
            if(!(childrenSet.contains(family.getHusbandID()) || childrenSet.contains(family.getWifeID()))) {
                curGenList.add(family.getHusbandID());
                curGenList.add(family.getWifeID());
                generationMap.put(curGeneration, curGenList);
                for(Individual individual: family.getChildren()) {
                    nextGenList.add(individual.getId());
                }
                generationMap.put(nextGeneration, nextGenList);
            }
        }
        curGeneration += 1;
        nextGeneration += 1;
        //build the rest of the generation map
        while(generationMap.containsKey(curGeneration)) {
            HashSet<String> nextGenList = new HashSet<>();
            for(Family family: familyList) {
                if(generationMap.get(curGeneration).contains(family.getHusbandID()) || generationMap.get(curGeneration).contains(family.getWifeID())) {
                    if(family.getChildren() != null) {
                        for(Individual individual: family.getChildren()) {
                            nextGenList.add(individual.getId());
                        }
                    }
                }
            }
            if(nextGenList.size() > 0) {
                generationMap.put(nextGeneration, nextGenList);
            }
            curGeneration += 1;
            nextGeneration += 1;
        }
        for(Map.Entry<Integer, HashSet<String>> entry: generationMap.entrySet()){
            System.out.println(entry.getKey() + "gen: " + entry.getValue().toString());
        }

        // validate US20
        for(Family family : familyList) {
            for(Map.Entry<Integer, HashSet<String>> sameGen : generationMap.entrySet()) {
                Integer genLevel = sameGen.getKey();
                HashSet<String> sameGenList = sameGen.getValue();
                if(sameGenList.contains(family.getHusbandID()) || sameGenList.contains(family.getWifeID())) {
                    if(generationMap.containsKey(genLevel + 1)) {
                        HashSet<String> nextGenList = generationMap.get(genLevel + 1);
                        if(nextGenList.contains(family.getHusbandID()) || nextGenList.contains(family.getWifeID())) {
                            res = false;
                            System.out.println("ERROR: US20: FAMILY " + family.getID() + ": " + family.getLine() + ": " +
                                    family.getHusbandName() + " and " +family.getWifeName() + " are aunt/uncle and niece/nephew");
                        }
                    }
                }
            }
        }
        return res;
    }

    public static boolean US26(List<Family> familyList, Map<String, Individual> individualList) {
        /*
        Ensure all family roles in an individual record should have corresponding entries in the corresponding family records
         */
        boolean res = true;
        for(Family family : familyList) {
            Individual husband = individualList.get(family.getHusbandID());
            if( husband.getName() != null && !husband.getName().equals(family.getHusbandName())) {
                System.out.println("ERROR: US26: INDIVIDUAL " + husband.getId() + ": " + husband.getLine() +
                        ": husband's name: "+ husband.getName() + " is inconsistent with entry's name: "+family.getHusbandName()
                        +" in the FAMILY " + family.getID() + ": " + family.getLine());
                res = false;
            }
            Individual wife = individualList.get(family.getWifeID());
            if(wife != null && wife.getName() != null && family.getWifeName() != null && !wife.getName().equals(family.getWifeName())) {
                System.out.println("ERROR: US26: INDIVIDUAL " + wife.getId() + ": " + wife.getLine() +
                        ": wife's name: "+ wife.getName() + " is inconsistent with entry's name:  "+family.getWifeName() +
                        " in the FAMILY " + family.getID() + ": " + family.getLine());
                res = false;
            }
            if(family.getChildren() != null) {
                for(Individual child : family.getChildren()) {
                    if(child.getChild() != null && !child.getChild().equals(family.getID())) {
                        System.out.println("ERROR: US26: INDIVIDUAL " + child.getId() + ": " + child.getLine() +
                                ": the Child's family information " + child.getChild() + " is inconsistent with " +
                                family.getID()+ " the family in "+ family.getID() + ": " + family.getLine());
                        res = false;
                    }
                }
            }
        }
        return res;
    }
}
