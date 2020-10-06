package telran.data;

public class Gadget {
    private GadgetState state;

    public void setState(GadgetState state) {
        this.state = state;
    }

    public void doAction(){
        this.state.doAction();
    }

    /* public Gadget() {
    }


    public void setState(String state) {
        this.state = state;
    }

    public void doAction() {
        if (state.equalsIgnoreCase("on")) {
            System.out.println("I am on");
        } else {
            System.out.println("I am off");
        }
    }*/
}
