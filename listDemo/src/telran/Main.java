package telran;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> listString = new LinkedList<>(Arrays.asList("buzz", "fizz"));
        listString.add("Hi");
        Collections.addAll(listString, "hello", "world", "java", "code");

        //listString = Arrays.asList("buzz", "fizz");
        System.out.println(listString);
        //listString.add("Hey"); -> !!! UnsupportedOperationException
        // System.out.println(listString);


        List<String> strings = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        List<String> subList = strings.subList(1,3);
        System.out.println(subList);
        subList.add(0, "!");
        System.out.println(strings);
        System.out.println(subList);
        listString.addAll(0, strings);
        strings.addAll(subList);
        System.out.println(listString);
        System.out.println(strings);

    }
}
