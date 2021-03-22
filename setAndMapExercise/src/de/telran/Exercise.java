package de.telran;

import java.util.*;

public class Exercise {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6, 4))));
        System.out.println(getDuplicates(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6, 4))));
        System.out.println(getDuplicates1(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6, 4))));
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
        System.out.println(wordMultiple1(new String[]{"c", "c", "c", "c"}));
        System.out.println("--------------------------");
        Set<String> dictionary = new HashSet<>();
        Collections.addAll(dictionary, "anna", "ivan", "naan", "vani", "piotr", "navi");
        System.out.println(getAnagrams(dictionary, "vani"));
        System.out.println(getAnagrams(dictionary, "anna"));
        System.out.println(getAnagrams(dictionary, "piotr"));
        System.out.println("-----------------------------");
        Anagram anagram = new Anagram(new String[]{"anna", "ivan", "naan", "vani", "piotr", "navi"});
        anagram.createMap();
        System.out.println(anagram.getMap());
        System.out.println(anagram.getAnagrams("sam"));
        System.out.println(anagram.getAnagrams("anna"));

    }

    private static <E> List<E> removeDuplicates(List<E> input) {
        Set<E> temp = new HashSet<>();
        temp.addAll(input);
        List<E> output = new ArrayList<>();
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

    private static <E> List<E> getDuplicates1(List<E> input) {
        Set<E> temp = new HashSet<>();
        List<E> copy = new ArrayList<>();
        for (E i : input) {
            if (!temp.add(i)) {
                copy.add(i);
            }
        }
        return copy;
    }

    private static Map<String, String> mapAB(Map<String, String> map) {
        if (map.size() > 1) {
            List<String> keySet = new ArrayList<>();
            keySet.addAll(map.keySet());
            List<String> values = new ArrayList<>();
            values.addAll(map.values());
            String newKey = keySet.get(0) + keySet.get(1);
            String newValue = values.get(0) + values.get(1);
            /*for (int i = 0; i < map.size(); i++) {
                newKey += keySet.get(i);
                newValue += values.get(i);
            }*/
            map.put(newKey, newValue);
        }
        return map;
    }

    private static Map<String, String> mapAB1(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b")) {
            map.put("ab", map.get("a") + map.get("b"));
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

    private static Map<String, Boolean> wordMultiple1(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        int count;
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        for (String s : strings) {
            count = Collections.frequency(list, s);
            map.put(s, count > 1);
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
