//package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.*;

import org.junit.Assert;
import junit.framework.TestCase;
public class US48and49Test extends TestCase{
    public void test1() throws ParseException{
    	Individual i1 = new Individual();
    	Individual i2 = new Individual();
    	Map<String, Individual> individualMap = new HashMap<String, Individual>();
    	i1.setId("I101");
    	i1.setAlive(true);
    	i1.setAge(17);
    	i2.setId("I102");
    	i2.setAlive(true);
    	i2.setAge(1);
    	individualMap.put("I101", i1);
    	individualMap.put("I102", i2);
		List<Individual> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
        Assert.assertTrue(!US48and49.US48(list));
    }
    
    public void test2() throws ParseException{
    	Individual i1 = new Individual();
    	Individual i2 = new Individual();
    	Map<String, Individual> individualMap = new HashMap<String, Individual>();
    	i1.setId("I103");
    	i1.setAlive(false);
    	i1.setAge(17);
    	i2.setId("I104");
    	i2.setAlive(true);
    	i2.setAge(19);
    	individualMap.put("I101", i1);
    	individualMap.put("I102", i2);
		List<Individual> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
        Assert.assertTrue(US48and49.US48(list));
    }
    
    public void test3() throws ParseException{
    	Family f1 = new Family();
    	Individual i1 = new Individual();
    	Individual i2 = new Individual();
    	Map<String, Individual> individualMap = new HashMap<String, Individual>();
    	f1.setID("f001");
    	i1.setId("I105");
    	i1.setAlive(true);
    	i1.setAge(44);
    	i2.setId("I106");
    	i2.setAlive(true);
    	i2.setAge(44);
    	individualMap.put("I105", i1);
    	individualMap.put("I106", i2);
    	f1.setHusbandId("I105");
    	f1.setWifeId("I106");
    	List<Family> list = new ArrayList<>();
    	list.add(f1);
    	Family f2 = new Family();
    	Individual i3 = new Individual();
    	Individual i4 = new Individual();
    	f2.setID("f004");
    	i3.setId("I111");
    	i3.setAlive(true);
    	i3.setAge(55);
    	i4.setId("I112");
    	i4.setAlive(true);
    	i4.setAge(55);
    	individualMap.put("I111", i3);
    	individualMap.put("I112", i4);
    	f2.setHusbandId("I111");
    	f2.setWifeId("I112");
    	list.add(f2);
    	Assert.assertEquals(false, US48and49.US49(list, individualMap));
    }
    
    public void test4() throws ParseException{
    	Family f1 = new Family();
    	Individual i1 = new Individual();
    	Individual i2 = new Individual();
    	Map<String, Individual> individualMap = new HashMap<String, Individual>();
    	f1.setID("f002");
    	i1.setId("I107");
    	i1.setAlive(false);
    	i1.setAge(44);
    	i2.setId("I108");
    	i2.setAlive(true);
    	i2.setAge(44);
    	individualMap.put("I107", i1);
    	individualMap.put("I108", i2);
    	f1.setHusbandId("I107");
    	f1.setWifeId("I108");
    	List<Family> list = new ArrayList<>();
    	list.add(f1);
    	Assert.assertEquals(true, US48and49.US49(list, individualMap));
    }
    
    public void test5() throws ParseException{
    	Family f1 = new Family();
    	Individual i1 = new Individual();
    	Individual i2 = new Individual();
    	Map<String, Individual> individualMap = new HashMap<String, Individual>();
    	f1.setID("f003");
    	i1.setId("I109");
    	i1.setAlive(true);
    	i1.setAge(55);
    	i2.setId("I110");
    	i2.setAlive(true);
    	i2.setAge(44);
    	individualMap.put("I109", i1);
    	individualMap.put("I110", i2);
    	f1.setHusbandId("I109");
    	f1.setWifeId("I110");
    	List<Family> list = new ArrayList<>();
    	list.add(f1);
    	Assert.assertTrue(US48and49.US49(list, individualMap));
    }
    
}
