package telran;

import java.util.Comparator;

public class PersonComparatorByNameAndAge implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int res = o1.getName().compareTo(o2.getName());
        if (res == 0) {
            res = o1.getAge() == o2.getAge() ? 0 : o1.getAge() > o2.getAge() ? 1 : -1;
        }
        return res;
    }
}
