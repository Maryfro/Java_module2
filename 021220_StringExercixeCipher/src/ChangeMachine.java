import java.util.ArrayList;

public class ChangeMachine {
    // a public collection of available coins
    public static int[] coins = {25, 10, 5, 1};

    public static ArrayList<Integer> getMinCoins(int amount)  // function to receive change in the form of coins
    {
        ArrayList<Integer> change = new ArrayList<Integer>();
        for (int i = 0; i< coins.length; i++) {
            if (amount >= coins[i]) {
                change.add(coins[i]);
                amount -= coins[i];
                i--;
            }
            if (amount <= 0)
                break;
        }
        return change;
    }

    public static void main(String[] args) {
        System.out.println(getMinCoins(9)); //5, 1, 1, 1, 1
        System.out.println(getMinCoins(3)); //1, 1, 1
        System.out.println(getMinCoins(50)); //25, 25
        System.out.println(getMinCoins(35)); //25, 10
        System.out.println(getMinCoins(30)); //25, 5
        System.out.println(getMinCoins(20)); //10, 10
        System.out.println(getMinCoins(33)); // 25, 5, 1, 1, 1
        System.out.println(getMinCoins(12)); // 10, 1, 1
        System.out.println(getMinCoins(101)); // 25, 25, 25, 25, 1
    }
}

