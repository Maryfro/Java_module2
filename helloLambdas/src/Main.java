import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Function<List<String>, List<String>> lambda = (List<String> list) -> new ArrayList<>(new HashSet<>(list));

        //  System.out.println(lambda.apply(new ArrayList<>(Arrays.asList("hello", "world", "cat", "hello", "cat"))));

        final int a = 2, b = 3, c = 4;
        Function<Integer, Integer> f = (x) -> a * x * x + b * x + c;

        //   System.out.println(f.apply(1));

        Account acc1 = new Account("123", 500, true);
        Account acc2 = new Account("124", 500000, false);
        Account acc3 = new Account("125", 500, false);
        Account acc4 = new Account("126", -23, true);
        List<Account> accountList = new ArrayList<>(Arrays.asList(acc1, acc2, acc3, acc4));
        Predicate<Account> predicate1 = (account) -> account.balance > 0;
        System.out.println(predicate1);

        Predicate<Account> predicate2 = (account) -> account.balance > 100000 && !account.isLocked;
        AccFilter accFilter = new AccFilter();
        System.out.println(accFilter.filter(accountList, predicate1));
        System.out.println(accFilter.filter(accountList, predicate2));
        System.out.println("-----------------------------------");
        TernaryIntPredicate ternaryIntPredicate = (x, y, z) -> !x.equals(y) && !y.equals(z) && !z.equals(x);
        System.out.println(ternaryIntPredicate.test(1, 2, 1));
        System.out.println(ternaryIntPredicate.test(1, 2, 3));
        System.out.println("-----------------------------------");
        Function<Double, Double> f1 = x -> x * 2;
        Function<Double, Double> g = x -> x + 3;
        Function<Double, Double> h = f1.compose(g); //h = x -> (x + 3) * 2;
        System.out.println("-----------------------------------");

        PredicateTask4 predicateTask4 = new PredicateTask4();
        List<Predicate> listOfPredicates = new ArrayList<>();
        Predicate<Integer> predicate1Task4 = (x) -> x > 10;
        Predicate<Integer> predicate2Task4 = (x) -> x % 2 == 0;
        Collections.addAll(listOfPredicates, predicate1Task4, predicate2Task4);
        System.out.println(predicateTask4.intersect(listOfPredicates).test(100000));
        System.out.println(predicateTask4.intersect(listOfPredicates).test(11));
    }

}



/*Task2
 * create functional interface TernaryIntPredicate
 * and method boolean test(Integer, Integer, Integer)
 *
 * Initialize such object of type TernaryIntPredicate,
 * that returns true, when all arguments are different
 *
 *
 * Task3
 * Function<Double, Double> f= x->x*2,
 * Function<Double, Double> g= x->x+3,
 * What is the formula for their composition (for h)?
 * Function h = f.compose(g)
 *
 *
 * Task4
 * write a method which takes List<Predicate> and returns an
 * IntPredicate which returns true, when all Predicates return true
 * IntPredicate intersect(List<Predicate> predicates)*/