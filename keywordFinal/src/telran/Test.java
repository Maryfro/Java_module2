package telran;

public class Test {
    private static int idNumber = 0;
    private final int ID_NUMBER;

   public Test(int ID_NUMBER) {
        this.ID_NUMBER = ID_NUMBER;
    }
    /*public Test(){
       ID_NUMBER = 10;
    }*/
    public int getID_NUMBER() {
        return ID_NUMBER;
    }

    public Test() {
        idNumber++;
        ID_NUMBER = 0;
    }
    public static int getIdNumber() {
        return idNumber;
    }
    public static void setIdNumber(int idNumber) {
        Test.idNumber = idNumber;
    }
    public static void main(String[] args) {
        Test t1 = new Test(54);
        Test t2 = new Test(529475);
        System.out.println(t1.getID_NUMBER());
        System.out.println(t2.getID_NUMBER());
       Test t3 = new Test();
        Test t4 = new Test();
        Test t5 = new Test();
        Test t6 = new Test();
        System.out.println(Test.getIdNumber());
        System.out.println(t6.getID_NUMBER());
        System.out.println(Test.getIdNumber());
    }
}
