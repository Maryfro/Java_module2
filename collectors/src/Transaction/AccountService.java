package Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountService {

    public Map<String, Long> countSumOfTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.toMap(transaction -> transaction.account, transaction -> transaction.sum,
                        Long::sum));
    }
}
