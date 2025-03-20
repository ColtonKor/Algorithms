import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TSP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edges = sc.nextInt();
        if(vertex > 8 || edges > (vertex*(vertex-1))/2){
            System.out.println("INVALID");
            return;
        }
        int[][] graph = new int[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                graph[i][j] = 0;
            }
        }
        for (int i = 0; i < edges; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x > vertex-1 || y > vertex-1){
                System.out.println("INVALID");
                return;
            }
            graph[x][y] = sc.nextInt();
        }
        int starting = sc.nextInt();
        boolean[] visit = new boolean[vertex];
        visit[starting] = true;
        String tempPath = starting + "";
        boolean multiple = false;
        ArrayList<Map> mapCost = new ArrayList<>();
        path(starting, starting, vertex, 1, 0, graph, visit, tempPath, mapCost);
        mapCost.sort(Comparator.comparingInt(a -> a.cost));
        for (int i = 1; i < mapCost.size(); i++) {
            if(mapCost.get(i).cost == mapCost.get(0).cost){
                multiple = true;
                break;
            }
        }
        if(mapCost.isEmpty()){
            System.out.print("Path:\nCost:-1");
        } else if(multiple){
            System.out.print("Multiple Paths\nCost:" + mapCost.get(0).cost);
        } else {
            System.out.println("Path:" + mapCost.get(0).path + "\nCost:" + mapCost.get(0).cost);
        }

    }

    static class Map {
        public String path;
        public int cost;
    }

    //StackOverflow helped me with this function.
    static void path(int start, int current, int vertex, int count, int cost, int[][] graph, boolean[] visit, String path, ArrayList<Map> mapCost){
        if (count == vertex) {
            if (graph[current][start] > 0) {
                Map newPath = new Map();
                newPath.cost = cost + graph[current][start];
                newPath.path = path + "->" + start;
                mapCost.add(newPath);
            }
            return;
        }

        for (int i = 0; i < vertex; i++) {
            if (!visit[i] && graph[current][i] > 0) {
                visit[i] = true;
                path(start, i, vertex, count + 1, cost + graph[current][i], graph, visit, path + "->" + i, mapCost);
                visit[i] = false;
            }
        }
    }
}