package Transaction;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    AccountService acc = new AccountService();

    @Test
    public void test_countSumOfTransactions() {
        Map<String, Long> exp = new HashMap<>();
        exp.put("001", 200L);
        exp.put("002", 120L);
        assertEquals(exp, acc.countSumOfTransactions(Arrays.asList(new Transaction(200, "001"),
                new Transaction(33, "002"), new Transaction(87, "002"))));
    }

}