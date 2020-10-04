//import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import junit.framework.TestCase;

public class US06and07Test extends TestCase {
	//test1
	Family f1 = new Family();
	Individual I1 = new Individual();
	Individual I2 = new Individual();
	List<Individual> individualList1 = new ArrayList<Individual>();
	List<Family> familyList1 = new ArrayList<Family>();
	Map<String, Individual> map1 = new HashMap<String, Individual>();;
	//test2
	Family f2 = new Family();
	Individual I12 = new Individual();
	Individual I22 = new Individual();
	List<Individual> individualList2 = new ArrayList<Individual>();
	List<Family> familyList2 = new ArrayList<Family>();
	Map<String, Individual> map2 = new HashMap<String, Individual>();;
    protected void setUp() {
        new US06and07();
        //test 1 setUp
		String id1 = "I1";
		String id2 = "I2";
		String fid1 = "F1";
		String divdate = "1112-01-1";
		String birthday1 = "1365-01-01";
		String birthday2 = "1965-01-01";
		I1.setAlive(true);
		I1.setId(id1);
		I1.setDeath("NA");
		I2.setAlive(true);
		I2.setId(id2);
		I2.setDeath("NA");
		I1.setBirthday(birthday1);
		I2.setBirthday(birthday2);
		individualList1.add(I1);
		individualList1.add(I2);
		map1.put(id1, I1);
		map1.put(id2, I2);
		f1.setID(fid1);
		f1.setDivorced(divdate);
		f1.setHusbandId(id1);
		f1.setWifeId(id2);
		familyList1.add(f1);
		//test 2 setUp
		String divdate2 = "2112-01-1";
		String deathdate2 = "2110-01-1";
		I12.setAlive(false);
		I12.setDeath(deathdate2);
		I12.setId(id1);
		I22.setAlive(false);
		I22.setDeath(deathdate2);
		I22.setId(id2);
		I12.setBirthday(birthday1);
		I22.setBirthday(birthday2);
		individualList2.add(I12);
		individualList2.add(I22);
		map2.put(id1, I12);
		map2.put(id2, I22);
		f2.setID(fid1);
		f2.setDivorced(divdate2);
		f2.setHusbandId(id1);
		f2.setWifeId(id2);
		familyList2.add(f2);		
    }
    //US06
    public void test1() {
        Assert.assertTrue(US06and07.US06(familyList1, map1));
      }
    public void test2() {
        Assert.assertEquals(US06and07.US06(familyList1, map1),true);
      }
    public void test3() {
        Assert.assertEquals(US06and07.US06(familyList2, map2),false);
      }
    public void test4() {
        Assert.assertNotEquals(US06and07.US06(familyList2, map2),true);
      }
    public void test5() {
        Assert.assertNotEquals(US06and07.US06(familyList2, map2),US06and07.US06(familyList1, map1));
      }
    //US07
    public void test6() {
        Assert.assertFalse(US06and07.US07(individualList1));
      }
    public void test7() {
        Assert.assertNotEquals(US06and07.US07(individualList1),true);
      }
    public void test8() {
        Assert.assertFalse(US06and07.US07(individualList2));
      }
    public void test9() {
        Assert.assertNotEquals(US06and07.US07(individualList2),true);
      }
    public void test10() {
        Assert.assertEquals(US06and07.US07(individualList2),US06and07.US07(individualList1));
      }
}
