import java.util.*;

public class Exercise3 {

    // Есть список слов. Вернуть лист листов, каждый элемент которого - это отсортированный набор слов,
    // начинающихся на одинаковую букву
    //[бекон, арбуз, бобер, бидон, алмаз, банан, боб, ...]   ->   [ [алмаз, арбуз], [банан, бекон, бидон, боб, бобер], ...]

    public List<List<String>> createDictionary(List<String> words) {
        HashMap<String, List<String>> dictionary = new HashMap<>();
        Collections.sort(words);
        HashSet<String> keys = new HashSet<>();
        for (String word : words) {
            keys.add(String.valueOf(word.charAt(0)));
        }
        for (String key : keys) {
            List<String> values = new ArrayList<>();
            for (String word : words) {
                if (key.equals(String.valueOf(word.charAt(0)))) {
                    values.add(word);
                }
                dictionary.put(key, values);
            }
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(dictionary.values());
        return res;
    }
}
