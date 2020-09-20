import java.io.*;
import java.util.*;
public class Hw2Solution {
    static Scanner file;


    public void transform(String fileName) throws IOException {
        String outStr;
        file = new Scanner(new FileReader(fileName));
        FileWriter outputFile = new FileWriter("output.txt");
        String[] tagArray = {"INDI", "NAME", "SEX", "BIRT","DEAT", "FAMC", "FAMS", "FAM","MARR", "HUSB", "WIFE",
                            "CHIL", "DIV","DATE", "HEAD", "TRLR", "NOTE"};
        Set tagList = new HashSet(Arrays.asList(tagArray));
        while(file.hasNextLine()) {
            String lineStr= file.nextLine();
            String[] line = lineStr.split(" ");
            // level is 0
            if(line[0].equals("0")) {
                outputFile.write("-->" + lineStr);
                outputFile.write("\n");
                if(tagList.contains(line[1])) {
                    outStr = Hw2Solution.convertStr(line, line[1],"Y",1);
                    outputFile.write(outStr);
                    outputFile.write("\n");
                } else if(line.length > 2 && tagList.contains(line[2])) {
                    outStr = Hw2Solution.convertStr(line, line[2], "Y", 2);
                    outputFile.write(outStr);
                    outputFile.write("\n");
                } else {
                    outStr = Hw2Solution.convertStr(line, line[1], "N", 1);
                    outputFile.write(outStr);
                    outputFile.write("\n");
                }
            }
            //level is 1
            if(line[0].equals("1")) {
                if(line[1].equals("BIRT")) {
                    continue;
                } else if (tagList.contains(line[1])) {
                    outputFile.write("-->" + lineStr);
                    outputFile.write("\n");
                    outStr = Hw2Solution.convertStr(line, line[1], "Y", 1);
                    outputFile.write(outStr);
                    outputFile.write("\n");
                } else {
                    outputFile.write("-->" + lineStr);
                    outputFile.write("\n");
                    outStr = Hw2Solution.convertStr(line, line[1], "N", 1);
                    outputFile.write(outStr);
                    outputFile.write("\n");
                }
            }
            // level is 2
            if(line[0].equals("2")) {
                if(line[1].equals("GIVN") || line[1].equals("SURN")) {
                    continue;
                } else if(tagList.contains(line[1])) {
                    outputFile.write("-->" + lineStr);
                    outputFile.write("\n");
                    outStr = Hw2Solution.convertStr(line, line[1], "Y", 1);
                    outputFile.write(outStr);
                    outputFile.write("\n");
                } else {
                    outputFile.write("-->" + lineStr);
                    outputFile.write("\n");
                    outStr = Hw2Solution.convertStr(line, line[1], "N", 1);
                    outputFile.write(outStr);
                    outputFile.write("\n");
                }
            }
        }
        outputFile.close();

    }

    public static String convertStr(String[] str, String tag, String val, int index) {
        StringBuffer newStr = new StringBuffer();
        newStr.append("<--").append(str[0]).append("|").append(tag).append("|").append(val);

        if(str.length > 2) {
            if(index == 2) {
                newStr.append("|").append(str[1]);
                index++;
            }
            index = Math.max(index, 2);
            if(index < 3) {
                newStr.append("|");
            }
            for(int i = index; i < str.length; i++) {
                newStr.append(str[i]).append(" ");
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) throws IOException {
        //System.out.print("Please enter your file name: ");
        //Scanner scanner = new Scanner(System.in);
        //String fileName = scanner.nextLine();
        Hw2Solution solution = new Hw2Solution();
        solution.transform("hw1.ged");

        }
}
