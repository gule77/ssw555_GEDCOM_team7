package src;
import java.text.ParseException;
import java.util.*;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class US20and26Test {
    Individual gen11 = new Individual();
    Individual gen12 = new Individual();
    Individual gen21 = new Individual();
    Individual gen22 = new Individual();
    Individual gen21_2 = new Individual();
    Individual gen31 = new Individual();
    HashMap<String, Individual> individualList = new HashMap<>();

    Family f11_12 = new Family();
    Family f21_21 = new Family();
    Family f22_31 = new Family();

    List<Family> familyList = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //initial individual id and member
        gen11.setId("gen11");
        gen12.setId("gen12");
        gen21.setId("gen21");
        gen22.setId("gen22");
        gen21_2.setId("gen21_2");
        gen31.setId("gen31");
        gen11.setName("husband111");
        gen11.setChild("NA");
        gen11.setSpouse("f11_12");
        gen12.setName("wife12");
        gen12.setChild("NA");
        gen12.setSpouse("f11_12");
        gen21.setName("husband21");
        gen21.setChild("f21_21");
        gen21.setSpouse("f31");
        gen21_2.setName("wife21");
        gen21_2.setChild("f21_21");
        gen21_2.setName("f31");

        individualList.put("gen11", gen11);
        individualList.put("gen12", gen12);
        individualList.put("gen21", gen21);
        individualList.put("gen22", gen22);
        individualList.put("gen21_2", gen21_2);
        individualList.put("gen31", gen31);

        f11_12.setID("f11_12");
        f21_21.setID("f21_21");
        f22_31.setID("f22_31");
        f11_12.setHusbandId("gen11");
        f11_12.setWifeId("gen12");
        f21_21.setHusbandId("gen21");
        f21_21.setWifeId("gen21_2");
        f22_31.setHusbandId("gen22");
        f22_31.setWifeId("gen31");
        List<Individual> f11_12Children = new ArrayList<>();
        f11_12Children.add(gen21);
        f11_12Children.add(gen22);
        f11_12.setChildren(f11_12Children);
        f11_12.setHusbandName("husband11");
        f11_12.setWifeName("wife12");

        List<Individual> f21_21Children = new ArrayList<>();
        f21_21Children.add(gen31);
        f21_21.setChildren(f21_21Children);
        f21_21.setHusbandName("husband21");
        f21_21.setWifeName("wife21_2");
        familyList.add(f11_12);
        familyList.add(f21_21);
        familyList.add(f22_31);

    }

    @org.junit.jupiter.api.Test
    void US20() {
        System.out.println("Test Story US20: ");
        assertFalse(US20and26.US20(familyList));
    }

    @org.junit.jupiter.api.Test
    void US26() {
        System.out.println("Test Story US26: ");
        assertFalse(US20and26.US26(familyList, individualList));
    }
}
