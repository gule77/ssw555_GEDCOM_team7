package project;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class US55and56Test extends HelperFuctions {
    @org.junit.jupiter.api.Test
    void US55() {
        Individual i0 = new Individual();
        i0.setAlive(false);
        Individual i1 = new Individual();
        i1.setAlive(true);
        Individual i2 = new Individual();
        i2.setAlive(true);
        Individual i3 = new Individual();
        i3.setAlive(true);
        Individual i4 = new Individual();
        i4.setAlive(false);
        Individual i5 = new Individual();
        i5.setAlive(false);

        Family f0 = new Family();
        f0.setID("F0");
        f0.setChildren(new ArrayList<>());
        f0.getChildren().add(i0);
        f0.getChildren().add(i1);

        Family f1 = new Family();
        f1.setID("F1");
        f1.setChildren(new ArrayList<>());
        f1.getChildren().add(i2);
        f1.getChildren().add(i3);

        Family f2 = new Family();
        f2.setID("F2");
        f2.setChildren(new ArrayList<>());
        f2.getChildren().add(i4);
        f2.getChildren().add(i5);

        List<Family> familyList1 = new ArrayList<>();
        familyList1.add(f0);
        familyList1.add(f1);
        familyList1.add(f2);

        List<Family> familyList2 = new ArrayList<>();
        familyList2.add(f1);

        assertEquals(US55and56.US55(familyList2), "DATA: FAMILY: US55: No family has lost a child");
        assertEquals(US55and56.US55(familyList1), "DATA: FAMILY: US55: {0: F0, 0: F2} have lost children");
    }

    @org.junit.jupiter.api.Test
    void US56() {
        Family f0 = new Family();
        f0.setID("F0");
        f0.setMarried("2019-11-10");
        Family f1 = new Family();
        f1.setID("F1");
        f1.setMarried("2020-11-10");
        Family f2 = new Family();
        f2.setID("F2");
        f2.setMarried("2020-10-18");

        List<Family> familyList1 = new ArrayList<>();
        familyList1.add(f0);
        familyList1.add(f1);
        familyList1.add(f2);

        List<Family> familyList2 = new ArrayList<>();
        familyList2.add(f0);

        assertEquals(US55and56.US56(familyList1), "DATA: FAMILY: US56: {0: F1, 0: F2} married in the last 30 days");
        assertEquals(US55and56.US56(familyList2), "DATA: FAMILY: US56: No family married in the last 30 days");
    }
}
