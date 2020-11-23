import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void reverseString(){
        Solution s = new Solution();
       String output = s.reverseString("Hello");
        Assert.assertEquals("olleH", output);
    }

    @Test
    public void reverseStringEmpty(){
        Solution s = new Solution();
        String output = s.reverseString("");
        Assert.assertEquals("", output);
    }

    @Test
    public void reverseStringLength(){
        Solution s = new Solution();
        String output = s.reverseString("Hello");
        Assert.assertEquals(5, output.length());
    }

    @Test
    public void squaredNumber(){
        Solution s = new Solution();
        int res = s.squaredNumber(2);
        Assert.assertEquals(4, res);
    }

}