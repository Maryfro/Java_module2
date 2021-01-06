import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        GetMaxImpl gml = new GetMaxImpl();
        gml.addLast(220);
        gml.addLast(200);
        gml.addLast(30);
        gml.addLast(25);
        System.out.println(gml.getMax());

        StackMax<Integer> max = new StackMax<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        max.addLast(260);
        max.addLast(260);
        max.addLast(-30);
        max.addLast(25);
        System.out.println(max.getMax());
    }
}
