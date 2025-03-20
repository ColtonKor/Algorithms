import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        Graph graph = new Graph();
        graph.mark = new int[vertices];
        graph.adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph.adjList.get(start).add(end);
            Collections.sort(graph.adjList.get(start));
        }

        int startVertex = sc.nextInt();
        graph.dfs(startVertex);
//        graph.print();

        for (int i = 0; i < graph.mark.length; i++) {
            System.out.println("Mark[" + i + "]:" + graph.mark[i]);
        }
        System.out.print("Visiting sequence:");
        for (int i = 1; i <= graph.mark.length; i++) {
            for (int j = 0; j < graph.mark.length; j++) {
                if (graph.mark[j] == i) {
                    if (i == graph.mark.length) {
                        System.out.print(j);
                    } else {
                        System.out.print(j + "->");
                    }
                }
            }
        }
    }

    private static class Graph {
        public ArrayList<ArrayList<Integer>> adjList;
        public int[] mark;
        public int markCounter = 1;
        void dfs(int vertex) {
            mark[vertex] = markCounter++;
            for (int i = 0; i < adjList.get(vertex).size(); i++) {
                int adjVertex = adjList.get(vertex).get(i);
                if (mark[adjVertex] == 0) {
                    dfs(adjVertex);
                }
            }
        }
    }
}