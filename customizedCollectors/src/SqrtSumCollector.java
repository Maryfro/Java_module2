import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class SqrtSumCollector implements Collector<Double, List<Double>, Double> {
    @Override
    public Supplier<List<Double>> supplier() {
        return () -> new ArrayList<>();
    }

    @Override
    public BiConsumer<List<Double>, Double> accumulator() {
        return (temporaryList, number) -> temporaryList.add(number);
    }

    @Override
    public BinaryOperator<List<Double>> combiner() {
        return (currentRes, currentList) -> {
            currentRes.addAll(currentList);
            return currentRes;
        };
    }

    @Override
    public Function<List<Double>, Double> finisher() {
        return numbers -> {
            int count = numbers.size();
            if (count == 0)
                throw new NoSuchElementException();
            double sum = numbers.stream()
                    .reduce(0.0, (currentRes, currentNum) -> currentRes + currentNum * currentNum);
            return Math.sqrt(sum / count);
        };

    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
