import java.util.Scanner;

public class Recursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int check = 0;
        if (number < 0) {
            number = -number;
            check++;
        }
        int reversedNumber = Reverse(number, 0);
        if (check == 1) {
            reversedNumber = -reversedNumber;
        }
        System.out.println(reversedNumber);
    }

    static int Reverse(int number, int reversed) {
        if (number == 0) {
            return reversed;
        } else {
            return Reverse(number/10, (reversed * 10) + (number%10));
        }
    }
}
