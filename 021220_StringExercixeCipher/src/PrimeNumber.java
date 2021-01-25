import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {


    List<Integer> getPrimes(int upperBound) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i <= upperBound; i++) {
            int count = 0;
            for (int j = 2; j < i; j++) {
                if ((i % j) == 0)
                    count++;
            }
            if (count < 1)
                res.add(i);
        }
        return res;
    }
}
