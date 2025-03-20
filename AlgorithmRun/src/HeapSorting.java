import java.util.ArrayList;
import java.util.Scanner;

public class HeapSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();


        MaxHeap mine = new MaxHeap();
        mine.heap.add(-1);
        for (int i = 0; i < size; i++) {
            mine.heap.add(sc.nextInt());
        }


        int commands = sc.nextInt();
        ArrayList<String> commandList = new ArrayList<>();
        ArrayList<Integer> commandNumbers = new ArrayList<>();


        for (int i = 0; i < commands; i++) {
            String temp = sc.next();
            commandList.add(temp);
            if(temp.equals("insert")){
                commandNumbers.add(sc.nextInt());
            }
        }

        if(!mine.isHeap()){
            System.out.println("This is NOT a heap.");
            mine.swap(1, mine.heap.size()-1);
            mine.heapSort(1);
        } else {
            System.out.println("This is a heap.");
        }

        for (int i = 0; i < commandList.size(); i++) {
            if(commandList.get(i).equals("display")){
                mine.display();
            }

            if(commandList.get(i).equals("displayMax")){
                mine.displayMax();
            }

            if(commandList.get(i).equals("deleteMax")){
                mine.deleteMax();
            }

            if(commandList.get(i).equals("insert")){
                mine.insert(commandNumbers.get(0));
                commandNumbers.remove(0);
            }
        }
    }

    static class MaxHeap {
        public ArrayList<Integer> heap;
        public MaxHeap(){
            heap = new ArrayList<>();
        }
        public void heapSort(int index) {
            int leftIndex = index*2;
            int rightIndex = leftIndex+1;

            boolean leftExists = leftIndex < heap.size();
            boolean rightExists = rightIndex < heap.size();
            int middle = heap.get(index);

            if(leftExists && rightExists) {
                int left = heap.get(leftIndex);
                int right = heap.get(rightIndex);
                if (middle < left && middle < right) {
                    if (left > right) {
                        swap(index, leftIndex);
                        heapSort(leftIndex);
                    } else {
                        swap(index, rightIndex);
                        heapSort(rightIndex);
                    }
                } else if (middle < left) {
                    swap(index, leftIndex);
                    heapSort(leftIndex);
                } else if (middle < right) {
                    swap(index, rightIndex);
                    heapSort(rightIndex);
                }
            } else if (leftExists) {
                int left = heap.get(leftIndex);
                if (middle < left) {
                    swap(index, leftIndex);
                }
            }
        }
        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        public void display(){
            for (int j = 1; j < heap.size(); j++) {
                System.out.print(heap.get(j) + " ");
            }
            System.out.println();
        }

        public void displayMax(){
            System.out.println(heap.get(1));
        }

        public void deleteMax(){
            swap(1, heap.size()-1);
            heap.remove(heap.size()-1);
            heapSort(1);
        }
        public void insert(int value){
            heap.add(value);
            int current = heap.size() - 1;
            //I found a similar while loop on StackOverflow
            while (heap.get(current) > heap.get(current / 2)) {
                if(current <= 1){
                    break;
                }
                swap(current, current / 2);
                current = current / 2;
            }
        }

        public boolean isHeap() {
            for (int i = 1; i < heap.size()/2; i++) {
                if(heap.get(i) < heap.get(i*2) || heap.get(i) < heap.get((i*2)+1)){
                    return false;
                }
            }
            return true;
        }
    }
}
