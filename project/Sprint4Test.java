//package project;

import java.text.ParseException;

public class Sprint4Test {
    public static void main(String[] args) {
        GedcomParse proj3 = new GedcomParse();
        proj3.readFile("TestForSprint4.ged");
        proj3.writeIntoIndividualList();
        proj3.writeIntofamilyList();
        System.out.println("People");
        System.out.println("+-----+--------------------+--------+-----------+-----+-------+------------+--------------------+-----------+");
        System.out.println("| ID  | Name               | Gender | Birthday  | Age | Alive | Death      | Child              | Spouse    |");
        System.out.println("+-----+--------------------+--------+-----------+-----+-------+------------+--------------------+-----------+");
        for (Individual person : proj3.individualList) {
            String child;
            if(!person.getChild().equals("NA")) {
                child = "{'"+person.getChild()+"'}";
            }else {
                child = "NA";
            }
            String spouse;
            if(!person.getSpouse().equals("NA")) {
                spouse = "{'"+person.getSpouse()+"'}";
            }else {
                spouse = "NA";
            }
            System.out.printf("|%-5s|%-20s|%-8s|%-11s|%-5d|%-7b|%-12s|%-20s|%-11s|%n",
                    person.getId(), person.getName(), person.getGender(), person.getBirthday(),
                    person.getAge(), person.getIsAlive(), person.getDeath(),  child  ,  spouse );
        }
        System.out.println("+-----+--------------------+--------+-----------+-----+-------+------------+--------------------+-----------+");
        System.out.println("Families");
        System.out.println("+-----+------------+------------+------------+--------------------+-----------+--------------------+--------------------+");
        System.out.println("| ID  | Married    | Divorced   | Husband ID | Husband Name       | Wife ID   | Wife Name          |   Childern         |");
        System.out.println("+-----+------------+------------+------------+--------------------+-----------+--------------------+--------------------+");
        for (Family family : proj3.familyList) {
            String childString="";
            if(!(family.getChildren()==null)) {
                for(Individual child: family.getChildren()) {
                    childString = childString+"','"+child.getId();
                }
                childString = childString.substring(2);
                childString = "{"+childString+"'}";
            }else {
                childString = "NA";
            }
            System.out.printf("|%-5s|%-12s|%-12s|%-12s|%-20s|%-11s|%-20s|%-20s|%n",
                    family.getID(), family.getMarried(), family.getDivorced(), family.getHusbandID(), family.getHusbandName(),
                    family.getWifeID(), family.getWifeName(), childString);
        }
        System.out.println("+-----+------------+------------+------------+--------------------+-----------+--------------------+--------------------+");

        // List
        /* US38and39 by dy */
        US38and39.US38(proj3.individualList);
        US38and39.US39(proj3.familyList, proj3.individualMap);

        /* US43and52 by zs */
        US43and52.US43(proj3.individualList);
        US43and52.US52(proj3.familyList);

        /* US44and45 by yj*/
        US44and45.US44(proj3.familyList, proj3.individualList);
        US44and45.US45(proj3.familyList);

        /* US46and47 by wp */
        System.out.println(US46and47.US46(proj3.individualList));
        System.out.println(US46and47.US47(proj3.familyList));

        /* US48and49 by xz */
        US48and49.US48(proj3.individualList);
        US48and49.US49(proj3.familyList, proj3.individualMap);

        /* US50and51 by bs */
        US50and51.US50(proj3.familyList);
        try {
            US50and51.US51(proj3.familyList, proj3.individualMap);
        }
        catch (Exception e) {
            System.out.println("Error: US51");
        }

        /* US55and56 by xd */
        System.out.println(US55and56.US55(proj3.familyList));
        System.out.println(US55and56.US56(proj3.familyList));
    }
}