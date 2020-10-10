package airplane;

public class Boeing {
    private int manufactureYear;
    private static int numberOfSeats = 300;

    public Boeing(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
    static class Drawing{
         static class Author{
              static String author = "Smith";
         }

        private int id;

        public Drawing(int id) {
            this.id = id;
        }

        public static int getCapacity() {
            return numberOfSeats;
        }

        @Override
        public String toString() {
            return "Drawing{" +
                    "id=" + id +
                    '}';
        }
    }

}
