import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        try{
        list.get(10);
        }
        catch(IndexOutOfBoundsException e){
           e.printStackTrace();
          // System.out.println(e.getMessage());
        }
    }

}
