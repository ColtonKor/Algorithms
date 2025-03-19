/*
 * INSTRUCTION:
 *     This is a Java starting code for hw0_1.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw6_2.java
 * Abstract: This program takes a list of numbers. It then prints them in order but if they are one more than the previous it puts them in a hyphen so 1-5 for all numbers.
 * Name: Colton Korhummel
 * Date: 03/19/2024
 */

//fbhu
 import java.util.Arrays;
 import java.util.Scanner;
 
 public class Main {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int size = sc.nextInt();
         int[] list = new int[size];
         for (int i = 0; i < size; i++) {
             list[i] = sc.nextInt();
         }
         Arrays.sort(list);
         int start = -1;
         for (int i = 0; i < size; i++) {
             if(i != size-1){
                 if(list[i+1] == list[i]+1){
                     if(start == -1){
                         start = i;
                         System.out.print(list[start] + "-");
                     }
                 } else {
                     start = -1;
                     System.out.print(list[i] + " ");
                 }
             } else {
                 System.out.print(list[i]);
             }
         }
     }
 }
 
