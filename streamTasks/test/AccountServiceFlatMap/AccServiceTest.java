package AccountServiceFlatMap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AccServiceTest {
    AccService accService = new AccService();
    Transaction trans1 = new Transaction("uu10", State.CANCELLED, 10, new Date(System.currentTimeMillis()));
    Transaction trans2 = new Transaction("uu14", State.PROCESSING, (long) 99.99, new Date(System.currentTimeMillis()));
    Transaction trans3 = new Transaction("uu12", State.FINISHED, 100_000, new Date(System.currentTimeMillis()));
    Transaction trans4 = new Transaction("uu11", State.CANCELLED, 2, new Date(System.currentTimeMillis()));
    Account acc1 = new Account("001", 200, new ArrayList<>(Arrays.asList(trans1, trans2, trans3, trans4)));
    Account acc2 = new Account("002", 999, new ArrayList<>(Arrays.asList(trans1, trans2, trans3, trans4)));
    Account acc3 = new Account("003", -500, new ArrayList<>(Arrays.asList(trans1, trans2, trans3, trans4)));

    @Test
    public void test_countSumOfCancelledTransactions_sumOfAcc1AndAcc3_trans1AndTrans4() {
        assertEquals(24, accService.countSumOfCancelledTransactions(new ArrayList<>(Arrays.asList(acc1, acc2, acc3))));
    }

    @Test
    public void test_countSumOfCancelledTransactions_sumOfAcc1AndAcc3_exp0() {
        trans1.setSum(0);
        trans4.setSum(0);
        assertEquals(0, accService.countSumOfCancelledTransactions(new ArrayList<>(Arrays.asList(acc1, acc2, acc3))));
    }

    @Test
    public void test_countSumOfCancelledTransactions_negativeBalance_exp0() {
        acc1.setBalance(-300);
        acc2.setBalance(-40);
        assertEquals(0, accService.countSumOfCancelledTransactions(new ArrayList<>(Arrays.asList(acc1, acc2, acc3))));
    }

}