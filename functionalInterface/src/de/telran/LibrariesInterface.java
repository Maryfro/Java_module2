package de.telran;

import java.util.function.Function;
import java.util.function.Predicate;

public class LibrariesInterface {
    public static void main(String[] args) {
        String n = "asd FKL dd AAS dasd";
        String n1 = "asd flg dd aas dasd";
        Predicate<String> lengthIsThree = s -> s.length() == 3;
        Predicate<Integer> moreThanTen = integer -> integer > 10;
        System.out.println(moreThanTen.test(20));
        Predicate<Person> olderThanTen = person -> person.getAge() > 10;
        System.out.println(olderThanTen.test(new Person("Vasja", 14)));
        Function<String, String> f = String::toUpperCase;
        Function<String, String> f1 = s -> s.replaceAll(".", "*");
        System.out.println(transformWord(n, lengthIsThree, f1));
        System.out.println(transformWord(n1, s -> s.length() % 2 == 0, String::toUpperCase));
    }

    public static String transformWord(String input, Predicate<String> p, Function<String, String> f) {
        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (p.test(strings[i])) {
                strings[i] = f.apply(strings[i]);
            }
        }
        return String.join(" ", strings);
    }

}
