import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(239, -5, 366);
        double average = numbers.stream()
                .collect(Collectors.averagingInt(num -> num));

        Optional<Integer> max = numbers.stream()
                .collect(Collectors.maxBy(Integer::compare));

        List<Account> accounts = Arrays.asList(new Account
                        ("1", 1000, AccountState.ACTIVE),
                new Account("2", 1, AccountState.BLOCKED),
                new Account("3", 10, AccountState.REMOVED),
                new Account("4", 100, AccountState.ACTIVE));
        Map<AccountState, List<Account>> accByState = accounts.stream()
                .collect(Collectors.groupingBy(acc -> acc.state));

        Map<AccountState, Double> averageBalanceByState = accounts.stream()
                .collect(Collectors.groupingBy(acc -> acc.state,
                        Collectors.averagingLong(acc -> acc.balance)));
        System.out.println(accByState);
        System.out.println(averageBalanceByState);
    }


    static class Account {
        String uuid;
        long balance;
        AccountState state;

        public Account(String uuid, long balance, AccountState state) {
            this.uuid = uuid;
            this.balance = balance;
            this.state = state;
        }
    }

}
