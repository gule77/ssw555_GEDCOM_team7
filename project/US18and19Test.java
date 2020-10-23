import java.text.ParseException;
import java.util.*;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class US18and19Test {
    Individual gen11 = new Individual();
    Individual gen12 = new Individual();
    Individual gen21 = new Individual();
    Individual gen22 = new Individual();
    Individual gen21_2 = new Individual();
    Individual gen22_2 = new Individual();
    Individual gen31 = new Individual();
    Individual gen32 = new Individual();
    Individual gen33 = new Individual();
    Individual gen33_2 = new Individual();
    Family f11_12 = new Family();
    Family f21_21 = new Family();
    Family f22_22 = new Family();
    Family f31_32 = new Family();
    Family f33_33 = new Family();
    List<Family> familyList = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //initial individual id and member
        gen11.setId("gen11");
        gen12.setId("gen12");
        gen21.setId("gen21");
        gen22.setId("gen22");
        gen21_2.setId("gen21_2");
        gen22_2.setId("gen22_2");
        gen31.setId("gen31");
        gen32.setId("gen32");
        gen33.setId("gen33");
        gen33_2.setId("gen33_2");
        f11_12.setID("f11_12");
        f21_21.setID("f21_21");
        f22_22.setID("f22_22");
        f31_32.setID("f31_32");
        f33_33.setID("f33_33");
        f11_12.setHusbandId("gen11");
        f11_12.setWifeId("gen12");
        f21_21.setHusbandId("gen21");
        f21_21.setWifeId("gen21_2");
        f22_22.setHusbandId("gen22");
        f22_22.setWifeId("gen22_2");
        f31_32.setHusbandId("gen31");
        f31_32.setWifeId("gen31");
        f33_33.setHusbandId("gen33");
        f33_33.setWifeId("gen33_2");
        List<Individual> f11_12Children = new ArrayList<>();
        f11_12Children.add(gen21);
        f11_12Children.add(gen22);
        f11_12.setChildren(f11_12Children);
        List<Individual> f21_21Children = new ArrayList<>();
        f21_21Children.add(gen31);
        f21_21.setChildren(f21_21Children);
        List<Individual> f22_22Children = new ArrayList<>();
        f22_22Children.add(gen32);
        f22_22Children.add(gen33);
        f22_22.setChildren(f22_22Children);
        familyList.add(f11_12);
        familyList.add(f21_21);
        familyList.add(f22_22);
        familyList.add(f31_32);
        familyList.add(f33_33);
    }

    @org.junit.jupiter.api.Test
    void US18() throws ParseException {
        System.out.println("Test Story US18: ");
        assertTrue(US18and19.US18(familyList));
    }

    @org.junit.jupiter.api.Test
    void US19() throws ParseException {
        System.out.println("Test story US19: ");
        assertFalse(US18and19.US19(familyList));
    }
}
