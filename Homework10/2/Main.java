/*
 * INSTRUCTION:
 *     This is a Java starting code for hw10.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw10_2.java
 * Abstract: This program simulates linear probing and hash storage
 * Name: Colton Korhummel
 * Date: 5/2/2024
 */

 //I found the prime number generator on geeks for geeks.
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.Scanner;
 
 public class Main {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int size = sc.nextInt();
         int commands = sc.nextInt();
         int filled = 0;
 
 
         int[] hash = new int[size];
         Arrays.fill(hash, -1);
 
 
         ArrayList<Integer> commandNumbers = new ArrayList<>();
         ArrayList<String> commandPrompt = new ArrayList<>();
         ArrayList<Integer> inHash = new ArrayList<>();
 
 
         for (int i = 0; i < commands; i++) {
             String command = sc.next();
             commandPrompt.add(command);
             if(command.equals("insert") || command.equals("displayStatus") || command.equals("search")){
                 commandNumbers.add(sc.nextInt());
             }
         }
 
         for (int i = 0; i < commands; i++) {
 
             if(commandPrompt.get(i).equals("insert")){
                 if(hash[commandNumbers.get(0) % size] == -1) {
                     hash[commandNumbers.get(0) % size] = commandNumbers.get(0);
                     filled++;
                 } else {
                     for (int j = commandNumbers.get(0) % size + 1; j != commandNumbers.get(0) % size; j = (j+1)/size) {
                         if(hash[j] == -1){
                             hash[j] = commandNumbers.get(0);
                             filled++;
                             break;
                         }
                     }
                 }
                 inHash.add(commandNumbers.get(0));
                 commandNumbers.remove(0);
                 if(filled > size/2){
                     size = size * 2;
                     size = nextPrime(size);
                     hash = new int[size];
                     Arrays.fill(hash, -1);
                     for (int k = 0; k < inHash.size(); k++) {
                         if(hash[inHash.get(k) % size] == -1) {
                             hash[inHash.get(k) % size] = inHash.get(k);
                         } else {
                             for (int j = inHash.get(k) % size + 1; j != inHash.get(k) % size; j = (j+1)/size) {
                                 if(hash[j] == -1){
                                     hash[j] = inHash.get(k);
                                     break;
                                 }
                             }
                         }
                     }
                 }
             }
 
             if(commandPrompt.get(i).equals("displayStatus")){
                 display(hash, commandNumbers.get(0));
                 commandNumbers.remove(0);
             }
 
             if(commandPrompt.get(i).equals("search")){
                 search(hash, commandNumbers.get(0), size);
                 commandNumbers.remove(0);
             }
 
             if(commandPrompt.get(i).equals("tableSize")){
                 System.out.println(size);
             }
         }
     }
 
     public static void display(int[] hash, int number){
         if(hash[number] == -1){
             System.out.println("Empty");
         } else {
             System.out.println(hash[number]);
         }
     }
 
     public static void search(int[] hash, int number, int size){
         boolean found = false;
         for (int j = number%size; j != number%size - 1; j = (j+1)%size) {
             if(hash[j] == number){
                 found = true;
                 break;
             }
             if(hash[j] == -1){
                 break;
             }
         }
         if(found) {
             System.out.println(number + " Found");
         } else {
             System.out.println(number + " Not Found");
         }
     }
 
     //These following functions I found on GeeksForGeeks to find the next prime number
     static boolean isPrime(int n)
     {
         if (n <= 1) {
             return false;
         }
         if (n <= 3) {
             return true;
         }
         if (n % 2 == 0 || n % 3 == 0) {
             return false;
         }
         for (int i = 5; i * i <= n; i = i + 6) {
             if (n % i == 0 || n % (i + 2) == 0) {
                 return false;
             }
         }
         return true;
     }
     static int nextPrime(int N)
     {
         if (N <= 1) {
             return 2;
         }
         int prime = N;
         boolean found = false;
         while (!found)
         {
             prime++;
             if (isPrime(prime)) {
                 found = true;
             }
         }
         return prime;
     }
 }
 
