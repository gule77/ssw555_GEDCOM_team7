import java.io.*;
import java.util.*;

public class Project2 {
	public static String[] level0 = {"HEAD", "TRLR", "NOTE"};
	public static String[] level0_2 = {"INDI", "FAM"};
	public static String[] level1 = {"NAME", "SEX", "BIRT", "DEAT","FAMC","FAMS", "MARR", "HUSB","WIFE","CHIL","DIV"};
	public static String[] level2 = {"DATE"};
	
	public static boolean isValid(String level, String tag, String tag2) {
		if(level.equals("0")) {
			List<String> list = Arrays.asList(level0);
			List<String> list2 = Arrays.asList(level0_2);
			if(list.contains(tag)&&!list2.contains(tag2)) {
				return true;
			}else if(!list.contains(tag)&&list2.contains(tag2)){
				return true;
			}else {
				return false;
			}
		}else if(level.equals("1")) {
			List<String> list = Arrays.asList(level1);
			if(list.contains(tag)) {
				return true;
			}else {
				return false;
			}
		}else if(level.equals("2")) {
			List<String> list = Arrays.asList(level2);
			if(list.contains(tag)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		String newline = System.getProperty("line.separator");
		try {
			File file0 = new File("C:/Users/gule7/Desktop/study/555/home/2/output.txt");
			if (!file0.exists()) {
				file0.createNewFile();
			}
			FileWriter filewriter = new FileWriter(file0.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(filewriter);
			InputStream file = new FileInputStream("C:/Users/gule7/Desktop/study/555/home/2/My-Family-3-Sep-2020-938.ged");
			BufferedReader reader = new BufferedReader( new InputStreamReader(file));
			String str = null;
			while(true) {
				str = reader.readLine();
				String result="";
				if(str!=null) {
					List<String> arrayList = new ArrayList<>();
					arrayList.addAll(Arrays.asList(str.split(" ")));
					String level = arrayList.get(0);
					String tag = arrayList.get(1);
					String tag2 = null;
					if(arrayList.size()>2) {
						tag2 = arrayList.get(2);
					}
					if(isValid(level,tag,tag2)) {
						arrayList.add(2,"Y");
					}else {
						arrayList.add(2,"N");
					}
					arrayList.add(1,"|");
					arrayList.add(3,"|");
					arrayList.add(5,"|");
					for(int i=0;i<6;i++) {
						result=result+arrayList.get(i);
					}
					for(int i=6;i<arrayList.size();i++) {
						if(i==6) {
							result=result+arrayList.get(i);
						}else {
							result=result+" "+arrayList.get(i);
						}
					}
					result = "-->"+str+newline+"<--"+result+newline;
					System.out.print(result);
				}else {
					break;
				}
				writer.write(result);
			}
			writer.close();
			file.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
