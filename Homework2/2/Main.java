/*
 * INSTRUCTION:
 *     This is a Java starting code for hw0_1.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw2_2.java
 * Abstract: Takes in a number and a list of strings. It goes through a binary loop and every one in the binary prints its according string.
 * Name: Colton Korhummel
 * Date: 2/14/2024
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0){
            System.out.println("0:0:EMPTY");
            return;
        }
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> binary = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            words.add(sc.next());
            binary.add(0);
        }
        if(words.size() > n){
            System.out.print("INVALID");
            return;
        }

        int loop = (int) Math.pow(2, n);
        int space = 0;
        for(int i = 0; i < loop; i++) {
            System.out.print(i + ":");
            for (int j = 0; j < binary.size(); j++) {
                System.out.print(binary.get(j));
            }
            System.out.print(":");
            for (int j = 0; j < binary.size(); j++) {
                if(!binary.contains(1)){
                    System.out.print("EMPTY");
                    break;
                }
                if(binary.get(j) == 1){
                    if(space == 0){
                        System.out.print(words.get(j));
                        space++;
                    } else {
                        System.out.print(" " + words.get(j));
                    }
                }
            }
            space = 0;
            System.out.print("\n");
            for(int j = binary.size()-1; j >= 0; j--) {
                if(binary.get(j) == 0){
                    binary.set(j, 1);
                    break;
                }else if(binary.get(j) == 1){
                    binary.set(j, 0);
                }
            }
        }
    }
}
