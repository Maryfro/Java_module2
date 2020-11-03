package de.telran;

import java.time.LocalDate;
import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        LengthCounter lc = new LengthCounter() { // anonymous class
            @Override
            public int count(String s) {
                return s.length();
            }
        };

        LengthCounter lc1 = s -> {
            System.out.println("hi");
            return s.length();
        };

        //  System.out.println(lc1.count("hello"));

       /* Comparator<String> cs = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((Integer)o1.length()).compareTo(o2.length());
                //o1.length()-o2.length();
            }
        };*/

        Comparator<String> cs1 = (s1, s2) -> ((Integer) s1.length()).compareTo(s2.length());

        System.out.println("comparator " + cs1.compare("hello", "hi"));

        Comparator<Person> personComparatorByAge = (p1, p2) -> ((Integer) p1.getAge()).compareTo(p2.getAge());
        Comparator<Person> personComparatorByName = (p1, p2) -> p1.getName().compareTo(p2.getName());

        Predicate p = new Predicate() {
            @Override
            public boolean test(Object o) {
                return false;
            }
        };
        Predicate<String> pr = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 0;
            }
        };
        Predicate<Integer> pr1 = integer -> integer > 0;
        System.out.println("predicate with integer test " + pr1.test(10));
        System.out.println("two predicats " + pr1.and(p).test(1));


        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));


        System.out.println(sumAll(list, integer -> true));
        System.out.println(sumAll(list, integer -> integer % 2 == 0));
        System.out.println(sumAll(list, integer -> integer > 3));


        Function<String, Integer> f = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        Function<String, String> fs = s -> s.toUpperCase();
        // fs.compose()
        System.out.println(fs.apply("asdf xflvköl"));

        Function<String, String> fs1 = String::toUpperCase;

        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };
        Consumer<Integer> consumer1 = System.out::println;
        list.forEach(consumer1);

        Supplier s = new Supplier() {
            @Override
            public Object get() {
                return null;
            }
        };

        Supplier<String> s1 = ()->"Salut";
        System.out.println(s1.get());
        Supplier<LocalDate> date = ()->LocalDate.now().minusDays(1);
        System.out.println(date.get());

        BiFunction bi = new BiFunction() {
            @Override
            public Object apply(Object o, Object o2) {
                return null;
            }
        };
        BiFunction<String, Integer, Person> person = Person::new;
        person.apply("Vasya", 10);

        UnaryOperator<Integer> uo = integer -> (int)Math.sqrt(9);
        System.out.println(uo.apply(5));

        BinaryOperator<Integer> multiply = (x, y) -> x*y;
        System.out.println(multiply.apply(2,2));
        System.out.println(multiply.andThen(uo).apply(2, 1));


    }

    public static int sumAll(List<Integer> list, Predicate<Integer> p) {
        int sum = 0;
        for (Integer i : list) {
            if (p.test(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
