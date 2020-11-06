//import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import junit.framework.TestCase;

public class US53and54Test extends TestCase {
	//test1
	Individual I1 = new Individual();
	Individual I2 = new Individual();
	Individual I3 = new Individual();
	Individual I4 = new Individual();
	List<Individual> individualList = new ArrayList<Individual>();
    protected void setUp() {
        new US53and54();
        //test 1 setUp
		String id1 = "I1";
		String id2 = "I2";
		String id3 = "I3";
		String id4 = "I4";
		String birthday1 = "2020-09-22";
		String birthday2 = "2020-10-01";
		String birthday3 = "2000-09-22";
		String birthday4 = "2018-10-01";
		String deathdate1 = "2020-10-01";
		I1.setAlive(true);
		I1.setDeath("NA");
		I1.setId(id1);
		I1.setBirthday(birthday1);
		
		I2.setAlive(false);
		I2.setDeath(deathdate1);
		I2.setId(id2);
		I2.setBirthday(birthday2);
		
		I3.setAlive(false);
		I3.setDeath(deathdate1);
		I3.setId(id3);
		I3.setBirthday(birthday3);
		
		I4.setAlive(false);
		I4.setDeath(deathdate1);
		I4.setId(id4);
		I4.setBirthday(birthday4);
		individualList.add(I1);
		individualList.add(I2);	
		individualList.add(I3);
		individualList.add(I4);
    }
    public void test1() {
        Assert.assertTrue(US53and54.US53(individualList));
      }
    
    public void test2() {
        Assert.assertTrue(US53and54.US54(individualList));
      }
}
