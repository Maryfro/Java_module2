package de.telran;

public class LoanIssuer {
    private String name;
    private boolean isLazy;
    private boolean isKind;

    public String getName() {
        return name;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public boolean isKind() {
        return isKind;
    }

    public LoanIssuer(String name, boolean isLazy, boolean isKind) {
        this.name = name;
        this.isLazy = isLazy;
        this.isKind = isKind;
    }

    public boolean toIssue(LoanConsumer lc) {
         if (!(isKind || isLazy)) {
            return lc.getAge() >= 18 && lc.getAge() < 50 && lc.getIncome() > 20000;
        } else if (isKind && !isLazy) {
            return lc.getAge() >= 18 && lc.getAge() < 70 && lc.getIncome() > 20000;
        }
        return lc.getAge() >= 18 && lc.getIncome() > 20000;

    }

    public static void main(String[] args) {

        LoanConsumer lc1 = new LoanConsumer("Ivan", 70, 25000);
        LoanConsumer lc2 = new LoanConsumer("Vasja", 49, 21000);
        LoanConsumer lc3 = new LoanConsumer("Petya", 15, 21000);
        LoanConsumer lc4 = new LoanConsumer("Max", 15, 19000);
        LoanIssuer li1 = new LoanIssuer("Boss", false, false);
        LoanIssuer li2 = new LoanIssuer("Boss2", true, true);

        //LoanIssuer[] loanIssuers =  {li1, li2};
        LoanConsumer[] loanConsumers = {lc1, lc2, lc3, lc4};
        for (int i = 0; i < loanConsumers.length; i++) {
            System.out.println("Not lazy and not kind bank employee issues credit to " +
                    loanConsumers[i].getName() + ", " + loanConsumers[i].getAge() + " years old, income "+
                    loanConsumers[i].getIncome()+ " : "+ li1.toIssue(loanConsumers[i]));
        }

        System.out.println("-----------------");
        for (int i = 0; i < loanConsumers.length; i++) {
            System.out.println("lazy and kind bank employee issues credit to " +
                    loanConsumers[i].getName() + ", " + loanConsumers[i].getAge() + " years old, income "+
                    loanConsumers[i].getIncome()+ " : "+ li2.toIssue(loanConsumers[i]));
        }



    }
}
