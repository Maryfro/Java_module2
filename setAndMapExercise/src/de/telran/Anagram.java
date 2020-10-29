package de.telran;

import java.util.*;

public class Anagram {
    private String[] dictionary;
    private Map<String, List<String>> map;

    public Anagram(String[] dictionary) {
        this.dictionary = dictionary;
        map = new HashMap<>();
    }

    public Map<String, List<String>> getMap() {
        return map;
    }

    private static String sortWords(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }

    public void createMap() {
        for (String word : dictionary) {
            String key = sortWords(word);
            if (!map.containsKey(key)) {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                map.put(key, anagrams);
            } else {
                List<String> anagrams = map.get(key);
                anagrams.add(word);
            }
        }
    }

    public List<String> getAnagrams(String word) {
        String key = sortWords(word);
        return map.get(key);
    }

}
