package CutMapPoints;

public class Point {
    private int value;
    private Pointkind kind;

    public Point(int value, Pointkind kind) {
        this.value = value;
        this.kind = kind;
    }

    public int getValue() {
        return value;
    }

    public Pointkind getKind() {
        return kind;
    }
}
