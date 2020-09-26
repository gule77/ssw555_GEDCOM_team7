package ssw555_GEDCOM_team7.project;/*
    HelperFunctions:
    1. dateDifference(years, months, days);
    @author Xiaoxiao Deng
    @date Sep 25, 2020
 */


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class HelperFuctions {

    /**
     * Calculate the difference of years
     *
     * @param early
     * @param late
     * @return difference of years (positive means early is earlier than late)
     */
    public static long yearsBetween(String early, String late) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate ld1 = LocalDate.parse(early, formatter);
        LocalDate ld2 = LocalDate.parse(late, formatter);
        return ChronoUnit.YEARS.between(ld1, ld2);
    }

    /**
     * Calculate the difference of months
     *
     * @param early
     * @param late
     * @return difference of months (positive means early is earlier than late)
     */
    public static long monthsBetween(String early, String late) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate ld1 = LocalDate.parse(early, formatter);
        LocalDate ld2 = LocalDate.parse(late, formatter);
        return ChronoUnit.MONTHS.between(ld1, ld2);
    }

    /**
     * Calculate the difference of days
     *
     * @param early
     * @param late
     * @return difference of days (positive means early is earlier than late)
     */
    public static long daysBetween(String early, String late) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate ld1 = LocalDate.parse(early, formatter);
        LocalDate ld2 = LocalDate.parse(late, formatter);
        return ChronoUnit.DAYS.between(ld1, ld2);
    }

    /**
     * Generate individual with id from I0
     *
     * @param num
     * @return List<Individual>
     */
    public static List<Individual> generateIndividualList(int num) {
        List<Individual> res = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Individual indi = new Individual();
            indi.setId("I" + i);
        }
        return res;
    }

    /**
     * Generate family with id from F0
     *
     * @param num
     * @return List<Family>
     */
    public static List<Family> generateFamilyList(int num) {
        List<Family> res = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Family fam = new Family();
            fam.setID("F" + i);
        }
        return res;
    }


    /**
     * random date generator from year 1850 to 2019
     * @return String date format: yyyy-MM-d
     */
    public static String randomDateGenerator() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1850, 2019);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        int month = gc.get(gc.MONTH) + 1;
        String m = month < 10? "0" + month: "" + month;
        return gc.get(gc.YEAR) + "-" + m + "-" + gc.get(gc.DAY_OF_MONTH);
    }

    /**
     * Generate a date, format: yyyy-MM-d
     * @return
     */
    public static String dateGenerator(int year, int month, int day) {
        String m = month < 10? "0" + month: "" + month;
        return year + "-" + m + "-" + day;
    }

    /**
     * @param startIdx index of the first individual, 0 means starting from I0
     * @param endIdx index of the last individual
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static List<Individual> individualWithSameBirthday(int startIdx, int endIdx, int year, int month, int day) {
        List<Individual> list = new ArrayList<>();
        for (int i = startIdx; i <= endIdx; i++) {
            list.add(individualWithIdAndBirthday(i, year, month, day));
        }
        return list;
    }

    /**
     * @param idx index of the first individual, 0 means I0
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Individual individualWithIdAndBirthday(int idx, int year, int month, int day) {
        Individual indi = new Individual();
        indi.setId("I" + idx);
        indi.setBirthday(dateGenerator(year, month, day));
        return indi;
    }

    /**
     * Generate random number between start and end
     * @param start
     * @param end
     * @return
     */
    private static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static List<Individual> addLists(List<Individual> list1, List<Individual> list2) {
        for (Individual indi: list2) list1.add(indi);
        return list1;
    }


    // for testing
//    public static void main(String[] args) {
////        System.out.println(yearsBetween("2018-08-15", "2017-03-1"));
////        System.out.println(monthsBetween("2016-03-19", "2016-08-18"));
//        System.out.println(daysBetween("2016-03-19", "2016-08-15"));
//        System.out.println(daysBetween("2000-05-1", "1995-09-3"));
//
//
//    }
}