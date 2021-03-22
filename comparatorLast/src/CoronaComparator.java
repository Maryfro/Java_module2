import java.util.Comparator;

/*
 * The comparator determines a rule for comparing of two humans.
 * The rule is as follows: The most priority has a person who is medical personal.
 * Next priority has a human with the higher age.
 */
public class CoronaComparator<T> implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        if (o1.isMedicalPersonal && o2.isMedicalPersonal || !o1.isMedicalPersonal && !o2.isMedicalPersonal)
            return o1.age - o2.age;
        if (o1.isMedicalPersonal)
            return 1;
        else
            return -1;
    }
}
