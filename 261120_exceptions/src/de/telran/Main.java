package de.telran;

public class Main {

    static boolean toThrow = false;

    public static void main(String[] args) {
        //methodOne();
        toThrow = true;
        //methodOne();
        try {
            System.out.println("before");
            methodOne();
            System.out.println("after");
        } catch (UncheckedException ex) {
            System.out.println("under the catch");
        } catch (RuntimeException ex) {
            System.out.println("under the  second catch"); // code will not work
        }

        try {
            methodTwo();
        } catch (CheckedException e) {
            System.out.println("under check ex catch");
        } finally {
            System.out.println("under finally");
        }

        try {
            methodOne();
        } finally {
            //throw new IndexOutOfBoundsException();
            System.out.println("under second finally");
        }


    }

    static void methodOne() {
        if (toThrow)
            throw new UncheckedException();
    }

    /**
     * Description of method
     *
     * @throws CheckedException
     */
    static void methodTwo() throws CheckedException {
        if (toThrow)
            throw new CheckedException();
    }

    void methodThree() {
        try {
            methodOne();
        } catch (UncheckedException e) {
            throw new IndexOutOfBoundsException();
        } finally {
            throw new NullPointerException();
        }
    }
}
