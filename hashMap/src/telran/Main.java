package telran;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Hello", "World", "java", "code", "java"));
        System.out.println(countRepeatedWord(list, "Hi"));
        Map<String, Integer> map = WordsCount(list);
        System.out.println(countWords(map, "java"));
        System.out.println(map);
    }

    public static int countRepeatedWord(List<String> list, String word) {
        int count = 0;
        for (String w : list) {
            if (w.equals(word)) count++;
        }
        return count;
    }

    public static Map<String, Integer> WordsCount(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        return map;
    }

    public static int countWords(Map<String, Integer> map, String word) {
        if (!map.containsKey(word)) {
            return 0;
        }
        return map.get(word);
    }
}
