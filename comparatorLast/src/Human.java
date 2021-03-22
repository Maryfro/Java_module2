public class Human {
    boolean isMedicalPersonal;
    int age;

    public Human(boolean isMedicalPersonal, int age) {
        this.isMedicalPersonal = isMedicalPersonal;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "isMedicalPersonal=" + isMedicalPersonal +
                ", age=" + age +
                '}';
    }
}
