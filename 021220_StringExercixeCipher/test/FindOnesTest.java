import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindOnesTest {
    FindOnes f1 = new FindOnes();
    List<Integer> list;

    @Test
    public void test_findOnes_exp0(){
      list = FindOnes.createList(2, 9);
        assertEquals(0, f1.findOnes(list));
    }

    @Test
    public void test_findOnes_exp1(){
       list = FindOnes.createList(31, 40);
        assertEquals(1, f1.findOnes(list));
    }

    @Test
    public void test_findOnes_exp2(){
        list = FindOnes.createList(1, 10);
        assertEquals(2, f1.findOnes(list));
    }

    @Test
    public void test_findOnes_exp10(){
        list = FindOnes.createList(10, 20);
        assertEquals(10, f1.findOnes(list));
    }

    @Test
    public void test_findOnes_exp31(){
        list = FindOnes.createList(0, 111);
        assertEquals(31, f1.findOnes(list));
    }

}