/*
 * INSTRUCTION:
 *     This is a Java starting code for hw0_1.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw2_1.java
 * Abstract: Take many inputs that simulate a weighted directional grapgh. We then print out the adjacency list 
 * with an extra step where it prints out the edge it reaches in numerical order.
 * Name: Colton Korhummel
 * Date: 2/16/2024
 */

 import java.util.ArrayList;
 import java.util.Scanner;
 
 public class Main {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int vertices = sc.nextInt();
         if(vertices < 1 || vertices > 50){
             System.out.println("Invalid graph.");
             return;
         }
         int edges = sc.nextInt();
         if(edges > (vertices)*(vertices-1)){
             System.out.println("Invalid graph.");
             return;
         }
         ArrayList<Edge> edge = new ArrayList<>();
         for (int i = 0; i < edges; i++) {
             Edge temp = new Edge();
             temp.start = sc.nextInt();
             temp.end = sc.nextInt();
             temp.weight = sc.nextInt();
             if (temp.start < 0 || temp.end < 0 || temp.start >= vertices || temp.end >= vertices) {
                 System.out.println("Invalid graph.");
                 return;
             }
             for (int j = 0; j < edge.size(); j++) {
                 if(edge.get(j).start == temp.start && edge.get(j).end == temp.end){
                     System.out.println("Invalid graph.");
                     return;
                 }
             }
             edge.add(temp);
         }
 
         edge.sort((end1, end2) -> Integer.compare(end1.end, end2.end));
 
         for(int i = 0; i < vertices; i++) {
             System.out.print(i);
             for (int j = 0; j < edge.size(); j++) {
                 if(edge.get(j).start == i){
                     System.out.print("->"+edge.get(j).end+","+edge.get(j).weight);
                 }
             }
             if(i != vertices-1){
                 System.out.println();
             }
         }
     }
     static class Edge {
         public int start;
         public int end;
         public int weight;
 
     }
 }
 
