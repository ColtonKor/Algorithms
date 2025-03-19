/*
 * INSTRUCTION:
 *     This is a Java starting code for hw0_1.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw5_2.java
 * Abstract: This program takes in inputs to simulate a graph. It implements the DFS program so it checks all connected
 * vertices and numbers them based on the numbers. The lower the sooner. 
 * Name: Colton Korhummel
 * Date: 3/8/2024
 */


//I found help on StackOverflow and GeeksforGeeks
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        if(edges > (vertices*(vertices - 1)/2)){
            System.out.println("INVALID");
            return;
        }

        Graph graph = new Graph();
        graph.mark = new int[vertices];
        graph.Edge = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.Edge.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph.Edge.get(start).add(end);
        }
        
        for (int i = 0; i < vertices; i++) {
            graph.Edge.get(i).sort(Integer::compareTo);
        }

        int startVertex = sc.nextInt();
        graph.path(startVertex);
        for (int i = 0; i < vertices; i++) {
            System.out.println("Mark[" + i + "]:" + graph.mark[i]);
        }
        
        System.out.print("Visiting sequence:");
        for (int i = 1; i <= vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (graph.mark[j] == i) {
                    if (i == vertices) {
                        System.out.print(j);
                    } else {
                        System.out.print(j + "->");
                    }
                }
            }
        }
    }


    private static class Graph {
        public ArrayList<ArrayList<Integer>> Edge;
        public int[] mark;
        public int visited = 1;
        //I found similar code for this function on StackOverflow and GeeksforGeeks
        void path(int vertex) {
            mark[vertex] = visited++;
            for (int i = 0; i < Edge.get(vertex).size(); i++) {
                int EdgeVertex = Edge.get(vertex).get(i);
                if (mark[EdgeVertex] == 0) {
                    path(EdgeVertex);
                }
            }
        }
    }
}
