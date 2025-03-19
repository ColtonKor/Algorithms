/*
 * INSTRUCTION:
 *     This is a Java starting code for hw0_1.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw6_1.java
 * Abstract: This code uses the Divide and Conquer method to find the minimum number of a list.
 * Name: Colton Korhummel
 * Date: 03/19/2024
 */
//runb
 import java.util.Scanner;

 public class Main {
     static int min = Integer.MAX_VALUE;
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int size = sc.nextInt();
         int[] list = new int[size];
         for (int i = 0; i < size; i++) {
             list[i] = sc.nextInt();
         }
         sum(list, 0, size-1);
         System.out.println(min);
     }
     static void sum(int[] list, int start, int end) {
         if(list[start] < min){
             min = list[start];
         }
         if(start == end){
             return;
         }
         sum(list, start, (start+end)/2);
         sum(list,(start+end)/2+1, end);
     }
 }
