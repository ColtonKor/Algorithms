/*
 * INSTRUCTION:
 *     This is a Java starting code for hw7.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw7_2.java
 * Abstract: This program takes inputs to form a graph. It then uses DFS to search the graph for unconnected pieces. 
 * If there are unconnected pieces it connects them at the lowest value of vertex.
 * Name: Colton Korhummel
 * Date: 4/7/2024
 */

 import java.util.ArrayList;
 import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();

        Graph graph = new Graph();
        graph.Edge = new ArrayList<>();
        graph.mark = new int[vertex];
        graph.newEdges = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            graph.Edge.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph.Edge.get(start).add(end);
        }

        graph.path();
        if (graph.visited < 2){
            System.out.println("No new edge:");
            return;
        }
        for (int i = 0; i < graph.newEdges.size()-1; i++){
            if(i != graph.newEdges.size() - 2){
                System.out.println("Edge: " + graph.newEdges.get(i) + "-" + graph.newEdges.get(i+1));
            } else {
                System.out.print("Edge: " + graph.newEdges.get(i) + "-" + graph.newEdges.get(i+1));
            }
        }
    }

    private static class Graph {
        public ArrayList<ArrayList<Integer>> Edge;
        public int[] mark;
        private int visited = 0;
        private ArrayList<Integer> newEdges;

        void findPath(int vertex) {
            if(mark[vertex] != 0){
                return;
            }
            int min;
            mark[vertex] = visited;
            int current = newEdges.get(visited - 1);
            if(current < vertex){
                min = current;
            } else {
                min = vertex;
            }
            newEdges.set(visited - 1, min);

            for (int i = 0; i < Edge.get(vertex).size(); i++) {
                findPath(Edge.get(vertex).get(i));
            }
        }

        void path() {
            for (int i = 0; i < mark.length; i++) {
                if (mark[i] == 0) {
                    visited++;
                    newEdges.add(i);
                    findPath(i);
                }
            }
        }
    }
}
