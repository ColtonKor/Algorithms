import java.util.*;

public class Topological {
    static boolean acyclic = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        int[] frequency = new int[vertex];
        ArrayList<Graph> graph = new ArrayList<>();

        for (int i = 0; i < edge; i++) {
            Graph temp = new Graph();
            temp.start  = sc.nextInt();
            temp.end = sc.nextInt();
            temp.visited = false;
            graph.add(temp);
        }

        graph.sort((a, b) -> Integer.compare(a.start, b.start));
        printDegree(vertex, frequency, graph);
        path(0, graph);
        if(acyclic){
            System.out.print("No Order:");
            return;
        }
        printOrder(vertex, frequency);
    }

    static class Graph {
        public int start;
        public int end;
        public boolean visited;

    }

    static void path(int vertex, ArrayList<Graph> graph){
        for (int i = 0; i < graph.size(); i++) {
            if(graph.get(i).start == vertex){
                if(graph.get(i).visited){
                    acyclic = true;
                    return;
                }
                graph.get(i).visited = true;
                path(graph.get(i).end, graph);
            }
        }
    }

    static void printOrder(int vertex, int[] frequency){
        ArrayList<Integer> Order = new ArrayList<>();
        System.out.print("Order:");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < frequency.length; j++) {
                if(frequency[j] == i){
                    Order.add(j);
                }
            }
        }
        for (int i = 0; i < Order.size(); i++) {
            if(i == 0){
                System.out.print(Order.get(i));
            } else {
                System.out.print("->" + Order.get(i));
            }
        }
    }
    static void printDegree(int vertex, int[] frequency, ArrayList<Graph> graph){
        for (int i = 0; i < graph.size(); i++) {
            frequency[graph.get(i).end]++;
        }

        for (int i = 0; i < vertex; i++) {
            System.out.println("In-degree[" + i + "]:" + frequency[i]);
        }
    }
}
