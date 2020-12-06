import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       List<Integer> list = new ArrayList<>();

        /*try{
        list.get(10);
        }
        catch(IndexOutOfBoundsException e){
           e.printStackTrace();
          // System.out.println(e.getMessage());
*/
            ArrayIntegerList<Integer> myList = new ArrayIntegerList<>();
            myList.addLast(15);
        System.out.println(myList.contains(15));
        myList.clear();
        System.out.println(myList.size());
    }
    }

