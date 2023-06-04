package homework9;

import java.util.*;

public class L9_Algorithms_HW {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>(List.of(
                new Item(1, 2),
                new Item(10, 2),
                new Item(3, 15),
                new Item(3, 5),
                new Item(25, 4),
                new Item(7, 35)));
        //System.out.println(items);
        Collections.sort(items, Comparator.comparingDouble(Item::getAverage).reversed());
        System.out.println("Sorted items: " +items);
        final int backpackWeight = 10;
        int currentWeight = 0;
        for (int i=0; i<items.size(); i++) {

            if (currentWeight < backpackWeight){
                System.out.println("This item put to the backpack: " + items.get(i));
                currentWeight = currentWeight + items.get(i).getWeight();
                //    System.out.println(currentWeight);
            }
        }
        System.out.println("backpackWeight = "+currentWeight);

    }

}

class Item{
    private int weight;
    private int value;

    private double average;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.average =(double)value/(double)weight;
    }

    public double getAverage() {
        return average;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + value +
                ", average=" + average +
                '}';
    }
}