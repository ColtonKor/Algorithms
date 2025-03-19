/*
 * INSTRUCTION:
 *     This is a Java starting code for hw0_1.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw0_1.java
 * Abstract: Takes in two lists of numbers and removes the numbers that are duplicated in the two lists.
 * It will then print the numbers in a reverse sorted list.
 * Name: Colton Korhummel
 * Date: 2/9/2024
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
         * Add your code here
         */
        Scanner User = new Scanner(System.in);
        int size = User.nextInt();
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        for(int i = 0; i < size; i++){
          sorted.set(i, User.nextInt());
        }
        size = User.nextInt();
        ArrayList<Integer> unsorted = new ArrayList<Integer>();
        for(int i = 0; i < size; i++){
          int temp = User.nextInt();
          unsorted.set(i, temp);
          if(!sorted.contains(temp)){
            sorted.add(temp);
          }
        }
        for(int i = 0; i < unsorted.size(); i++){
          if(sorted.contains(unsorted.get(i))){
            sorted.remove(unsorted.get(i));
          }
        }
        Collections.sort(sorted, Collections.reverseOrder());
        System.out.print("Answer:");
        if(sorted.size() == 0){
           System.out.print("NONE");
        }
        for(int i = 0; i < sorted.size(); i++){
           if(i == sorted.size() - 1){
                System.out.print(sorted.get(i));
           } else {
                System.out.print(sorted.get(i) + " ");
           }
        }
    }
}

