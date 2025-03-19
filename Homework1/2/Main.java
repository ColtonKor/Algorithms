/*
 * INSTRUCTION:
 *     This is a Java starting code for hw0_1.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw0_1.java
 * Abstract: Takes in a list of numbers. Will then print them out in the order of times it appeared
 * If two are the same then it will print in numerical order.
 * Name: Colton Korhummel
 * Date: 2/9/2024
 */

//I used geekforgeeks and stackoverflow to help with hashmaps like the sorting and iterating through it.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
         * Add your code here
         */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> input = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int current = sc.nextInt();
            map.put(current, map.getOrDefault(current, 0) + 1);
            input.add(current);
        }

        //StackOverflow helped here with the lambda expression
        input.sort((a, b) -> {
            int freq = map.get(a).compareTo(map.get(b));
            if (freq == 0) {
                return a.compareTo(b);
            }
            return freq;
        });



        //I used geekforgeeks to find out how iterate over hashmap
        LinkedHashSet<Integer> frequency = new LinkedHashSet<>(input);
        int lead = 0;
        for (Integer number : frequency) {
            for (int i = 0; i < map.get(number); i++) {
                if(lead == 0){
                    lead++;
                    System.out.print(number);
                    continue;
                } else {
                    System.out.print(" " + number);
                }
                // if(i == 0){
                //     System.out.print(" ");
                // }
                // if(i != map.get(number) - 1){
                //     System.out.print(number + " ");
                // } else {
                //     System.out.print(number);
                // }
            }
        }
    }
}
