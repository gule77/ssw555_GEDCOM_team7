package ssw555_GEDCOM_team7.project;
/*
    Sprint1
    US13 and 14
    @author Xiaoxiao Deng
    @date Sep 25 2020
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class US13and14{
    /*
		Check if birth dates satisfy the condition below:
		Birth dates of siblings should be more than 8 months apart or less than 2 days apart
		(twins may be born one day apart, e.g. 11:59 PM and 12:02 AM the following calendar day)
	 */
    public static boolean US13(Family f){
        boolean res = true;
        List<Individual> siblings = sortSiblingsByBirthday(f);
        Map<Individual, String> map = new HashMap<>();
        for (int i = 0; i < siblings.size() - 1; i++) {
            for (int j = i + 1; j < siblings.size(); j++) {
                Individual sib1 = siblings.get(i), sib2 = siblings.get(j);
                String birth1 = sib1.getBirthday(), birth2 = sib2.getBirthday();
                if (HelperFuctions.monthsBetween(birth1, birth2) > 8) break;
                if (HelperFuctions.daysBetween(birth1, birth2) <= 1) continue;
                else {
                    res = false;
                    map.putIfAbsent(sib1, "{");
                    if(map.get(sib1).equals("{")) map.put(sib1, map.get(sib1) + sib2.getId());
                    else map.put(sib1, map.get(sib1) + ", " + sib2.getId());
                }
            }
        }

        for (Individual indi: map.keySet()) {
            System.out.println("ERROR: FAMILY: US13: " + f.getLine() + ": " + f.getID() +
                    ": the difference of birth dates between siblings " + indi.getId() +
                    " and " + map.get(indi) + "} is less than 9 months and more than 1 day");
        }

        return res;
    }

    /*
		Check if five siblings are born at the same time
	 */
	public static boolean US14(Family f) {
        List<int[]> lists = new ArrayList<>();  // in case mutiple error information
        int num = 1, pos = -1;
        List<Individual> siblings = sortSiblingsByBirthday(f);
        for (int i = 0; i < siblings.size() - 1; i++) {
            Individual sib1 = siblings.get(i), sib2 = siblings.get(i + 1);
            String birth1 = sib1.getBirthday(), birth2 = sib2.getBirthday();
            if (HelperFuctions.daysBetween(birth1, birth2) <= 1) {
                num++;
                if (pos == -1) pos = i;
            }
            else {
                if (num > 5) lists.add(new int[]{num, pos});
                num = 1;
                pos = -1;
            }
        }
        if (num > 5) lists.add(new int[]{num, pos});

        if (lists.size() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("ERROR: FAMILY: US13: " + f.getLine() + ": " + f.getID());
            sb.append(": more than five siblings have been born at the same time, they are:");
            for (int[] nums: lists) {
                sb.append(" {");
                num = nums[0];
                pos = nums[1];
                for (int i = pos; i < pos + num; i++) {
                    sb.append(siblings.get(i).getId());
                    sb.append(", ");

                }
                sb.delete(sb.length() - 2, sb.length());   // delete the redundant ", "
                sb.append("}");
            }
            System.out.println(sb);
        }

        return lists.size() == 0;
	}

	/*
	    sort siblings by birthday
	 */
    private static List<Individual> sortSiblingsByBirthday(Family f) {
	    List<Individual> siblings = f.getChildren();

        Collections.sort(siblings, (a, b) -> {
            String birth1 = a.getBirthday(), birth2 = b.getBirthday();
            if (HelperFuctions.yearsBetween(birth2, birth1) == 0) return (int) HelperFuctions.daysBetween(birth2, birth1);
            return (int) HelperFuctions.yearsBetween(birth2, birth1);
        });
        return siblings;
    }
}
