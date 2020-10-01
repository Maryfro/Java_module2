package telran.controller;

import telran.data.Flower;
import telran.data.Plant;
import telran.data.Tree;

public class App {
    public static void main(String[] args) {
        Plant tree1 = new Tree("Palm", 0, 0);
        Plant tree2 = new Tree ("Oak", 1, 100);
        Plant flower1 = new Flower("Rose", 1, 2);
        Plant flower2 = new Flower("Tulip", 0, 0);

        Plant[] plants = {tree2, flower1};

       // tree1.growthOfPlantForPeriod(3);
        growPlantsForPeriod(plants, 3);
        displayArray(plants);
    }

    public static void growPlantsForPeriod(Plant[] plants, int years){
        for (int i = 0; i <years ; i++) {
            for (Plant p: plants) {
                p.doYear();
                System.out.println("-------------------");
            }
        }
    }

    public static void displayArray(Object[] objects){
        for (Object o:objects) {
            System.out.println(o);
        }
    }
}
