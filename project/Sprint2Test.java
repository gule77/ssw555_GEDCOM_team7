package src;

public class Sprint2Test {
    public static void main(String[] args) {
        GedcomParse proj3 = new GedcomParse();
        proj3.readFile("TestForSprint1.ged");
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
        System.out.println("+-----+------------+------------+------------+--------------------+-----------+--------------------+---------------------------------------------+");
        System.out.println("| ID  | Married    | Divorced   | Husband ID | Husband Name       | Wife ID   | Wife Name          |                   Childern                  |");
        System.out.println("+-----+------------+------------+------------+--------------------+-----------+--------------------+---------------------------------------------+");
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
            System.out.printf("|%-5s|%-12s|%-12s|%-12s|%-20s|%-11s|%-20s|%-45s|%n",
                    family.getID(), family.getMarried(), family.getDivorced(), family.getHusbandID(), family.getHusbandName(),
                    family.getWifeID(), family.getWifeName(), childString);
        }
        System.out.println("+-----+------------+------------+------------+--------------------+-----------+--------------------+---------------------------------------------+");
        // List
        /* US15 */

        /* US16 */

        /* US17 */
        for(Family family : proj3.familyList) {
            US17and21.US17(family, proj3.individualMap, proj3.familyMap);
        }
        /* US18 */

        /* US19 */

        /* US21 */
        for(Family family : proj3.familyList) {
            US17and21.US21(family, proj3.individualMap);
        }
        /* US22 */

        /* US23 */

        /* US24 */
        US24and25.US24(proj3.familyList);

        /* US25 */
        US24and25.US25(proj3.familyList);

        /* US28 */

        /* US29 */

        /* US35 */
        US35and36.US35(proj3.individualList);

        /* US36 */
        US35and36.US36(proj3.individualList);
    }
}
