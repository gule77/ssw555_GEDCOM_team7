import java.util.Collections;
import java.util.List;

public class US15and28 {

    public static boolean US15(Family f) {
    	boolean res =  true;
    	if (f.getChildren() != null) {
    		int num = f.getChildren().size();
            res = num < 15;
            if (!res) System.out.println("ERROR: FAMILY: US15: " + f.getLine() + ": " + f.getID() +
                    ": have " + num + " chilren");
    	}else {
    		res = true;
    	}
        
        return res;
    }

    public static String US28(Family f) {
        List<Individual> siblings = f.getChildren();

        if (siblings == null) return "Family " + f.getID() + " have no child";
        Collections.sort(siblings, (a, b) -> {
            String birth1 = a.getBirthday(), birth2 = b.getBirthday();
            if (HelperFuctions.yearsBetween(birth2, birth1) == 0) return (int) HelperFuctions.daysBetween(birth2, birth1);
            return (int) HelperFuctions.yearsBetween(birth2, birth1);
        });

        StringBuilder sb = new StringBuilder();
        sb.append("Sort family " + f.getID() + "'s children by their ages in decreasing order: <");
        for (Individual indi: f.getChildren()) {
            sb.append(indi.getId());
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(">");
        return sb.toString();
    }
}
