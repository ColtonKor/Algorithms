import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> input = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int current = sc.nextInt();
            map.put(current, map.getOrDefault(current, 0) + 1);
            input.add(current);
        }

        //StackOverflow helped here with the lambda expression
        input.sort((num, amount) -> {
            int freq = map.get(num).compareTo(map.get(amount));
            if (freq == 0) {
                return num.compareTo(amount);
            }
            return freq;
        });




        //I used geekforgeeks to find out how iterate over hashmap
        LinkedHashSet<Integer> frequency = new LinkedHashSet<>(input);
        int lead = 0;
        for (Integer number : frequency) {
            for (int i = 0; i < map.get(number); i++) {
                if(lead == 0){
                    lead++;
                    System.out.print(number);
                    continue;
                }
                if(i == 0){
                    System.out.print(" ");
                }
                if(i != map.get(number) - 1){
                    System.out.print(number + " ");
                } else {
                    System.out.print(number);
                }
            }
        }
    }
}