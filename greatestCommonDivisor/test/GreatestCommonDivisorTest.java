import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class GreatestCommonDivisorTest extends TestCase {
    GreatestCommonDivisor gcd = new GreatestCommonDivisor();

    @Test
    public void testFindGreatestCommonDivisorByEuclide() {
        Assert.assertEquals(6, gcd.findGreatestCommonDivisorByEuclide(54, 24));
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