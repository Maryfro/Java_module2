package data;

import java.util.Objects;

public class History {
    private int amount;
    private String operation;
    private int id;
    private int total;

    public History(int amount, String operation, int id, int total) {
        this.amount = amount;
        this.operation = operation;
        this.id = id;
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return amount == history.amount &&
                id == history.id &&
                total == history.total &&
                operation.equals(history.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, operation, id, total);
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", amount: " + amount +
                ", operation: " + operation +
                ", total: " + total;
    }
}

