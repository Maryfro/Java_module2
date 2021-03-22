package telran.data;

public class On implements GadgetState {

    @Override
    public void doAction() {
        System.out.println("I am on");
    }
}
