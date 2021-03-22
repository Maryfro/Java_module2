public class Main {


    public static void main(String[] args) {
        Line line = new Line('*', 10);
        //line.draw();
        Rectangle rectangle = new Rectangle('+', 5, 6);
        // rectangle.draw();
        Shape[] shapes = {line, rectangle, line, rectangle, new Picture('#', new Shape[]{rectangle, line})};
        Picture picture = new Picture('§', shapes);
        picture.draw();
    }


}
