import java.util.*;

import org.junit.Assert;
import junit.framework.TestCase;

public class US03and12Test extends TestCase{

	public void test1() {
		Individual p1 = new Individual();
		p1.setId("P01");
		p1.setAlive(false);
		p1.setBirthday("1935-08-1");
		p1.setDeath("1900-08-1");
		
		Assert.assertEquals(false, US03and12.US03(p1));
	}
	public void test2(){
		Individual p2 = new Individual();
		p2.setId("P02");
		p2.setAlive(true);
		p2.setBirthday("1935-08-1");
		p2.setDeath("1941-08-1");

		Assert.assertEquals(true, US03and12.US03(p2));
	}
	public void test3() {
		Individual p1 = new Individual();
		p1.setId("P03");
		p1.setAlive(false);
		p1.setBirthday("1935-08-1");
		p1.setDeath("1901-08-1");
		Individual p2 = new Individual();
		p2.setId("P04");
		p2.setAlive(false);
		p2.setBirthday("1935-08-1");
		p2.setDeath("1902-08-1");

		Assert.assertEquals(US03and12.US03(p1), US03and12.US03(p2));
	}
	public void test4() {
		Individual p1 = new Individual();
		p1.setId("P05");
		p1.setAlive(false);
		p1.setBirthday("1935-08-1");
		p1.setDeath("1903-08-1");

		Assert.assertTrue(!US03and12.US03(p1));;
	}
	public void test5(){
		Individual p2 = new Individual();
		p2.setId("P06");
		p2.setAlive(true);
		p2.setBirthday("1935-08-1");
		p2.setDeath("1941-08-1");

		Assert.assertTrue(US03and12.US03(p2));;
	}
	public void test6(){
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f001");
		i1.setId("I101");
		i1.setBirthday("1908-01-01");
		i2.setId("I102");
		i2.setBirthday("1918-01-30");
		individualMap.put("I101", i1);
		individualMap.put("I102", i2);
		f1.setHusbandId("I101");
		f1.setWifeId("I102");
		f1.setChildren(new ArrayList<>());
		f1.getChildren().add(HelperFuctions.individualWithIdAndBirthday(111, 1991, 1, 11));
		Assert.assertTrue(!US03and12.US12(f1, individualMap));
	}
	public void test7(){
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f002");
		i1.setId("I201");
		i1.setBirthday("1928-01-01");
		i2.setId("I202");
		i2.setBirthday("1918-01-30");
		individualMap.put("I201", i1);
		individualMap.put("I202", i2);
		f1.setHusbandId("I201");
		f1.setWifeId("I202");
		f1.setChildren(new ArrayList<>());
		f1.getChildren().add(HelperFuctions.individualWithIdAndBirthday(222, 1991, 1, 11));
		Assert.assertTrue(!US03and12.US12(f1, individualMap));
	}
	public void test8(){
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f003");
		i1.setId("I301");
		i1.setBirthday("1908-01-01");
		i2.setId("I302");
		i2.setBirthday("1958-01-30");
		individualMap.put("I301", i1);
		individualMap.put("I302", i2);
		f1.setHusbandId("I301");
		f1.setWifeId("I302");
		f1.setChildren(new ArrayList<>());
		f1.getChildren().add(HelperFuctions.individualWithIdAndBirthday(333, 1991, 1, 11));
		Assert.assertTrue(!US03and12.US12(f1, individualMap));
	}
	public void test9(){
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f004");
		i1.setId("I401");
		i1.setBirthday("1938-01-01");
		i2.setId("I402");
		i2.setBirthday("1958-01-30");
		individualMap.put("I401", i1);
		individualMap.put("I402", i2);
		f1.setHusbandId("I401");
		f1.setWifeId("I402");
		f1.setChildren(new ArrayList<>());
		f1.getChildren().add(HelperFuctions.individualWithIdAndBirthday(444, 1991, 1, 11));
		Assert.assertTrue(US03and12.US12(f1, individualMap));
	}
	public void test10(){
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f005");
		i1.setId("I501");
		i1.setBirthday("1938-01-01");
		i2.setId("I502");
		i2.setBirthday("1908-01-30");
		individualMap.put("I501", i1);
		individualMap.put("I502", i2);
		f1.setHusbandId("I501");
		f1.setWifeId("I502");
		f1.setChildren(new ArrayList<>());
		f1.getChildren().add(HelperFuctions.individualWithIdAndBirthday(555, 1991, 1, 11));
		
		Family f2 = new Family();
		Individual i3 = new Individual();
		Individual i4 = new Individual();
		f2.setID("f006");
		i3.setId("I601");
		i3.setBirthday("1908-01-01");
		i4.setId("I602");
		i4.setBirthday("1958-01-30");
		individualMap.put("I601", i3);
		individualMap.put("I602", i4);
		f2.setHusbandId("I601");
		f2.setWifeId("I602");
		f2.setChildren(new ArrayList<>());
		f2.getChildren().add(HelperFuctions.individualWithIdAndBirthday(666, 1991, 1, 11));
		
		Assert.assertEquals(US03and12.US12(f1, individualMap), US03and12.US12(f2, individualMap));
	}
}
