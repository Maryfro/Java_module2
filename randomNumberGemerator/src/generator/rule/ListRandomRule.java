package generator.rule;

import generator.RandomRule;

import java.util.ArrayList;
import java.util.List;


public class ListRandomRule implements RandomRule {
    private final ArrayList<Integer> values;

    public ListRandomRule(List<Integer> numbers) {
        this.values = new ArrayList(numbers);
    }

    public ListRandomRule(int[] numbers) {
        values = new ArrayList<>();
        for (int num : numbers) {
            values.add(num);
        }
    }

    public int nextInt() {
        return values.get(((int) (Math.random() * (values.size() - 1) + 1)));
    }
}
