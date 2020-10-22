import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

import org.junit.Assert;
import junit.framework.TestCase;
public class US17and21Test extends TestCase{

    public void test1(){
        Family f1 = new Family();
        Individual i1 = new Individual();
        Individual i2 = new Individual();
        Map<String, Individual> individualMap = new HashMap<String, Individual>();
        Map<String, Family> familyMap = new HashMap<String, Family>();
        f1.setID("f001");
        i1.setId("I101");
        i1.setSpouse("f001");
        i1.setChild("f001");
        i1.setBirthday("1908-01-01");
        i2.setId("I102");
        i2.setSpouse("f001");
        i2.setBirthday("1918-01-30");
        individualMap.put("I101", i1);
        individualMap.put("I102", i2);
        f1.setHusbandId("I101");
        f1.setWifeId("I102");
        f1.setChildren(new ArrayList<>());
        f1.getChildren().add(i1);
        //System.out.println(US17and21.US17(f1, individualMap));
        Assert.assertTrue(!US17and21.US17(f1, individualMap, familyMap));
    }

    public void test2() {
        Family f2 = new Family();
        Individual i3 = new Individual();
        Individual i4 = new Individual();
        Map<String, Individual> individualMap = new HashMap<String, Individual>();
        Map<String, Family> familyMap = new HashMap<String, Family>();
        f2.setID("f002");
        i3.setId("I103");
        i3.setSpouse("f002");
        i3.setChild("f002");
        i4.setId("I104");
        i4.setSpouse("f002");
        individualMap.put("I103", i3);
        individualMap.put("I104", i4);
        f2.setHusbandId("I103");
        f2.setWifeId("I104");
        f2.setChildren(new ArrayList<>());
        f2.getChildren().add(i3);
        Assert.assertEquals(false, US17and21.US17(f2, individualMap, familyMap));
    }

    public void test3() {
        Family f3 = new Family();
        Individual i5 = new Individual();
        Individual i6 = new Individual();
        Map<String, Individual> individualMap = new HashMap<String, Individual>();
        f3.setID("f003");
        i5.setId("I105");
        i5.setGender("M");
        i6.setId("I106");
        i6.setGender("M");
        individualMap.put("I105", i5);
        individualMap.put("I106", i6);
        f3.setHusbandId("I105");
        f3.setWifeId("I106");
        Assert.assertTrue(!US17and21.US21(f3, individualMap));
    }

    public void test4() {
        Family f4 = new Family();
        Individual i7 = new Individual();
        Individual i8 = new Individual();
        Map<String, Individual> individualMap = new HashMap<String, Individual>();
        f4.setID("f004");
        i7.setId("I107");
        i7.setGender("F");
        i8.setId("I108");
        i8.setGender("M");
        individualMap.put("I107", i7);
        individualMap.put("I108", i8);
        f4.setHusbandId("I107");
        f4.setWifeId("I108");
        Assert.assertTrue(!US17and21.US21(f4, individualMap));
    }

    //written by tester
    public void test5() {
        Family f3 = new Family();
        Individual i5 = new Individual();
        Individual i6 = new Individual();
        Map<String, Individual> individualMap = new HashMap<String, Individual>();
        f3.setID("f003");
        i5.setId("I105");
        i5.setGender("M");
        i6.setId("I106");
        i6.setGender("F");
        individualMap.put("I105", i5);
        individualMap.put("I106", i6);
        f3.setHusbandId("I105");
        f3.setWifeId("I106");
        Assert.assertTrue(US17and21.US21(f3, individualMap));
    }

    //written by tester
    public void test6(){
        Family f1 = new Family();
        Family f2 = new Family();
        Individual i1 = new Individual(); // husband
        Individual i2 = new Individual(); // ex-wife
        Individual i3 = new Individual(); // daughter of i1 and i2, at the same time is the wife of i

        Map<String, Individual> individualMap = new HashMap<String, Individual>();
        Map<String, Family> familyMap = new HashMap<String, Family>();
        f1.setID("f001");
        f2.setID("f002");

        i1.setId("I101");
        i2.setId("I102");
        i3.setId("I103");

        individualMap.put("I101", i1);
        individualMap.put("I102", i2);
        individualMap.put("I103", i3);

        f1.setHusbandId("I101");
        f1.setWifeId("I102");
        f1.setChildren(new ArrayList<>());
        f1.getChildren().add(i3);

        f2.setHusbandId("I101");
        f2.setWifeId("I103");

        Assert.assertFalse(US17and21.US17(f2, individualMap, familyMap));
    }
}
