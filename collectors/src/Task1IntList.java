import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Task1IntList {

    List<Integer> list;

    public Task1IntList(List<Integer> list) {
        this.list = list;
    }

    public int findSumOfSquaredNumbers() {
        return list.stream().collect(Collectors.summingInt(number -> number * number));
    }

    public int findProductOfSquaredNumbers() {
        return list.stream().collect(Collectors.reducing(1,
                numInt -> numInt.intValue(),
                (currentRes, currentNum) -> currentRes * currentNum * currentNum));


    }
}
