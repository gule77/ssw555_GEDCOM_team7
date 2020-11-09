import java.text.ParseException;

public class Sprint3Test {
	public static void main(String[] args) {
		GedcomParse proj3 = new GedcomParse();
		proj3.readFile("TestForSprint3.ged");
		proj3.writeIntoIndividualList();
		proj3.writeIntofamilyList();
		System.out.println("People");
		System.out.println(
				"+-----+--------------------+--------+-----------+-----+-------+------------+--------------------+-----------+");
		System.out.println(
				"| ID  | Name               | Gender | Birthday  | Age | Alive | Death      | Child              | Spouse    |");
		System.out.println(
				"+-----+--------------------+--------+-----------+-----+-------+------------+--------------------+-----------+");
		for (Individual person : proj3.individualList) {
			String child;
			if (!person.getChild().equals("NA")) {
				child = "{'" + person.getChild() + "'}";
			} else {
				child = "NA";
			}
			String spouse;
			if (!person.getSpouse().equals("NA")) {
				spouse = "{'" + person.getSpouse() + "'}";
			} else {
				spouse = "NA";
			}
			System.out.printf("|%-5s|%-20s|%-8s|%-11s|%-5d|%-7b|%-12s|%-20s|%-11s|%n", person.getId(), person.getName(),
					person.getGender(), person.getBirthday(), person.getAge(), person.getIsAlive(), person.getDeath(),
					child, spouse);
		}
		System.out.println(
				"+-----+--------------------+--------+-----------+-----+-------+------------+--------------------+-----------+");
		System.out.println("Families");
		System.out.println(
				"+-----+------------+------------+------------+--------------------+-----------+--------------------+---------------------------------------------+");
		System.out.println(
				"| ID  | Married    | Divorced   | Husband ID | Husband Name       | Wife ID   | Wife Name          |                   Childern                  |");
		System.out.println(
				"+-----+------------+------------+------------+--------------------+-----------+--------------------+---------------------------------------------+");
		for (Family family : proj3.familyList) {
			String childString = "";
			if (!(family.getChildren() == null)) {
				for (Individual child : family.getChildren()) {
					childString = childString + "','" + child.getId();
				}
				childString = childString.substring(2);
				childString = "{" + childString + "'}";
			} else {
				childString = "NA";
			}
			System.out.printf("|%-5s|%-12s|%-12s|%-12s|%-20s|%-11s|%-20s|%-45s|%n", family.getID(), family.getMarried(),
					family.getDivorced(), family.getHusbandID(), family.getHusbandName(), family.getWifeID(),
					family.getWifeName(), childString);
		}
		System.out.println(
				"+-----+------------+------------+------------+--------------------+-----------+--------------------+---------------------------------------------+");
		
		//US30 and US31
		US30and31 sprint3 = new US30and31();
		sprint3.US30(proj3.individualList);
		sprint3.US31(proj3.individualList);
		
		
		//US34 and US37
                for (Family family : proj3.familyList) {
                    try {
			US34and37.US37(family, proj3.individualMap);
			US34and37.US34(family, proj3.individualMap);
                    } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }
                }
		
		
		//US20 and 26
		US20and26.US20(proj3.familyList);
		US20and26.US26(proj3.familyList, proj3.individualMap);
                
                
                //US32 and 33
		US32and33.US32(proj3.familyList);
		US32and33.US33(proj3.familyList, proj3.individualList);
                
                
                //US40 and 41
                US40and41.US40(proj3.individualList.get(0).getId());
                US40and41.US40(proj3.familyList.get(0).getID());
		US40and41.US41(proj3.familyList, proj3.individualList);
                
                
                //US53 and 54
		US53and54.US53(proj3.individualList);
		US53and54.US54(proj3.individualList);
                
                
                //US27 and 42
                System.out.println("US27: ");
                for (Individual individual : proj3.individualList) {
                    System.out.println(US27and42.US27(individual));
                    US27and42.US42IndividualDate(individual);
                }
		for (Family family : proj3.familyList) {
                    US27and42.US42FamilyDate(family);
                }
		
	}
}
