/*
    HelperFunctions:
    1. dateDifference(years, months, days);
    @author Xiaoxiao Deng
    @date Sep 25, 2020
 */


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

    public static void main(String[] args) {
        System.out.println(yearsBetween("2018-08-15", "2017-03-1"));
        System.out.println(monthsBetween("2016-03-19", "2016-08-18"));
        System.out.println(daysBetween("2016-03-19", "2016-08-15"));
        System.out.println(daysBetween("2016-08-15", "2017-03-1"));
    }
}