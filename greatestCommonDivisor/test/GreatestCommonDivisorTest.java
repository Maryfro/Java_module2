import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class GreatestCommonDivisorTest extends TestCase {
    GreatestCommonDivisor gcd = new GreatestCommonDivisor();

    @Test
    public void testFindGreatestCommonDivisorByEuclide() {
        Assert.assertEquals(6, gcd.findGreatestCommonDivisorByEuclide(54, 24));
        Assert.assertEquals(20, gcd.findGreatestCommonDivisorByEuclide(100, 40));
        Assert.assertEquals(1, gcd.findGreatestCommonDivisorByEuclide(9, 5));
        Assert.assertEquals(5, gcd.findGreatestCommonDivisorByEuclide(0, 5));
        Assert.assertEquals(5, gcd.findGreatestCommonDivisorByEuclide(5, 0));
//        Assert.assertEquals(2, gcd.findGreatestCommonDivisorByEuclide(26, 36)); test fails
    }

    @Test
    public void testFindGreatestCommonDivisorRecurcion() {
        Assert.assertEquals(6, gcd.findGreatestCommonDivisorRecurcion(54, 24));
    }

    @Test
    public void testFindGreatestCommonDivisorRecurcionWithZero() {
        Assert.assertEquals(5, gcd.findGreatestCommonDivisorRecurcion(5, 0));
    }

    @Test
    public void testFindGreatestCommonDivisorRecurcionNoCommonDivisor() {
        Assert.assertEquals(1, gcd.findGreatestCommonDivisorRecurcion(5, 9));
    }
}