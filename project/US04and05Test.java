//package assignment04;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
// Test by Bin Sun on 10/03/2020
class US04and05Test {

	@org.junit.jupiter.api.Test
	void test01() {
		US04and05 sprint1 = new US04and05();
		Family f1 = new Family();
		Individual p1 = new Individual();
		Individual p2 = new Individual();
		p1.setId("P01");
		p1.setAlive(true);
		p1.setBirthday("1975-01-01");
		p1.setDeath("2000-01-01");

		p2.setId("P02");
		p2.setBirthday("1975-02-01");
		p2.setAlive(false);
		ArrayList<Individual> ppl = new ArrayList<>();
		ppl.add(p1);
		ppl.add(p2);

		f1.setHusbandId(p1.getId());
		f1.setHusbandName(p1.getName());
		f1.setWifeId(p2.getId());
		f1.setWifeName(p2.getName());
		f1.setID("F1");
		f1.setMarried("2001-01-01");
		ArrayList<Family> fam = new ArrayList<>();
		fam.add(f1);
		//Test 1 for US05
		assertEquals(false, sprint1.US05(ppl, fam));
		
		p1.setDeath("2002-01-01");		
		//Test 2 for US05
		assertEquals(true, sprint1.US05(ppl, fam));
		
		p1.setDeath("2000-02-02");
		//Test 3 for US05
		assertEquals(false, sprint1.US05(ppl, fam));
		
		p1.setDeath("1999-05-03");
		//Test 4 for US05
		assertEquals(false, sprint1.US05(ppl, fam));
		
		p1.setDeath("2004-06-03");
		//Test 5 for US05
		assertEquals(true, sprint1.US05(ppl, fam));


	}

	@org.junit.jupiter.api.Test
	void test02() {
		US04and05 s1 = new US04and05();
		Family f1 = new Family();
		f1.setID("100");
		f1.setMarried("2000-01-01");
		f1.setDivorced("1999-02-01");
		ArrayList<Family> list = new ArrayList<>();
		list.add(f1);
		//Test1 for US04
		assertFalse(s1.US04(list));
		
		f1.setDivorced("2001-07-03");
		//Test2 for US04
		assertTrue(s1.US04(list));
		
		f1.setDivorced("2004-06-04");
		//Test3 for US04
		assertTrue(s1.US04(list));
		
		f1.setDivorced("1998-05-05");
		//Test4 for US04
		assertFalse(s1.US04(list));

		f1.setDivorced("1995-07-06");
		//Test5 for US04
		assertFalse(s1.US04(list));

	}

}
