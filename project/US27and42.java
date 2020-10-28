//package project;

import javafx.scene.control.SpinnerValueFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class US27and42 {
    public static String US27(Individual indi) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        if (indi.getBirthday() == null || indi.getBirthday().length() == 0) {
            return indi.getId() + "(unknown age)";
        }
        LocalDate ld1 = LocalDate.parse(indi.getBirthday(), formatter);
        int age = (int) ChronoUnit.YEARS.between(ld1, LocalDate.now());
        return indi.getId() + "(" + age + ")";
    }

    public static boolean US42FamilyDate(Family f) {
        boolean m = true, d = true;
        if (f.getMarried() != null && f.getMarried().length() != 0) m = isLegalDate(f.getMarried());
        if (f.getDivorced() != null && f.getDivorced().length() != 0) d = isLegalDate(f.getDivorced());

        StringBuilder sb = new StringBuilder();
        sb.append("ERROR: FAMILY: US42: " + f.getLine() + ": " + f.getID() + ": has illegitimate ");
        if (m && d) return true;
        else if (m) sb.append("divorce");
        else if (d) sb.append("marriage");
        else sb.append("marriage and divorce");
        sb.append(" date");
        System.out.println(sb.toString());
        return false;
    }

    public static boolean US42IndividualDate(Individual indi) {
        boolean b = true, d = true;
        if (indi.getBirthday() != null && indi.getBirthday().length() != 0) b = isLegalDate(indi.getBirthday());
        if (indi.getDeath() != null && indi.getDeath().length() != 0) d = isLegalDate(indi.getDeath());

        StringBuilder sb = new StringBuilder();
        sb.append("ERROR: INDIVIDUAL: US42: " + indi.getLine() + ": " + indi.getId() + ": has illegitimate ");
        if (b && d) return true;
        else if (b) sb.append("death");
        else if (d) sb.append("birth");
        else sb.append("birth and death");
        sb.append(" date");
        System.out.println(sb.toString());
        return false;
    }

    private static boolean isLegalDate(String sDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-d");
        try {
            Date date = formatter.parse(sDate);
            return sDate.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }
    }
}
