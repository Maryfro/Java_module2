import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class NormalizationCollector implements Collector<Double, List<Double>, List<Double>> {

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
    public Function<List<Double>, List<Double>> finisher() {
        return numbers -> {
            double min = Collections.min(numbers);
            double max = numbers.stream().max(Double::compareTo).orElseThrow(NoSuchElementException::new);
            double divisor = max - min;
            List<Double> res = new ArrayList<>();
            for (Double num : numbers) {
                res.add((num - min) / divisor);
            }
            return res;

            // return numbers.stream().map(n->((n-min))/divisor).collect(Collectors.toList());
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
