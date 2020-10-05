package telran.data;

public class Newspaper implements Printable {

    public Newspaper() {
    }

    private String title;

    public Newspaper(String title) {
        this.title = title;
    }

    @Override
    public void print() {
    }

    @Override
    public void print2(String str) {
        System.out.println(str);
    }

    public String getTitle() {
        return title;
    }
}
