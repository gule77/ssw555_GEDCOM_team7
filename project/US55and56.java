package project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class US55and56 {
    /*
    List families that have lost children
     */
     public static String US55(List<Family> familyList) {
         StringBuilder sb = new StringBuilder();
         boolean isExist = false;
         sb.append("DATA: FAMILY: US55: {");
         for (Family f: familyList) {
             if (f.getChildren() == null || f.getChildren().size() == 0) continue;
             for (Individual indi: f.getChildren()) {
                 if (!indi.getIsAlive()) {
                     isExist = true;
                     sb.append(f.getLine() + ": " + f.getID() + ", ");
                     break;
                 }
             }
         }

         sb.deleteCharAt(sb.length() - 1);
         sb.deleteCharAt(sb.length() - 1);
         sb.append("} have lost children");
         if (isExist) return sb.toString();
         return "DATA: FAMILY: US55: No family has lost a child";
     }

     /*
     List recent marriages
      */
     public static String US56(List<Family> familyList) {
         boolean res = false;
         StringBuilder sb = new StringBuilder();
         sb.append("DATA: FAMILY: US56: {");
         for (Family f: familyList) {
             if (daysBetweenToday(f.getMarried()) <= 30) {
                 res = true;
                 sb.append(f.getLine() + ": " + f.getID() + ", ");
             }
         }

         sb.deleteCharAt(sb.length() - 1);
         sb.deleteCharAt(sb.length() - 1);
         sb.append("} married in the last 30 days");
         if (res) return sb.toString();
         return "DATA: FAMILY: US56: No family married in the last 30 days";
     }

    private static long daysBetweenToday(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate ld1 = LocalDate.parse(date, formatter);
        LocalDate ld2 = LocalDate.now();
        return ChronoUnit.DAYS.between(ld1, ld2);
    }
}
