package AccountServiceFlatMap;

import java.util.*;

public class AccService {

    public long countSumOfCancelledTransactions(List<Account> accounts) {
        Optional<Long> sum = accounts.stream()
                .filter(x -> x.getBalance() > 0)
                .flatMap(account -> account
                        .getTransactions()
                        .stream()
                        .filter(transaction -> transaction
                                .getState()
                                .toString()
                                .equals("CANCELLED")))
                .map(Transaction::getSum).reduce(Long::sum);

        if (sum.isPresent())
            return sum.get();
        else return 0;
    }

}


//There is class transaction and account
/*Transaction
uuid:String
state: CANCELLED; FINISHED; PROCESSING enum State
sum: long
date: Date

Class Account
id:String
balance: long
transactions:List<Transaction>

Write a method which reads sum of all cancelled transactions
for all positive accounts
Class AccService
long count (List<Account> accounts)
use flatmap
list accounts ->to streams-> filter by positive accounts->
stream transactions(flatmap)->filter (cancelled)
*/


