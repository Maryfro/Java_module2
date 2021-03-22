package telran.data;

public interface Colorable {
    Color getColor();

    class Color {
        private int red, blue, green;

        public Color(int red, int blue, int green) {
            this.red = red;
            this.blue = blue;
            this.green = green;
        }

        public int getRed() {
            return red;
        }

        public int getBlue() {
            return blue;
        }

        public int getGreen() {
            return green;
        }
    }
}

class Triangle implements Colorable {
    private Color color;

    @Override
    public Color getColor() {
        return color;
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();

        t.color = new Color(123, 34, 35);
        System.out.println(t.getColor());
    }

}
