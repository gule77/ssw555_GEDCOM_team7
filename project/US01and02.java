/*
    Sprint 1
    US01 and US02
    @author: Weijie Pan
    @date Sep 26 2020
 */

import java.text.ParseException;
import java.util.*;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
public class US01and02 {
    /*
    check if the birth date occurs after current date
    check if the dead date occurs after current date
 */
    public static boolean US01(Individual person) throws ParseException {
        boolean res = true;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = sdf.parse(LocalDate.now().toString());
        Date birthDate = sdf.parse(person.getBirthday());
        if(!(person.getDeath() == null || person.getDeath().equals("NA"))) {
            Date deathDate = sdf.parse(person.getDeath());
            if(deathDate.after(now)) {
                System.out.println("ERROR INDIVIDUAL US01: " + person.getLine() + ": " + person.getId()+ ": Dead date occurs after current date");
                res = false;
            }
        }
        if(birthDate.after(now)) {
            System.out.println("ERROR INDIVIDUAL US01: " + person.getLine() + ": " + person.getId()+ ": Birth date  occurs after current date");
            res = false;
        }
        return res;
    }
    /*
        check if the marriage date occurs after current date
        check if the divorced date occurs after current date
     */
    public static boolean US01(Family family) throws ParseException {
        boolean res = true;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = sdf.parse(LocalDate.now().toString());
        if(!(family.getMarried() == null || family.getMarried().equals("NA"))) {
            Date marriedDate = sdf.parse(family.getMarried());
            if(marriedDate.after(now)) {
                System.out.println("ERROR FAMILY US01: " + family.getLine() + ": "+ family.getID() + ": Marriage date occurs after current date");
                res = false;
            }
        }
        if(!(family.getDivorced() == null || family.getDivorced().equals("NA"))) {
            Date divorcedDate = sdf.parse(family.getDivorced());
            if(divorcedDate.after(now)) {
                System.out.println("ERROR FAMILY US01: " + family.getLine() + ": "+ family.getID() + ": Divorced date occurs after current date");
                res = false;
            }
        }
        return res;

    }
    /*
        check if the marriage date occurs after birth date
        check if the divorced date occurs after birth date
     */
       public static boolean US02(Family family, Individual individual) throws ParseException {
           boolean res = true;
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           if(!(family.getMarried() == null || family.getMarried().equals("NA"))){
               Date marriedDate = sdf.parse(family.getMarried());
               Date Birth = sdf.parse(individual.getBirthday());
               if(Birth.after(marriedDate)) {
                   System.out.println("ERROR INDIVIDUAL US02: " + individual.getLine() + ": " +  individual.getId() + ": Birth date occurs after the marriage date");
                   res = false;
               }
           }
           return res;
       }
    public static void main(String[] args) throws ParseException {
    }
}
