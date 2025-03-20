import java.util.Arrays;
import java.util.Scanner;

public class SortingUsingHyphen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);
        int start = -1;
        for (int i = 0; i < size; i++) {
            if(i != size-1){
                if(list[i+1] == list[i]+1){
                    if(start == -1){
                        start = i;
                        System.out.print(list[start] + "-");
                    }
                } else {
                    start = -1;
                    System.out.print(list[i] + " ");
                }
            } else {
                System.out.print(list[i]);
            }
        }
    }
}
