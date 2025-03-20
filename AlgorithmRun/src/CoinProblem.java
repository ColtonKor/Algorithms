import java.util.ArrayList;
import java.util.Scanner;

public class CoinProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        ArrayList<Integer> coins = new ArrayList<>();
        coins.add(0);
        for (int i = 1; i <= size; i++) {
            coins.add(sc.nextInt());
        }

        ArrayList<Integer> max = new ArrayList<>();
        max.add(0);
        max.add(coins.get(1));

        for (int i = 2; i <= size; i++) {
            max.add(Math.max(max.get(i - 2) + coins.get(i), max.get(i - 1)));
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = size; i > 0; i--) {
            if(max.get(i) != max.get(i-1)){
                result.add(i);
                i--;
            }
        }

        System.out.print("Best set:");
        for (int i = result.size() - 1; i >= 0; i--) {
            if(i == result.size()-1){
                System.out.print(result.get(i));
            } else {
                System.out.print(" " + result.get(i));
            }
        }
        System.out.println("\nMax value:" + max.get(size));
    }
}
