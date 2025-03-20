import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Account> acc = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Account temp = new Account();
            temp.name = sc.next();
            temp.priority = sc.nextInt();
            acc.add(temp);
        }

        acc.sort((p1, p2) -> Integer.compare(p1.priority, p2.priority));

        int act = sc.nextInt();
        ArrayList<Command> commands = new ArrayList<>();
        ArrayList<Account> temporary = new ArrayList<>();

        for (int i = 0; i < act; i++) {
            Command temp = new Command();
            temp.com = sc.next();
            if(temp.com.equals("Add")){
                Account aTemp = new Account();
                aTemp.name = sc.next();
                aTemp.priority = sc.nextInt();
                temporary.add(aTemp);
            }
            commands.add(temp);
        }
        for (int i = 0; i < commands.size(); i++) {
            if(commands.get(i).com.equals("List")){
                for (int j = 0; j < acc.size(); j++) {
                    System.out.println(acc.get(j).name + " " + acc.get(j).priority);
                }
            } else if(commands.get(i).com.equals("Add")){
                System.out.println(temporary.get(0).name + " added");
                acc.add(temporary.get(0));
                temporary.remove(0);
                acc.sort((p1, p2) -> Integer.compare(p1.priority, p2.priority));
            } else {
                System.out.println(acc.get(0).name + " deleted");
                acc.remove(0);
            }
        }
    }

    static class Account {
        public String name;
        public int priority;
    }

    static class Command {
        public String com;
    }
}
