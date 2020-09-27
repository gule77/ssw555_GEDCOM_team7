
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class GedcomParse {

	List<Individual> individualList;
	List<Family> familyList;
	List<String> dataGet;
	Map<String, Individual> individualMap;
	Map<String, Family> familyMap;
	
	public GedcomParse() {
		individualList = new ArrayList<Individual>();
		familyList = new ArrayList<Family>();
		dataGet = new ArrayList<String>();
		individualMap = new HashMap<String, Individual>();
		familyMap = new HashMap<String, Family>();
	}
	
	public void readFile() {
		try {
			InputStream file = new FileInputStream("2.ged");
			BufferedReader reader = new BufferedReader( new InputStreamReader(file));
			String str = null;
			while(true) {
				str = reader.readLine();
				if(str!=null) {
					dataGet.add(str);
				}else {
					break;
				}
			}
			file.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();

            now.setTime(new Date());
            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
                    age -= 1;
                }
            }
            return age;
        } catch (Exception e) {
           return 0;
        }
    }
	private static int getAgeByDeath(Date birthday,Date deathDate) {
		int age = 0;
		try {
			Calendar death = Calendar.getInstance();
			death.setTime(deathDate);

			Calendar birth = Calendar.getInstance();
			birth.setTime(birthday);

			if (birth.after(death)) {
				age = 0;
			} else {
				age = death.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
				if (death.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
					age -= 1;
				}
			}
			return age;
		} catch (Exception e) {
			return 0;
		}
	}
	public void writeIntoIndividualList() {
		for(int i = 0; i<dataGet.size();i++) {
			String strTem = dataGet.get(i);
			String str[] = strTem.split(" ");
			try {
				if(str[0].equals("0") && str.length>=3 && str[2].equals("INDI")) {
					Individual thisPerson = new Individual();
					String id = str[1].replaceAll("@","");
					thisPerson.setId(id);
					thisPerson.setLine(i + 1);
					thisPerson.setAlive(true);
					thisPerson.setDeath("NA");
					thisPerson.setChild("NA");
					thisPerson.setSpouse("NA");
					individualList.add(thisPerson);
					individualMap.put(id,thisPerson);
				}
				
				if(str[0].equals("1")) {
					if(str[1].equals("NAME")) {
						String name="";
						for(int j=2; j<str.length;j++) {
							name = name +" "+ str[j];
						}
						individualList.get(individualList.size()-1).setName(name);
					}else if(str[1].equals("SEX")) {
						individualList.get(individualList.size()-1).setGender(str[2]);
					}else if(str[1].equals("BIRT")) {
						String birthString = dataGet.get(++i);
						String[] birthArray = birthString.split(" ");
						if(birthArray[0].equals("2") && birthArray[1].equals("DATE")) {
							String day = birthArray[2];
							String month = birthArray[3];
							String year = birthArray[4];
							
							switch(month) {
							case "JAN": month = "-01-"; break;
							case "FEB": month = "-02-"; break;
							case "MAR": month = "-03-"; break;
							case "APR": month = "-04-"; break;
							case "MAY": month = "-05-"; break;
							case "JUN": month = "-06-"; break;
							case "JUL": month = "-07-"; break;
							case "AUG": month = "-08-"; break;
							case "SEP": month = "-09-"; break;
							case "OCT": month = "-10-"; break;
							case "NOV": month = "-11-"; break;
							case "DEC": month = "-12-"; break;
							default: month ="-Error-";
							}
							individualList.get(individualList.size()-1).setBirthday(year+month+day);
					        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					        Date birthday = format.parse(year+month+day);
					        int age = getAgeByBirth(birthday);
							individualList.get(individualList.size()-1).setAge(age);
						}
					}else if(str[1].equals("DEAT")) {
						String deathString = dataGet.get(++i);
						String[] deathArray = deathString.split(" ");
						if(deathArray[0].equals("2") && deathArray[1].equals("DATE")) {
							String day = deathArray[2];
							String month = deathArray[3];
							String year = deathArray[4];
							
							switch(month) {
							case "JAN": month = "-01-"; break;
							case "FEB": month = "-02-"; break;
							case "MAR": month = "-03-"; break;
							case "APR": month = "-04-"; break;
							case "MAY": month = "-05-"; break;
							case "JUN": month = "-06-"; break;
							case "JUL": month = "-07-"; break;
							case "AUG": month = "-08-"; break;
							case "SEP": month = "-09-"; break;
							case "OCT": month = "-10-"; break;
							case "NOV": month = "-11-"; break;
							case "DEC": month = "-12-"; break;
							default: month ="-Error-";
							}
							individualList.get(individualList.size()-1).setDeath(year+month+day);
							individualList.get(individualList.size()-1).setAlive(false);
							SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							Date deathDate = format.parse(year+month+day);
							String birthday = individualList.get(individualList.size()-1).getBirthday();
							Date birth = format.parse(birthday);
							int age = getAgeByDeath(birth, deathDate);
							individualList.get(individualList.size()-1).setAge(age);
							individualList.get(individualList.size()-1).setdeathLine(i+1);
						}
					}else if(str[1].equals("FAMC")) {
						String family_ID = str[2];
						family_ID = family_ID.replaceAll("@", "");
						individualList.get(individualList.size()-1).setChild(family_ID);

					}else if(str[1].equals("FAMS")) {
						String family_ID = str[2];
						family_ID = family_ID.replaceAll("@", "");
						individualList.get(individualList.size()-1).setSpouse(family_ID);
					}
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeIntofamilyList() {
		for(int i = 0; i<dataGet.size();i++) {
			String strTem = dataGet.get(i);
			String str[] = strTem.split(" ");
			
			try {
				if(str[0].equals("0")) {
					if(str.length>=3 && str[2].equals("FAM")) {
						Family thisFamily = new Family();
						String id = str[1].replaceAll("@","");
						thisFamily.setID(id);
						thisFamily.setLine(i + 1);
						thisFamily.setMarried("NA");
						thisFamily.setDivorced("NA");
						familyList.add(thisFamily);
						familyMap.put(id, thisFamily);
					}
				}else if(str[0].equals("1")){
					if(str[1].equals("MARR")) {
						String marrString = dataGet.get(++i);
						String[] marrArray = marrString.split(" ");
						if(marrArray[0].equals("2") && marrArray[1].equals("DATE")) {
							
							if(marrArray.length>=5) {
								String day = marrArray[2];
								String month = marrArray[3];
								String year = marrArray[4];
							
								switch(month) {
								case "JAN": month = "-01-"; break;
								case "FEB": month = "-02-"; break;
								case "MAR": month = "-03-"; break;
								case "APR": month = "-04-"; break;
								case "MAY": month = "-05-"; break;
								case "JUN": month = "-06-"; break;
								case "JUL": month = "-07-"; break;
								case "AUG": month = "-08-"; break;
								case "SEP": month = "-09-"; break;
								case "OCT": month = "-10-"; break;
								case "NOV": month = "-11-"; break;
								case "DEC": month = "-12-"; break;
								default: month ="-Error-";
								}
								familyList.get(familyList.size()-1).setMarried(year+month+day);
							}else if(marrArray.length==3) {
								String year = marrArray[2];
								familyList.get(familyList.size()-1).setMarried(year);
							}
						}
					}else if(str[1].equals("HUSB")) {
						String id = str[2];
						id = id.replaceAll("@", "");
						Individual husband = individualMap.get(id);
						familyList.get(familyList.size()-1).setHusbandId(id);
						familyList.get(familyList.size()-1).setHusbandName(husband.getName());
					}else if(str[1].equals("WIFE")) {
						String id = str[2];
						id = id.replaceAll("@", "");
						Individual wife = individualMap.get(id);
						familyList.get(familyList.size()-1).setWifeId(id);
						familyList.get(familyList.size()-1).setWifeName(wife.getName());	
					}else if(str[1].equals("CHIL")) {
						String id = str[2];
						id = id.replaceAll("@", "");
						Family thisFamily = familyList.get(familyList.size()-1);
//						List<String> childList = thisFamily.getChildren();
//						if(childList == null) {
//							childList = new ArrayList<String>();
//						}
//						childList.add(id);
//						thisFamily.setChildren(childList);
						if( thisFamily.getChildren() == null) thisFamily.setChildren(new ArrayList<>());
						thisFamily.getChildren().add(individualMap.get(id));
					}else if(str[1].equals("DIV")) {
						String divString = dataGet.get(++i);
						String[] divArray = divString.split(" ");
						if(divArray[0].equals("2") && divArray[1].equals("DATE")) {

							if(divArray.length>=5) {
								String day = divArray[2];
								String month = divArray[3];
								String year = divArray[4];

								switch(month) {
									case "JAN": month = "-01-"; break;
									case "FEB": month = "-02-"; break;
									case "MAR": month = "-03-"; break;
									case "APR": month = "-04-"; break;
									case "MAY": month = "-05-"; break;
									case "JUN": month = "-06-"; break;
									case "JUL": month = "-07-"; break;
									case "AUG": month = "-08-"; break;
									case "SEP": month = "-09-"; break;
									case "OCT": month = "-10-"; break;
									case "NOV": month = "-11-"; break;
									case "DEC": month = "-12-"; break;
									default: month ="-Error-";
								}
								familyList.get(familyList.size()-1).setDivorced(year+month+day);
							}else if(divArray.length==3) {
								String year = divArray[2];
								familyList.get(familyList.size()-1).setDivorced(year);
							}
						}
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


	
	public static void main(String[] args) {
		GedcomParse proj3 = new GedcomParse();
		proj3.readFile();
		proj3.writeIntoIndividualList();
		proj3.writeIntofamilyList();
		//
		
		 
		System.out.println("Individuals");
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
//			 if(!person.getChild().equals("NA")) {
//			 	List<Individual> childList = proj3.familyMap.get(person.getChild()).getChildren();
//			 	String childStr = "";
//			 	for(Individual childId : childList) {
//			 		childStr = childStr + "','" + childId.getId();
//				}
//			 	childStr = childStr.substring(3);
//				 child = "{'"+childStr+"'}";
//			 }else {
//				 child = "NA";
//			 }
//			 String spouse;
//			 if(!person.getSpouse().equals("NA")) {
//			 	String spouseId = proj3.familyMap.get(person.getSpouse()).getHusbandID();
//			 	if(spouseId.equals(person.getId())) {
//			 		spouseId = proj3.familyMap.get(person.getSpouse()).getWifeID();
//				}
//				 spouse = "{'"+ spouseId+"'}";
//			 }else {
//				 spouse = "NA";
//			 }
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
			
//			for(Individual child: family.getChildren()) {
//				childString = childString+"','"+child.getId();
//			}
//			childString = childString.substring(2);
//			childString = "{"+childString+"'}";
			System.out.printf("|%-5s|%-12s|%-12s|%-12s|%-20s|%-11s|%-20s|%-20s|%n",
					family.getID(), family.getMarried(), family.getDivorced(), family.getHusbandID(), family.getHusbandName(),
					family.getWifeID(), family.getWifeName(), childString);
		}
		System.out.println("+-----+------------+------------+------------+--------------------+-----------+--------------------+--------------------+");
		US03.US03(proj3.individualList);
	}
}
