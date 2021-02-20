import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AccFilter {
    List<Account> filter(List<Account> list, Predicate<Account> predicate) {
        List<Account> res = new ArrayList<>();
        list.forEach(account -> {
            if (predicate.test(account))
                res.add(account);
        });
        return res;
    }
}
