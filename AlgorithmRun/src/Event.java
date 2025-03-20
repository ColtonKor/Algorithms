import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Event {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        ArrayList<Time> times = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Time tempStart = new Time();
            Time tempEnd = new Time();
            tempStart.time = sc.nextInt();
            tempStart.make = 0;
            tempEnd.time = sc.nextInt();
            tempEnd.make = 1;
            if(tempStart.time < 0 || tempStart.time > 24 || tempEnd.time < 0 || tempEnd.time > 24){
                System.out.println("Invalid");
                return;
            }
            times.add(tempStart);
            times.add(tempEnd);
        }

        times.sort((time1, time2) -> Integer.compare(time1.time, time2.time));

        int max = 0, current = 0;
        for (int i = 0; i < times.size(); i++) {
            if(times.get(i).make == 0){
                current++;
            } else {
                current--;
            }
            max = Math.max(max, current);
        }

        System.out.println("Max events: " + max);
    }

    static class Time {
        public int time;
        public int make;
    }
}
