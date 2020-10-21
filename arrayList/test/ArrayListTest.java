import org.junit.Assert;
import org.junit.Test;
import telran.ArrayList;

public class ArrayListTest {

    @Test
    public void testSizeZero() {
        ArrayList al = new ArrayList();
        Assert.assertEquals(0, al.size());
    }

    @Test
    public void testSizeNotZero() {
        int[] arr = {1, 2, 3, 5};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int a : arr) {
            nums.add(a);
        }
        Assert.assertEquals(4, nums.size());
    }

    @Test
    public void testChangeOfSize() {
        int[] arr = {1, 2, 3, 5, 10, 4, 6};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int a : arr) {
            nums.add(a);
        }
        Assert.assertEquals(7, nums.size());
    }

    @Test
    public void testCorrectOrder() {
        int[] arr = {1, 2, 3, 4};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int a : arr) {
            nums.add(a);
        }
        for (int i = 0; i < arr.length; i++) {
            Assert.assertEquals(arr[i], nums.get(i).intValue());
        }
    }

    @Test
    public void testRemoveByIndex() {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int a : arr) {
            nums.add(a);
        }
        int actualDeletedNumber = nums.removeById(2); //3
        int[] expected = {1, 2, 4, 5};
        Assert.assertEquals(3, actualDeletedNumber);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], (int) nums.get(i));
        }
        Assert.assertEquals(4, nums.size());
    }

    @Test
    public void testRemoveByIndexStringArray() {
        String[] arr = {"a", "b", "c", "d", "e"};
        ArrayList<String> input = new ArrayList<String>();
        for (String s : arr) {
            input.add(s);
        }
        String actualDeletedString = input.removeById(2); //3
        String[] expected = {"a", "b", "d", "e"};
        Assert.assertEquals("c", actualDeletedString);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], input.get(i));
        }
        Assert.assertEquals(4, input.size());
    }

    @Test
    public void testRemoveByElementString() {
        String[] arr = {"a", "b", "c", "d"};
        ArrayList<String> words = new ArrayList<String>();
        for (String s : arr) {
            words.add(s);
        }
        boolean isRemoved = words.remove("a");
        boolean isNotRemoved = words.remove("e");
        Assert.assertTrue(isRemoved);
        Assert.assertFalse(isNotRemoved);

        String[] expected = {"b", "c", "d"};
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], words.get(i));
        }
        Assert.assertEquals(3, words.size());
    }

    @Test
    public void testIndexOf(){
        String[] arr = {"a", "b", "c", "d"};
        ArrayList<String> words = new ArrayList<String>();
        for (String s : arr) {
            words.add(s);
        }
        Assert.assertEquals(3, words.indexOf("d"));
    }
}

