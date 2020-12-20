

public class Main {

    public static void main(String[] args) {
        GetMaxImpl gml = new GetMaxImpl();
        gml.addLast(220);
        gml.addLast(200);
        gml.addLast(30);
        gml.addLast(25);
        System.out.println(gml.getMax());
    }
}
