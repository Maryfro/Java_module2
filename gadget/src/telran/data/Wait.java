package telran.data;

public class Wait implements GadgetState{
    @Override
    public void doAction() {
        System.out.println("I am waiting");
    }
}
