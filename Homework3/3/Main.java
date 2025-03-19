/*
 * INSTRUCTION:
 *     This is a Java starting code for hw0_1.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw3_3.java
 * Abstract: read the weight and value of each item from a user and determine the best subset
 * Name: Colton Korhummel
 * Date: 2/23/2024
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int mass = sc.nextInt();

        ArrayList<Integer> binary = new ArrayList<>();
        ArrayList<Item> steal = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            Item temp = new Item();
            temp.weight = sc.nextInt();
            temp.worth = sc.nextInt();
            steal.add(temp);
            binary.add(0);
        }

        ArrayList<Bag> Stolen = new ArrayList<>();

        int loop = (int) Math.pow(2, amount);
        for (int i = 0; i < loop; i++) {
            int tempWeight = 0, tempWorth = 0;
            String tempItem = "";
            for(int j = binary.size()-1; j >= 0; j--) {
                if(binary.get(j) == 0){
                    binary.set(j, 1);
                    break;
                }else if(binary.get(j) == 1){
                    binary.set(j, 0);
                }
            }

            for (int j = 0; j < binary.size(); j++) {
                if(binary.get(j) == 1){
                    tempWeight += steal.get(j).weight;
                    tempWorth += steal.get(j).worth;
                    int itemTemp = j+1;
                    tempItem = tempItem + itemTemp + " ";
                }
            }
            if(tempWeight <= mass){
                Stolen.add(new Bag(tempWeight , tempWorth, tempItem));
            }
        }

        int multiple = 0;
        Stolen.sort((a, b) -> Integer.compare(a.worth, b.worth));
        Collections.reverse(Stolen);
        for (int i = 1; i < Stolen.size(); i++) {
            if(Stolen.get(0).worth == Stolen.get(i).worth){
                multiple++;
            }
        }
        String str = Stolen.get(0).item;
        if(multiple == 0) {
            System.out.println("Item:" + str.stripTrailing() + "\nCapacity:" + Stolen.get(0).weight + "\nValue:" + Stolen.get(0).worth);
        } else {
            System.out.println("Item:Multiple solutions\nCapacity:" + Stolen.get(0).weight + "\nValue:" + Stolen.get(0).worth);
        }
    }

    static class Item{
        public int weight;
        public int worth;

    }

    static class Bag{
        public int weight;
        public int worth;
        public String item;

        public Bag(int weight, int worth, String item) {
            this.weight = weight;
            this.worth = worth;
            this.item = item;
        }
    }
}
