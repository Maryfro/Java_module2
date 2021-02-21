import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4SumOfOddNumsTest {
    Task4SumOfOddNums sum = new Task4SumOfOddNums();


    @Test
    public void testCountSumOfOddNums_rangeFrom2to5(){
        assertEquals(8, sum.countSumOfOddNums(2,5));
    }

    @Test
    public void testCountSumOfOddNums_rangeFrom7to7(){
        assertEquals(7, sum.countSumOfOddNums(7,7));
    }

    @Test
    public void testCountSumOfOddNums_rangeFrom2to2(){
        assertEquals(0, sum.countSumOfOddNums(2,2));
    }

    @Test
    public void testCountSumOfOddNums_rangeFrom145678to145680(){
        assertEquals(145679, sum.countSumOfOddNums(145678,145680));
    }

    @Test
    public void testCountSumOfOddNums_rangeFrom2to12(){
        assertEquals(35, sum.countSumOfOddNums(2,12));
    }

}