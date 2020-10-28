package de.telran;

import java.util.*;

public class Exercise {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6, 4))));
        System.out.println(getDuplicates(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6, 4))));
        System.out.println("--------------------------");
        Map<String, String> map = new HashMap<>();
        map.put("a", "Hi");
        map.put("b", "There");
        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "Hi");
        Map<String, String> map2 = new HashMap<>();
        map2.put("b", "There");
        System.out.println(mapAB(map));
        System.out.println(mapAB(map1));
        System.out.println(mapAB(map2));
        System.out.println("--------------------------");
        System.out.println(wordMultiple(new String[]{"a", "b", "a", "c", "b"}));
        System.out.println(wordMultiple(new String[]{"c", "b", "a"}));
        System.out.println(wordMultiple(new String[]{"c", "c", "c", "c"}));
        System.out.println("--------------------------");
        Set<String> dictionary = new HashSet<>();
        Collections.addAll(dictionary, "anna", "ivan", "naan", "vani", "piotr", "navi");
        System.out.println(getAnagrams(dictionary, "vani"));
        System.out.println(getAnagrams(dictionary, "anna"));
        System.out.println(getAnagrams(dictionary, "piotr"));
    }

    private static List<Integer> removeDuplicates(List<Integer> input) {
        Set<Integer> temp = new HashSet<>();
        temp.addAll(input);
        List<Integer> output = new ArrayList<>();
        output.addAll(temp);
        return output;
    }

    private static List<Integer> getDuplicates(List<Integer> input) {
        List<Integer> copy = new ArrayList<>();
        copy.addAll(input);
        List<Integer> set = removeDuplicates(copy);
        for (Integer i : set) {
            copy.remove(i);
        }
        return copy;
    }

    private static Map<String, String> mapAB(Map<String, String> map) {
        if (map.size() > 1) {
            List<String> keySet = new ArrayList<>();
            keySet.addAll(map.keySet());
            List<String> values = new ArrayList<>();
            values.addAll(map.values());
            String newKey = "";
            String newValue = "";
            for (int i = 0; i < map.size(); i++) {
                newKey += keySet.get(i);
                newValue += values.get(i);
            }
            map.put(newKey, newValue);
        }
        return map;
    }

    private static Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String s : strings) {
            map.put(s, map.containsKey(s));
        }
        return map;
    }

    private static Map<String, Set<String>> getAnagrams(Set<String> dictionary, String word) {
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> output = new HashSet<>();
        for (String s : dictionary) {
            if (isAnagram(s, word) && !s.equals(word)) {
                output.add(s);
                map.put(word, output);
            }
        }
        return map;
    }

    private static boolean isAnagram(String firstWord, String secondWord) {
        char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
        char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }
}
