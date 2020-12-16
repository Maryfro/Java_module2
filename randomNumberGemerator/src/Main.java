import generator.RandomGenerator;
import generator.RandomRule;
import generator.rule.ListRandomRule;
import generator.rule.RangeRandomRule;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 7, 2);
        int[] nums = new int[]{1, 10, -15, 100, 14, 34, 45, 23, 235};
        RandomRule lrr1 = new ListRandomRule(nums);

        ListRandomRule lrr2 = new ListRandomRule(list);
       /* System.out.println(lrr1.nextInt());
        System.out.println(lrr1.nextInt());
        System.out.println(lrr1.nextInt());
        System.out.println(lrr.nextInt());
        System.out.println(lrr.nextInt());
        System.out.println(lrr.nextInt());*/
        RandomGenerator rg1 = new RandomGenerator(lrr1);
        RandomGenerator rg2 = new RandomGenerator(lrr2);
        RandomGenerator rg3 = new RandomGenerator(new RangeRandomRule(43));
        System.out.println(rg1.nextInts(10));
        System.out.println(rg2.nextInts(12));
        System.out.println(rg3.nextInts(12));
    }
}
//interface RandomRule
//public int nextInt(); returns random int numbers

//interface is implemented by 2 classes

//1. RangeRandomRule: first implementation is random numbers in range from 0(incl) to n(excl)
// private int n;
// Constructor with n
// public int nextInt();
//RandomRule rule = new RangeRandomRule(10);
//rule.nextInt();//0..9

//2. ListRandomRule second implementation
// private int[] values/List<Integer> values
//Constructor 1:  public List RR(List<Integer> numbers) -> values
//Constructor 2:  public List RR(int[] numbers) -> values
//public int nextInt(); returns numbers with equal probability
//{8, -5, 15}->lrr.nextInt()->
// RandomRule rule = new ListRandomRule({-3, 5, 10});
//rule.nextInt();
//rule.nextInt();
//rule.nextInt();
//rule.nextInt();

// class RandomGenerator
//- RandomRule rule
//constructor RandomGenerator(rule)
//List<Integer> nextInts(int n);
