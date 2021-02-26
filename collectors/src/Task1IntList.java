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

    public int findProductOfSquaredNumbers() throws NoSuchElementException {

        Optional<Integer> res = list.stream().collect(Collectors.reducing((x, y) ->
                ((int) Math.pow(x, 2)) * (int) Math.pow(y, 2)));

        if (res.isPresent())
            return res.get();
        else throw new NoSuchElementException();
    }
}
