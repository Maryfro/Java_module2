import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateTask4 {

    IntPredicate intersect(List<Predicate> predicates) {

        IntPredicate intPredicate1 = new IntPredicate() {
            @Override
            public boolean test(int value) {
                for (Predicate p : predicates) {
                    if (!p.test(value))
                        return false;
                }
                return true;
            }
        };

        return intPredicate1;
    }
}
