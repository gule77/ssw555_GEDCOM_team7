

//import org.junit.Test;
import org.junit.Assert;
import junit.framework.TestCase;

public class GedcomParseTest1 extends TestCase {
	private GedcomParse f12CHF;
    protected void setUp() {
        f12CHF= new GedcomParse("team7.ged");
        //System.out.println(f12CHF);
    }
    public void test1() {
        Assert.assertTrue(f12CHF.isDateValid("2010-05-3", "2010-05-2"));
      }
    public void test2() {
        Assert.assertEquals(f12CHF.isDateValid("2010-05-2", "1999-12-4"), f12CHF.isDateValid("2010-05-2", "1989-12-4"));
      }
    public void test3() {
        Assert.assertEquals(f12CHF.isDateValid("1010-05-2", "1979-12-4"), f12CHF.isDateValid("1010-05-2", "1969-12-4"));
      }
    public void test4() {
        Assert.assertTrue(f12CHF.isDateValid("2010-05-2", "1979-12-4"));
      }
    public void test5() {
        Assert.assertTrue(!f12CHF.isDateValid("1010-05-2", "1979-12-4"));
      }
}
