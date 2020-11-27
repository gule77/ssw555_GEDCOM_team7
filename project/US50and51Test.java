package assignment04;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.text.ParseException;
import java.util.*;
import org.junit.Assert;
import junit.framework.TestCase;

import org.junit.jupiter.api.Test;

class US50and51Test {

	@org.junit.jupiter.api.Test
	void test50() {
		US50and51 sprint4 = new US50and51();
		Family f1 = new Family();
		Individual p1 = new Individual();
		Individual p2 = new Individual();
		p1.setId("P01");
		p1.setBirthday("1975-01-01");

		p2.setId("P02");
		p2.setBirthday("1975-02-01");
		ArrayList<Individual> ppl = new ArrayList<>();
		ppl.add(p1);
		ppl.add(p2);

		f1.setHusbandId(p1.getId());
		f1.setHusbandName(p1.getName());
		f1.setWifeId(p2.getId());
		f1.setWifeName(p2.getName());
		f1.setID("F1");
		f1.setMarried("2001-01-01");
		f1.setDivorced("2010-02-02");
		ArrayList<Family> fam = new ArrayList<>();
		fam.add(f1);

		sprint4.US50(fam);

	}

// test for US51 by Bin Sun
	@org.junit.jupiter.api.Test
	void test1() throws ParseException {
		US50and51 sprint4 = new US50and51();
		Family f1 = new Family();
		Individual hus1 = new Individual();
		Individual wif1 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f001");
		hus1.setId("I101");
		hus1.setBirthday("1980-01-01");
		wif1.setId("I102");
		wif1.setBirthday("1979-01-30");
		individualMap.put("I101", hus1);
		individualMap.put("I102", wif1);
		f1.setHusbandId("I101");
		f1.setWifeId("I102");
		f1.setMarried("2000-11-11");
		System.out.println("============");
		sprint4.US51(f1, individualMap);
		
	}
	@org.junit.jupiter.api.Test
	void test2() throws ParseException { 
		US50and51 sprint4 = new US50and51();
		Family f1 = new Family();
		Individual hus2 = new Individual();
		Individual wif2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f005");
		hus2.setId("I103");
		hus2.setBirthday("1998-01-01");
		wif2.setId("I104");
		wif2.setBirthday("1988-01-30");
		individualMap.put("I103", hus2);
		individualMap.put("I104", wif2);
		f1.setHusbandId("I103");
		f1.setWifeId("I104");
		f1.setMarried("2020-11-11");
		System.out.println("======{======");
		sprint4.US51(f1, individualMap);

	}
	
	@org.junit.jupiter.api.Test
	void test3() throws ParseException { 
		US50and51 sprint4 = new US50and51();
		Family f1 = new Family();
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		Map<String, Individual> individualMap = new HashMap<String, Individual>();
		f1.setID("f006");
		i1.setId("I103");
		i1.setBirthday("1938-01-01");
		i2.setId("I104");
		i2.setBirthday("1928-11-12");
		individualMap.put("I103", i1);
		individualMap.put("I104", i2);
		f1.setHusbandId("I103");
		f1.setWifeId("I104");
		f1.setMarried("1948-11-11");
		System.out.println("======{======");
		sprint4.US51(f1, individualMap);
	}
}