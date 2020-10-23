import java.text.ParseException;
import java.util.*;
public class US18and19 {
    public static boolean US18(List<Family> familyList) {
        boolean res = true;
        List<List<Individual>> chilrenList = new ArrayList<>();
        for(Family family: familyList) {
            chilrenList.add(family.getChildren());
        }
        for(List<Individual> children: chilrenList) {
            if(children!= null && children.size()< 2) {
                continue;
            } else {
                for(Family family: familyList) {
                    String husbandId = family.getHusbandID();
                    String wifeId = family.getWifeID();
                    if(husbandId != null && wifeId != null) {
                        if(children!= null && children.contains(husbandId) && children.contains(wifeId)){
                            res =false;
                            System.out.println("Error US18: " + family.getHusbandID() + " and " + family.getWifeID() + " in family " + family.getID() + " get married while they are siblings");
                        }
                    }
                }
            }
        }
        return res;
    }
    public static boolean US19(List<Family> familyList) {
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
//        for(Map.Entry<Integer, HashSet<String>> entry: generationMap.entrySet()){
//            System.out.println(entry.getKey() + "gen: " + entry.getValue().toString());
//        }
        //validate us19
        for(Family family: familyList) {
            for(Map.Entry<Integer, HashSet<String>> entry: generationMap.entrySet()) {
                if(entry.getKey() >= 3 ) {
                    HashSet<String> sameGen = entry.getValue();
                    if(sameGen.contains(family.getHusbandID()) && sameGen.contains(family.getWifeID())) {
                        System.out.println("Error US19: " + family.getHusbandID() + " and " + family.getWifeID() + " in family " + family.getID() + " married while they are fisrt cousins");
                        res = false;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) throws ParseException {
    }
}
