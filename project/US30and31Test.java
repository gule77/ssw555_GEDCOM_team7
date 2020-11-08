//package assignment04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

// Test by Bin Sun on 11/05/2020

class US30and31Test {
// Test US30
	@org.junit.jupiter.api.Test
	public void testUS30(){
        US30and31 sprint3 = new US30and31();
        Individual husband1 = new Individual();
        Individual husband2 = new Individual();
        Individual wife1 = new Individual();
        Individual wife2 = new Individual();
        Individual single = new Individual();

        single.setId("p00");
        single.setLastName("Sun");
        single.setFirstName("Bin");
        single.setAlive(true);
        husband1.setId("p01");
        husband2.setId("p02");
        husband1.setAlive(true);
        husband2.setAlive(true);
        wife1.setId("p04");
        wife2.setId("p05");

        husband1.setFirstName("John");
        husband1.setLastName("Smith");
        husband1.setFams("p04");
        wife1.setFirstName("Isabelle");
        wife1.setLastName("Smith");
        wife1.setFams("p01");
        wife1.setAlive(true);

        husband2.setFirstName("John");
        husband2.setLastName("Smith");
        husband2.setFams("p05");
        wife2.setFirstName("Isabelle");
        wife2.setLastName("Smith");
        wife2.setFams("p02");
        wife2.setAlive(true);

        ArrayList<Individual> p = new ArrayList<>();
        p.add(husband1);
        p.add(husband2);
        p.add(wife1);
        p.add(wife2);
        p.add(single);
        assertEquals(4, sprint3.US30(p).size());

    }
// Test US31
	@org.junit.jupiter.api.Test
	public void testUS31(){
		US30and31 sprint3 = new US30and31();
		Individual husband1 = new Individual();
		Individual husband2 = new Individual();
		Individual wife1 = new Individual();
		Individual wife2 = new Individual();
		Individual single = new Individual();
		Individual single2 = new Individual();
		Individual displayed = new Individual();

        single.setId("p00");
        single.setLastName("Sun");
        single.setFirstName("Bin");
        single.setBirthday("2000-01-30");
        single.setAge(18);
        single2.setId("0001");
        single2.setAlive(false);
        displayed.setId("p007");
        displayed.setBirthday("1950-01-01");
        displayed.setAge(70);

        husband1.setId("p01");
        husband2.setId("p02");
        wife1.setId("p04");
        wife2.setId("p05");

        husband1.setFirstName("John");
        husband1.setLastName("Smith");
        wife1.setFirstName("Isabelle");
        wife1.setLastName("Smith");
        husband1.setFams("p04");
        wife1.setFams("p01");

        ArrayList<Individual> p = new ArrayList<>();
        p.add(husband1);
        p.add(husband2);
        p.add(wife1);
        p.add(wife2);
        p.add(single);
        p.add(single2);
        p.add(displayed);
        assertEquals(1, sprint3.US31(p).size());
    }
}
