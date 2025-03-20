import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

//GeeksforGeeks gave me a basic outline for the BFS function.
public class BFS {
    static ArrayList<String> connected = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        for (int i = 0; i < vertex; i++) {
            String name = sc.next();
            graph.put(name, new ArrayList<>());
        }
        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {
            String start = sc.next();
            String end = sc.next();
            graph.get(start).add(end);
        }
        String start = sc.next();
        int connections = sc.nextInt();
        path(graph, start, connections);

        if(connected.isEmpty()){
            System.out.print("NONE");
            return;
        }

        connected.sort((s1, s2) -> s1.charAt(0) - s2.charAt(0));
        for (int i = 0; i < connected.size(); i++) {
            if(i == 0){
                System.out.print(connected.get(i));
            } else {
                System.out.print("," + connected.get(i));
            }
        }
    }
    static void path(HashMap<String, ArrayList<String>> graph, String start, int degree){
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        queue.add(start);
        visited.put(start, 0);

        //I found the basic outline of this loop on GeeksforGeeks.
        while (!queue.isEmpty()) {
            String current = queue.remove();
            int currentDegree = visited.get(current);
            if (currentDegree == degree) {
                connected.add(current);
            }

            for (int i = 0; i < graph.get(current).size(); i++) {
                if (!visited.containsKey(graph.get(current).get(i))) {
                    visited.put(graph.get(current).get(i), currentDegree + 1);
                    queue.add(graph.get(current).get(i));
                }
            }
        }
    }
}
