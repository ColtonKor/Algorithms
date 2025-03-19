/*
 * INSTRUCTION:
 *     This is a Java starting code for hw5_1.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw5_1.java
 * Abstract: This code takes in an Integer Input and uses recursion to then reverse all the numbers exterminating leading and trailing zeros.
 * Name: Colton Korhummel
 * Date: 3/8/2024
 */

 import java.util.Scanner;

 public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int check = 0;
        if (number < 0) {
            number = -number;
            check++;
        }
        int reversedNumber = Reverse(number, 0);
        if (check == 1) {
            reversedNumber = -reversedNumber;
        }
        System.out.println(reversedNumber);
     }
 
    static int Reverse(int number, int reversed) {
        if (number == 0) {
            return reversed;
        } else {
            return Reverse(number/10, (reversed * 10) + (number%10));
        }
    }
 }
