package data;

public class TrackingService {
    private int total;
    private int goal;
    private History[] history;
    private int historyNum = 0;

    public TrackingService(int capacity) {
        history = new History[capacity];
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getTotal() {
        return total;
    }

    public int getHistoryNum() {
        return historyNum;
    }

    public History[] getHistory() {
        return history;
    }

    public void addCalories(int amount) {
        total += amount;
        history[historyNum] = new History(amount, "add calories", ++historyNum, total);
    }

    public void removeCalories(int amount) {
        total -= amount;
        if (total < 0) total = 0;
        history[historyNum] = new History(amount, "remove calories", ++historyNum, total);
    }

    public void displayHistory() {
        for (int i = 0; i < historyNum; i++) {
            System.out.println(history[i]);
        }
    }

    public boolean checkGoal() {
        return total <= goal;
    }
}
