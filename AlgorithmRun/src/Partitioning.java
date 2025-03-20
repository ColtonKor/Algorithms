import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Partitioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> third = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int temp = sc.nextInt();
            first.add(temp);
            third.add(temp);
        }

        for (int i = 0; i < size; i++) {
            if(first.get(i) < 0){
                continue;
            }
            for (int j = size-1; j > i; j--) {
                if(first.get(j) < 0){
                    Collections.swap(first, i, j);
                    break;
                }
            }
        }


        int x = third.size()-1;
        for (int i = third.size()-1; i >= 0; i--) {
            if(third.get(x) >= 0){
                x--;
                continue;
            }
            if(third.get(i) >= 0){
                Collections.swap(third, x, i);
                x--;
            }
        }

        for (int i = 0; i < first.size(); i++) {
            if(i == 0){
                System.out.print(first.get(i));
            } else {
                System.out.print(" " + first.get(i));
            }
        }
        System.out.println();

        for (int i = 0; i < third.size(); i++) {
            if(i == 0){
                System.out.print(third.get(i));
            } else {
                System.out.print(" " + third.get(i));
            }
        }
    }
}
