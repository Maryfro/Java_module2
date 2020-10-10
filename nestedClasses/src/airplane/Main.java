package airplane;

public class Main {
    public static void main(String[] args) {
        System.out.println(Boeing.Drawing.getCapacity());
         Boeing.Drawing drawing = new Boeing.Drawing(23716);
        System.out.println(drawing.toString());
        System.out.println(Boeing.Drawing.Author.author);


    }
}
