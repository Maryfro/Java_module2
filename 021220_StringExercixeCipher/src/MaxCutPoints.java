import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MaxCutPoints {


    int maxCoveredPoints(List<Integer> numbers, int cut) {
        ArrayDeque<Integer> cutDeque = new ArrayDeque<>();
        ArrayList<Integer> numbersCopy = (ArrayList) numbers;
        int max = 1;
        for (int i = 0; i < numbersCopy.size(); i++) {
            cutDeque.addLast(numbersCopy.get(i));
            for (int j = 0; j < cutDeque.size(); j++) {
                if (numbersCopy.get(i) - cutDeque.getFirst() > cut) {
                    cutDeque.removeFirst();
                }
            }
            if (max < cutDeque.size()) {
                max = cutDeque.size();
            }
        }
        return max;
    }

}
//There is a list of sorted int numbers. There is another number, which stands for the length of a cut.
//We need to find the maximal number of points we can cover with the cut.
//int maxCoveredPoints(List<Integer> numbers, int cut); numbers are sorted!
// 10, 15, 25, 31, 40, 55, 58, 64; cut=9 -> {55, 58, 64}-> res: 3
//naive algorithm ->using 2 loops we are iterating over list, second loop we are iterating in inner loop

//using deque: with every iteration we move our cut to the right
//cutDeque should contain all numbers covered with last number on the right
//1st iteration cutDeque{10}
//{10, 15}
//{10, 15, 25}->remove 10,
