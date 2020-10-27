//package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.*;

import org.junit.Assert;
import junit.framework.TestCase;
public class US34and37Test extends TestCase{
    public void test1() throws ParseException{
    	Family f1 = new Family();
    	Individual i1 = new Individual();
    	Individual i2 = new Individual();
    	Map<String, Individual> individualMap = new HashMap<String, Individual>();
    	f1.setID("f001");
    	i1.setId("I101");
    	i1.setBirthday("1908-01-01");
    	i2.setId("I102");
    	i2.setBirthday("1888-01-30");
    	individualMap.put("I101", i1);
    	individualMap.put("I102", i2);
    	f1.setHusbandId("I101");
    	f1.setWifeId("I102");
    	f1.setMarried("1958-11-11");
        Assert.assertTrue(US34and37.US34(f1, individualMap));
    }
    
    public void test2() throws ParseException{
    	Family f1 = new Family();
    	Individual i1 = new Individual();
    	Individual i2 = new Individual();
    	Map<String, Individual> individualMap = new HashMap<String, Individual>();
    	f1.setID("f002");
    	i1.setId("I103");
    	i1.setBirthday("1908-01-01");
    	i2.setId("I104");
    	i2.setBirthday("1808-01-30");
    	individualMap.put("I103", i1);
    	individualMap.put("I104", i2);
    	f1.setHusbandId("I103");
    	f1.setWifeId("I104");
    	f1.setMarried("1958-11-11");
    	Assert.assertEquals(false, US34and37.US34(f1, individualMap));
    }
    
    public void test3() throws ParseException{
    	Family f1 = new Family();
    	Individual i1 = new Individual();
    	Individual i2 = new Individual();
    	Map<String, Individual> individualMap = new HashMap<String, Individual>();
    	f1.setID("f003");
    	i1.setId("I105");
    	i1.setBirthday("1908-01-01");
    	i1.setAlive(false);
    	i1.setDeath("2020-10-20");
    	i2.setId("I106");
    	i2.setBirthday("1888-01-11");
    	i2.setAlive(true);
    	individualMap.put("I105", i1);
    	individualMap.put("I106", i2);
    	f1.setHusbandId("I105");
    	f1.setWifeId("I106");
    	Assert.assertEquals(false, US34and37.US37(f1, individualMap));
    }
    
    public void test4() throws ParseException{
    	Family f1 = new Family();
    	Individual i1 = new Individual();
    	Individual i2 = new Individual();
    	Map<String, Individual> individualMap = new HashMap<String, Individual>();
    	f1.setID("f004");
    	i1.setId("I107");

    	i1.setAlive(false);
    	i1.setDeath("2020-09-25");
    	i2.setId("I108");

    	i2.setAlive(true);
    	individualMap.put("I107", i1);
    	individualMap.put("I108", i2);
    	f1.setHusbandId("I107");
    	f1.setWifeId("I108");
    	f1.setChildren(new ArrayList<>());
    	Individual i3 = new Individual();
    	i3.setId("I109");
    	i3.setAlive(true);
    	individualMap.put("I109", i3);
    	Individual i4 = new Individual();
    	i4.setId("I110");
    	i4.setAlive(false);
    	individualMap.put("I110", i4);
    	Individual i5 = new Individual();
    	i5.setId("I111");
    	i5.setAlive(true);
    	individualMap.put("I111", i5);
    	
        f1.getChildren().add(i3);
        f1.getChildren().add(i4);
        f1.getChildren().add(i5);
    	Assert.assertTrue(US34and37.US37(f1, individualMap));
    }

    // tests below are written by xd
	public void test5() throws ParseException{  // 50 years old and 100 years old,
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f005");
		i1.setId("I103");
		i1.setBirthday("1908-01-01");
		i2.setId("I104");
		i2.setBirthday("1858-01-30");
		individualMap.put("I103", i1);
		individualMap.put("I104", i2);
		f1.setHusbandId("I103");
		f1.setWifeId("I104");
		f1.setMarried("1958-11-11");
		Assert.assertTrue(US34and37.US34(f1, individualMap));
	}

	public void test6() throws ParseException{ //50 years old and 99 years old
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f006");
		i1.setId("I103");
		i1.setBirthday("1908-01-01");
		i2.setId("I104");
		i2.setBirthday("1858-11-12");
		individualMap.put("I103", i1);
		individualMap.put("I104", i2);
		f1.setHusbandId("I103");
		f1.setWifeId("I104");
		f1.setMarried("1958-11-11");
		Assert.assertTrue(US34and37.US34(f1, individualMap));
	}

	public void test7() throws ParseException{
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f007");
		i1.setId("I103");
		i1.setBirthday("1868-01-01");
		i2.setId("I104");
		i2.setBirthday("1908-01-30");
		individualMap.put("I103", i1);
		individualMap.put("I104", i2);
		f1.setHusbandId("I103");
		f1.setWifeId("I104");
		f1.setMarried("1958-11-11");
		Assert.assertTrue(US34and37.US34(f1, individualMap));
	}

	public void test8() throws ParseException{  // 30years old and 61 years old
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f008");
		i1.setId("I103");
		i1.setBirthday("1970-11-11");
		i2.setId("I104");
		i2.setBirthday("1939-11-11");
		individualMap.put("I103", i1);
		individualMap.put("I104", i2);
		f1.setHusbandId("I103");
		f1.setWifeId("I104");
		f1.setMarried("2000-11-11");
		Assert.assertFalse(US34and37.US34(f1, individualMap));
	}

	public void test9() throws ParseException{  // 30years old and 61 years old
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f009");
		i1.setId("I103");
		i1.setBirthday("1939-11-11");
		i2.setId("I104");
		i2.setBirthday("1970-11-11");
		individualMap.put("I103", i1);
		individualMap.put("I104", i2);
		f1.setHusbandId("I103");
		f1.setWifeId("I104");
		f1.setMarried("2000-11-11");
		Assert.assertFalse(US34and37.US34(f1, individualMap));
	}

	public void test10() throws ParseException{
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f010");
		i1.setId("I105");
		i1.setAlive(false);
		i1.setDeath("2020-10-20");
		i2.setId("I106");
		i2.setAlive(false);
		i2.setDeath("2020-10-26");
		individualMap.put("I105", i1);
		individualMap.put("I106", i2);
		f1.setHusbandId("I105");
		f1.setWifeId("I106");
		Assert.assertTrue(US34and37.US37(f1, individualMap));
	}

	public void test11() throws ParseException{
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Individual i3 = new Individual();
		Individual i4 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f011");
		i1.setId("I105");
		i1.setAlive(false);
		i1.setDeath("2020-09-20");
		i2.setId("I106");
		i2.setAlive(false);
		i2.setDeath("2020-09-26");
		i3.setId("I107");
		i3.setAlive(false);
		i3.setDeath("2020-10-26");
		i4.setId("I108");
		i4.setAlive(false);
		i4.setDeath("2020-09-26");
		individualMap.put("I105", i1);
		individualMap.put("I106", i2);
		f1.setHusbandId("I105");
		f1.setWifeId("I106");
		List<Individual> children = new ArrayList<>();
		children.add(i3);
		children.add(i4);
		f1.setChildren(children);
		Assert.assertFalse(!US34and37.US37(f1, individualMap));
	}
}
