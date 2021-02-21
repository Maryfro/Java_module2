import java.util.List;
import java.util.function.IntPredicate;

public class PredicateTask4 {

    IntPredicate intersect(List<IntPredicate> predicates) {

        IntPredicate res = (x) -> true;
        for (IntPredicate p : predicates) {
            res = res.and(p);
        }
        return res;
    }
}
