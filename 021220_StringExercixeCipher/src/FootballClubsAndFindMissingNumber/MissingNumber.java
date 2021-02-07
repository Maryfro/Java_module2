package FootballClubsAndFindMissingNumber;

import java.util.*;

// we have an array of unique numbers from 1 to 100 but one.
//Find the missing number
public class MissingNumber {
    int min;
    int max;
    final int randomNumber;
    int missingNumber;

    public MissingNumber(int min, int max) {
        this.min = min;
        this.max = max;
        randomNumber = (int) (Math.random() * max - min) + min;
    }

    public int findMissingNumber_withTwoLists(int[] arr) {
        int missingNumber;
        List<Integer> list = new ArrayList<>();
        List<Integer> fullList = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        for (int i = 1; i <= 100; i++) {
            fullList.add(i);
        }
        fullList.removeAll(list);
        missingNumber = fullList.get(0);
        return missingNumber;
    }

    public int findMissingNumber_withSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int total = (arr.length + 1) * (arr.length + 2) / 2;  //    total sum = (N(N+1))/2)
        return total - sum;
    }

    public int findMissingNumber_binarySearch(int[] arr) {
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while ((right - left) > 1) {
            mid = (right + left) / 2;
            if ((sorted[left] - left) != (sorted[mid] - mid))
                right = mid;
            else if ((sorted[right] - right) != (sorted[mid] - mid))
                left = mid;
        }
        return (sorted[mid] + 1);
    }

    int[] composeArrayForInput() {
        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        missingNumber = list.remove(this.randomNumber);
        int[] res = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            res[i++] = integer;
        }
        return res;
    }
}

