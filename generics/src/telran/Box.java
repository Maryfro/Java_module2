package telran;

import telran.robot.Head;
import telran.robot.Robot;
import telran.robot.SmallHead;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public <S extends Number> void run(S number) {
        System.out.println("T: " + t.getClass().getSimpleName());
        System.out.println("S: " + number.getClass().getSimpleName());
        System.out.println(number.intValue() * 2);

    }

    public void run1(Robot<SmallHead> robot) {

    }

    public void run2(Robot<? extends Head> robot) {

    }

    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<>();
        // list.add(77);//compilation error
        //list.add(2.5);

        List<? super Number> list1 = new ArrayList<>();
        list1.add(12);
        list1.add(2.5);

        Box<String> box = new Box<>();
        box.setT("hello");
        box.run(5.6);
        Box<Integer> box2 = new Box<>();
        box2.setT(2);
        box2.run(7);
    }
}
