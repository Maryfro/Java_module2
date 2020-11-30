package de.telran;

public class LoanConsumer {
    private String name;
    private int age;
    private int income;

    public LoanConsumer(String name, int age, int income) {
        this.name = name;
        this.age = age;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getIncome() {
        return income;
    }
}
