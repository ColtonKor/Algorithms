import java.util.ArrayList;
import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0){
            System.out.println("0:0:EMPTY");
            return;
        }
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> binary = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            words.add(sc.next());
            binary.add(0);
        }
        if(words.size() > n){
            System.out.print("INVALID");
            return;
        }

        int loop = (int) Math.pow(2, n);
        for(int i = 0; i < loop; i++) {
            System.out.print(i + ":");
            for (int j = 0; j < binary.size(); j++) {
                System.out.print(binary.get(j));
            }
            System.out.print(":");
            for (int j = 0; j < binary.size(); j++) {
                if(!binary.contains(1)){
                    System.out.print("EMPTY");
                    break;
                }
                if(binary.get(j) == 1){
                    if(binary.size()-1 == j){
                        System.out.print(words.get(j));
                    } else {
                        System.out.print(words.get(j) + " ");
                    }
                }
            }
            System.out.print("\n");
            for(int j = binary.size()-1; j >= 0; j--) {
                if(binary.get(j) == 0){
                    binary.set(j, 1);
                    break;
                }else if(binary.get(j) == 1){
                    binary.set(j, 0);
                }
            }
        }
    }
}
