package assignment04;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
//Test by Bin Sun
class US04and05Test {

	@org.junit.jupiter.api.Test
	void test01() {
		US04and05 sprint1 = new US04and05();
		Family f1 = new Family();
		Individual p1 = new Individual();
		Individual p2 = new Individual();
		p1.setId("P01");
		p1.setDeath(true);
		p1.setBirthDate("1", "JAN", "1975");
		p1.setDeathDate("1", "JAN", "2000");

		p2.setId("P02");
		p2.setBirthDate("1", "FEB", "1975");
		p2.setDeath(false);
		ArrayList<Individual> ppl = new ArrayList<>();
		ppl.add(p1);
		ppl.add(p2);

		f1.setDad(p1);
		f1.setMom(p2);
		f1.setID("F1");
		f1.setMarriageDate("1", "JAN", "2001");
		ArrayList<Family> fam = new ArrayList<>();
		fam.add(f1);
		//Test 1 for US05
		assertEquals(false, sprint1.US05(ppl, fam));
		
		p1.setDeathDate("1", "JAN", "2002");		
		//Test 2 for US05
		assertEquals(true, sprint1.US05(ppl, fam));
		
		p1.setDeathDate("2", "FEB", "2000");
		//Test 3 for US05
		assertEquals(false, sprint1.US05(ppl, fam));
		
		p1.setDeathDate("3", "MAY", "1999");
		//Test 4 for US05
		assertEquals(false, sprint1.US05(ppl, fam));
		
		p1.setDeathDate("3", "JUNE", "2004");
		//Test 5 for US05
		assertEquals(true, sprint1.US05(ppl, fam));


	}

	@org.junit.jupiter.api.Test
	void test02() {
		US04and05 s1 = new US04and05();
		Family f1 = new Family();
		f1.setID("100");
		f1.setMarriageDate("1", "JAN", "2000");
		f1.setDivorceDate("2", "FEB", "1999");
		f1.setDivorced("y");
		ArrayList<Family> list = new ArrayList<>();
		list.add(f1);
		//Test1 for US04
		assertFalse(s1.US04(list));
		
		f1.setDivorceDate("3", "JUL", "2001");
		//Test2 for US04
		assertTrue(s1.US04(list));
		
		f1.setDivorceDate("4", "JUNE", "2004");
		//Test3 for US04
		assertTrue(s1.US04(list));
		
		f1.setDivorceDate("5", "MAY", "1998");
		//Test4 for US04
		assertFalse(s1.US04(list));

		f1.setDivorceDate("6", "JUL", "1995");
		//Test5 for US04
		assertFalse(s1.US04(list));

	}

}
