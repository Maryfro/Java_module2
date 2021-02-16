import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindOnesTest {
    FindOnes f1 = new FindOnes();

    @Test
    public void test_findOnes_exp0(){
        assertEquals(0, f1.findOnes(2, 9));
    }

    @Test
    public void test_findOnes_exp1(){
        assertEquals(1, f1.findOnes(31, 40));
    }

    @Test
    public void test_findOnes_exp2(){
        assertEquals(2, f1.findOnes(1, 10));
    }

    @Test
    public void test_findOnes_exp10(){
        assertEquals(10, f1.findOnes(10, 20));
    }

    @Test
    public void test_findOnes_exp31(){
        assertEquals(31, f1.findOnes(0, 111));
    }

}