
/*
    Sprint1
    US08 and 09
    @author Yichao Jia
    @date Sep 25 2020
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class US08and09{
    
    public static boolean US08(Family f){
        boolean res = true;
        String marriageDate = f.getMarried();
        String divorceDate = f.getDivorced();
        List<Individual> childList = f.getChildren();
        if (!divorceDate.equals("NA") && childList != null) {
            for (Individual c : childList) {
            	String birth = c.getBirthday();
            	if (HelperFuctions.daysBetween(marriageDate, birth) < 0) {
            		res = false;
            		System.out.println("ANOMALY: FAMILY: US08: 0: " + f.getID() + ": " + "child " + c.getId() + " born " + c.getBirthday() + " before marriage on " + f.getMarried());
            	}
            	
            	if (HelperFuctions.monthsBetween(divorceDate, birth) > 9) {
            		res = false;
            		System.out.println("ANOMALY: FAMILY: US08: 0: " + f.getID() + ": " + "child " + c.getId() + " born " + c.getBirthday() + " after divorce on " + f.getDivorced());

            	}
            }
        }else if (childList != null) {
        	for (Individual c : childList) {
            	String birth = c.getBirthday();
//            	System.out.println("marriage data: " + marriageDate);
//            	System.out.println("birth: " + birth);
            	if (HelperFuctions.daysBetween(marriageDate, birth) < 0) {
            		res = false;
            		System.out.println("ANOMALY: FAMILY: US08: 0: " + f.getID() + ": " + "child " + c.getId() + " born " + c.getBirthday() + " before marriage on " + f.getMarried());
            	}
        	}
        }
        else {
        	return res;
        }

        
        return res;
    }


	public static boolean US09(Family f, Map<String, Individual> individualMap) {
		boolean res = true;
		String husbandID = f.getHusbandID();
    	String wifeID = f.getWifeID();
    	Individual husband = individualMap.get(husbandID);
    	Individual wife = individualMap.get(wifeID);
        List<Individual> childList = f.getChildren();
        
//        System.out.println(husband.getDeath());
//        System.out.println(wife.getDeath());
//        
//        System.out.println("********");

        
        if ((husband.getDeath().equals("NA")) && (wife.getDeath().equals("NA"))) {
        	return res;
        }else if ((!husband.getDeath().equals("NA")) && (!wife.getDeath().equals("NA")) && childList != null) {
        	for (Individual c : childList) {
            	String birth = c.getBirthday();
        		
//        		System.out.println("husband death: " + husband.getDeath());
//        		System.out.println("birth: " + birth);
            	if (HelperFuctions.monthsBetween(husband.getDeath(), birth) > 9) {
            			res = false;
                		System.out.println("ANOMALY: FAMILY: US09: 0: " + f.getID() + ": " + "child " + c.getId() + " born " + c.getBirthday() + " after father's death " + husband.getDeath());

            		}
            	
            	
	            if (HelperFuctions.daysBetween(wife.getDeath(), birth) > 0) {
	            			res = false;
	                		System.out.println("ANOMALY: FAMILY: US09: 0: " + f.getID() + ": " + "child " + c.getId() + " born " + c.getBirthday() + " after mother's death " + wife.getDeath());
	
	            		}
            	
        	}
        }else if (!husband.getDeath().equals("NA")&& childList != null){
        	for (Individual c : childList) {
            	String birth = c.getBirthday();
            	System.out.println("husband death " + husband.getDeath());
            	if (HelperFuctions.monthsBetween(husband.getDeath(), birth) > 9) {
            		res = false;
                	System.out.println("ANOMALY: FAMILY: US09: 0: " + f.getID() + ": " + "child " + c.getId() + " born " + c.getBirthday() + " after father's death " + husband.getDeath());

            	}
            	
        	}
        }else if (!wife.getDeath().equals("NA") && childList != null) {
        	for (Individual c : childList) {
            	String birth = c.getBirthday();
//            	System.out.println("birth: " + birth);
//            	System.out.println("mother death " + wife.getDeath());
            	
            		if (HelperFuctions.daysBetween(wife.getDeath(), birth) > 0) {
            			res = false;
                		System.out.println("ANOMALY: FAMILY: US09: 0: " + f.getID() + ": " + "child " + c.getId() + " born " + c.getBirthday() + " after mother's death " + wife.getDeath());

            		}
            	
        	}
        }
        

		
    	return res;
	}

	

    public static void main(String[] args) {
    	Family f0 = new Family();
        Family f1 = new Family();
        Family f2 = new Family();
        Family f3 = new Family();
        Family f4 = new Family();
        
        Individual i50 = new Individual();
        Individual i51 = new Individual();
        
        Individual i52 = new Individual();
        Individual i53 = new Individual();
        
        Individual i54 = new Individual();
        Individual i55 = new Individual();
        
        Individual i56 = new Individual();
        Individual i57 = new Individual();
        
        Individual i58 = new Individual();
        Individual i59 = new Individual();
        
        Individual i0 = new Individual();
        Individual i1 = new Individual();
        Individual i2 = new Individual();
        Individual i3 = new Individual();
        
        Individual i4 = new Individual();
        Individual i5 = new Individual();
        Individual i6 = new Individual();
        Individual i7 = new Individual();
        
        Individual i8 = new Individual();
        Individual i9 = new Individual();
        Individual i10 = new Individual();
        Individual i11 = new Individual();
        
        Individual i12 = new Individual();
        Individual i13 = new Individual();
        Individual i14 = new Individual();
        Individual i15 = new Individual();

        Individual i16 = new Individual();
        
        Map<String, Individual> individualMap = new HashMap<String, Individual>();
        
      //parents of f0
      		i50.setId("I50");
      		i50.setDeath("NA");
      		i51.setId("I51");
      		i51.setDeath("2010-08-30");
      		//parents of f1
      		i52.setId("I52");
      		i52.setDeath("1999-08-08");
      		i53.setId("I53");
      		i53.setDeath("1999-08-08");
      		//parents of f2
      		i54.setId("I54");
      		i54.setDeath("1999-08-08");
      		i55.setId("I55");
      		i55.setDeath("1999-08-08");
      		//parents of f3
      		i56.setId("I56");
      		i56.setDeath("1999-08-08");
      		i57.setId("I57");
      		i57.setDeath("2005-10-20");
      		//parents of f4
      		i58.setId("I58");
      		i58.setDeath("2005-01-19");
      		i59.setId("I59");
      		i59.setDeath("1999-08-08");
		
		i0.setBirthday("2012-02-12");
		i1.setBirthday("1997-08-28");
		i2.setBirthday("1999-07-22");
		i3.setBirthday("2005-10-19");
		
		i4.setBirthday("1996-02-12");
		i5.setBirthday("1997-08-28");
		i6.setBirthday("1999-07-22");
		i7.setBirthday("2005-10-19");
		
		i8.setBirthday("1996-02-12");
		i9.setBirthday("1997-08-28");
		i10.setBirthday("1999-07-22");
		i11.setBirthday("2005-10-19");
		
		i12.setBirthday("1996-02-12");
		i13.setBirthday("1997-08-28");
		i14.setBirthday("1999-07-22");
		i15.setBirthday("2005-10-19");
		
		i16.setBirthday("2005-10-19");
		
		individualMap.put("I50", i50);
		individualMap.put("I51", i51);
		individualMap.put("I52", i52);
		individualMap.put("I53", i53);
		individualMap.put("I54", i54);
		individualMap.put("I55", i55);
		individualMap.put("I56", i56);
		individualMap.put("I57", i57);
		individualMap.put("I58", i58);
		individualMap.put("I59", i59);
		
		f0.setHusbandId("I50");
		f0.setWifeId("I51");
		f0.setMarried("1994-02-22");
		f0.setDivorced("2008-09-19");
	    f0.setChildren(new ArrayList<>());
	    f0.getChildren().add(i0);
	    f0.getChildren().add(i1);
	    f0.getChildren().add(i2);
	    f0.getChildren().add(i3);
	    
	    f1.setHusbandId("I52");
	    f1.setWifeId("I53");
	    f1.setMarried("1999-02-22");
		f1.setDivorced("2008-09-19");
        f1.setChildren(new ArrayList<>());
	    f1.getChildren().add(i4);
	    f1.getChildren().add(i5);
	    f1.getChildren().add(i6);
	    f1.getChildren().add(i7);
	    
	    f2.setHusbandId("I54");
	    f2.setWifeId("I55");
	    f2.setMarried("1994-02-22");
		f2.setDivorced("2001-09-19");
        f2.setChildren(new ArrayList<>());
	    f2.getChildren().add(i8);
	    f2.getChildren().add(i9);
	    f2.getChildren().add(i10);
	    f2.getChildren().add(i11);
	    
	    f3.setHusbandId("I56");
	    f3.setWifeId("I57");
	    f3.setMarried("1996-02-11");
		f3.setDivorced("2008-09-19");
        f3.setChildren(new ArrayList<>());
	    f3.getChildren().add(i12);
	    f3.getChildren().add(i13);
	    f3.getChildren().add(i14);
	    f3.getChildren().add(i15);
	    
	    f4.setHusbandId("I58");
	    f4.setWifeId("I59");
	    f4.setMarried("1994-02-22");
		f4.setDivorced("2005-01-19");
        f4.setChildren(new ArrayList<>());
	    f4.getChildren().add(i16);
	    
        System.out.println("\n--------------------US08--------------------");
        System.out.println(US08(f0));
        System.out.println(US08(f1));
        System.out.println(US08(f2));
        System.out.println(US08(f3));



        System.out.println("\n--------------------US09--------------------");
        System.out.println(US09(f0, individualMap));
        System.out.println(US09(f1, individualMap));
        System.out.println(US09(f2, individualMap));
        System.out.println(US09(f3, individualMap));
    }


}
