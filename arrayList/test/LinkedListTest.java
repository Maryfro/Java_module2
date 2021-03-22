import org.junit.Assert;
import org.junit.Test;
import telran.CustomList;
import telran.LinkedList;


public class LinkedListTest {
    CustomList<Integer> list = new LinkedList();
    CustomList<String> list2 = new LinkedList();

    @Test
    public void testSizeZero() {
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testSizeNotZero() {
     /*   List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 2, 3);*/
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Assert.assertEquals(10, list.size());
    }


    @Test
    public void testAddValue() {
        list2.add("Hello");
        // LinkedList.Node node = ((LinkedList<String>) list2).getFirst();
        //String str = (String) node.getValue();
        Assert.assertEquals("Hello", list2.get(0));
    }

    @Test
    public void testRemoveValue_TrueCase() {
        list2.add("Hello");
        list2.add("world");
        Assert.assertTrue(list2.remove("Hello"));
    }

    @Test
    public void testRemoveValue_FalseCase() {
        list2.add("Hello");
        list2.add("world");
        Assert.assertFalse(list2.remove("java"));
    }

    @Test
    public void testRemoveValueById() {
        list2.add("Hello");
        list2.add("world");
        list2.add("java");
        Assert.assertEquals("Hello", list2.removeById(0));
    }

    @Test
    public void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals((Integer) 3, list.get(2));
    }
}
