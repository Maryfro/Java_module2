package telran;

import java.util.*;

public class CollectionIssue {
    public static void main(String[] args) {
        List<Integer> listInteger = fillListWithIntegers(10);
        System.out.println("source list: " + listInteger);
        getElementsBelowGivenNumber(listInteger, 11);
        System.out.println("list without numbers greater than 11: " + listInteger);
        System.out.println("--------------");
        List<Integer> listIntegerTwo = new ArrayList<>();
        Collections.addAll(listIntegerTwo, 1, 2, 3);
        System.out.println("merge two lists: " + mergeTwoLists(listInteger, listIntegerTwo));
        System.out.println("--------------");
        System.out.println("reverse list: " + reverseList(listIntegerTwo));
        System.out.println("--------------");
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "aa", "bb", "cc", "dd");
        List<String> two = new ArrayList<>();
        Collections.addAll(two, "cc", "dd", "aa", "bb");
        List<String> three = new ArrayList<>();
        Collections.addAll(three, "dd", "ee", "ff");
        List<String> four = new ArrayList<>();
        Collections.addAll(four, "dd", "ff", "ee");
        System.out.println("loop version: " + isLoopVersion(one, two));
        System.out.println(isLoopVersion2(one, two));
        System.out.println("loop version: " + isLoopVersion(three, four));
        System.out.println(isLoopVersion2(three, four));
        System.out.println("--------------");
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Ivan", "Maria", "Stephan", "John", "John", "Amalia");
        System.out.println("names longer than 4 characters " + namesLongerThanFourCharacters(names));
        System.out.println(namesLongerThanFourCharacters2(names));
        System.out.println("--------------");
        List<Integer> listOne = new ArrayList<>();
        Collections.addAll(listOne, 1, 2, 3, 4);
        List<Integer> listTwo = new ArrayList<>();
        Collections.addAll(listTwo, 5, 2, 3, 8);
        System.out.println("compare two lists by elements equality " + compareTwoLists(listOne, listTwo));
        System.out.println("--------------");
        List<Person> persons = new ArrayList<>();
        Collections.addAll(persons, new Person("Mary Poppins", new Address("Baker Street", 33)),
                new Person("Charlie Chaplin", new Address("Mon Martre", 2)),
                new Person("Arnold Schwarznegger", new Address("Orange County", 8)));
        System.out.println("get addresses by persons " + Person.getAddresses(persons));
    }

    private static List<Integer> fillListWithIntegers(int size) {
        List<Integer> listInteger = new ArrayList<>();
        while (listInteger.size() < size) {
            listInteger.add((int) (Math.random() * 20));
        }
        return listInteger;
    }

    //  Написать функцию, которая вернет список без элементов, больше заданного
    private static List<Integer> getElementsBelowGivenNumber(List<Integer> listInteger, int number) {
        Iterator<Integer> iterator = listInteger.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() > number) {
                iterator.remove();
            }
        }
        return listInteger;
    }

    // Объединить два списка в один.
    private static List<Integer> mergeTwoLists(List<Integer> one, List<Integer> two) {
        one.addAll(two);
        return one;
    }

    // Написать функцию, которая реверсирует список
    private static List<Integer> reverseList(List<Integer> listInteger) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < listInteger.size(); i++) {
            output.add(listInteger.get(listInteger.size() - 1 - i));
        }
      //  Collections.reverse(listInteger);
        return output;
    }

    //Есть два списка с буквами. Определить, является ли один список циклической версией другого.
    private static boolean isLoopVersion(List<String> one, List<String> two) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < one.size(); i++) {
            if (one.get(0).equals(two.get(i))) {
                for (int j = i; j < one.size(); j++) {
                    temp.add(two.get(j));
                }
            }
        }
        if (temp.size() != one.size()) {
            temp.addAll(two.subList(0, one.size() - temp.size()));
        }
        return one.equals(temp);
    }

    private static boolean isLoopVersion2(List<String> one, List<String> two) {
        if (one.size() != two.size()) {
            return false;
        }
        for (int i = 0; i < one.size(); i++) {
            Collections.rotate(one, 1);
            if(one.equals(two)){
                return true;
            }
        }
        return false;
    }

    //Есть список с именами: Ivan, Maria, Stephan, John, Amalia. Написать функцию,
    //которая вернет список, в котором не содержатся имена исходного списка длиной 4.
    private static List<String> namesLongerThanFourCharacters(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() == 4) {
                iterator.remove();
            }
        }
        return list;
    }

    private static List<String> namesLongerThanFourCharacters2(List<String> list) {
        Iterator<String> iterator = list.iterator();
        for (String s : list) {
            if (iterator.next().length() == 4) {
                iterator.remove();
            }
        }
        return list;
    }

    private static List<String> namesLongerThanFourCharacters1(List<String> list) {
        List<String> output = new ArrayList<>();
        for (String s : list) {
            if (s.length() != 4) {
                output.add(s);
            }
        }
        return output;
    }


    //Есть два списка одинаковой длины с числами. Написать функцию, которая вернет список с элементами Yes или No, где значение
    // на i-том месте зависит оттого, равны ли элементы двух списков под номером i.
    private static List<String> compareTwoLists(List<Integer> one, List<Integer> two) {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < one.size(); i++) {
            output.add(one.get(i) == two.get(i) ? "Yes" : "No");
            /*if (one.get(i).intValue() == two.get(i).intValue()) {
                output.add("Yes");
            } else {
                output.add("No");
            }*/
        }
        return output;
    }
}




