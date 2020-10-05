import java.text.ParseException;

public class Sprint1Test {
	public static void main(String[] args) {
		GedcomParse proj3 = new GedcomParse();
		proj3.readFile("team7.ged");
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
		US04and05.US04(proj3.familyList);
		US04and05.US05(proj3.individualList,proj3.familyList);
		US06and07.US06(proj3.familyList, proj3.individualMap);
		US06and07.US07(proj3.individualList);
		US10and11.us10(proj3.familyList,proj3.individualList);
		US10and11.us11(proj3.familyList,proj3.individualList);
		//
		for(Individual person: proj3.individualList) {
			try {
				US01and02.US01(person);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			US03and12.US03(person);
		}
		
		for (Family family : proj3.familyList) {
			US08and09.US08(family);
			US08and09.US09(family, proj3.individualMap);
			/* US01 */ 
			try {
				US01and02.US01(family);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			US03and12.US12(family, proj3.individualMap);
			/* US02 */ 
			String husbandid = family.getHusbandID();
			String wifeid = family.getWifeID();
			Individual husband = proj3.individualMap.get(husbandid);
			Individual wife = proj3.individualMap.get(wifeid);
			try {
				US01and02.US02(family,husband);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				US01and02.US02(family,wife);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}