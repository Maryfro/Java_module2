package telran.data;

public class Off implements GadgetState{
    @Override
    public void doAction() {
        System.out.println("I am off");
    }
}
