//I used tutorialspoint for the time
import java.util.*;

public class SortingPerformance {
    static ArrayList<sortTime> ranking = new ArrayList<>();
    static double insertionMilliseconds = 0;
    static double quickMilliseconds = 0;
    static double medianMilliseconds = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Input Size: ");
        int size = sc.nextInt();
        System.out.println("========== Select Option for Input Numbers ==========");
        System.out.println("\t1. Ascending Order");
        System.out.println("\t2. Descending Order");
        System.out.println("\t3. Random Order");
        System.out.print("Choose option: ");
        int option = sc.nextInt();


        System.out.print("\nRun insertion sort(y/n)? ");
        String insert = sc.next();

        System.out.print("Run quick sort with Median of Three(y/n)? ");
        String quick = sc.next();

        Integer[] list = GenerateNumbers(option, size);
        Integer[] plainQuick = list;
        Integer[] insertionsorted = list;
        Integer[] medianOfThree = list;

        if(size <= 20){
            System.out.print("\nNumbers generated: ");
            for (int i = 0; i < list.length; i++) {
                System.out.print(list[i] + " ");
            }

            System.out.print("\nQuick sort result: ");
        }
        long startTime = System.nanoTime();
        QuickSort(plainQuick, 0, plainQuick.length-1);
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;
        quickMilliseconds = timeElapsed/1_000_000.0;

        sortTime temp = new sortTime();
        temp.TypeSort = "Quick sort";
        temp.milliseconds = quickMilliseconds;
        ranking.add(temp);
        if(size <= 20) {
            for (int i = 0; i < plainQuick.length; i++) {
                System.out.print(plainQuick[i] + " ");
            }
        }

        if(insert.equals("y")) {
            if(size <= 20) {
                System.out.print("\nInsertion sort result: ");
            }
            long startInsertTime = System.nanoTime();
            InsertionSort(insertionsorted);

            long endInsertTime = System.nanoTime();
            long timeInsertElapsed = endInsertTime - startInsertTime;
            insertionMilliseconds = timeInsertElapsed/1_000_000.0;

            sortTime insertTemp = new sortTime();
            insertTemp.TypeSort = "Insertion sort";
            insertTemp.milliseconds = insertionMilliseconds;
            ranking.add(insertTemp);

            if(size <= 20) {
                for (int i = 0; i < list.length; i++) {
                    System.out.print(list[i] + " ");
                }
            }
        }

        if(quick.equals("y")){
            if(size <= 20) {
                System.out.print("\nQuick sort (Median of Three): ");
            }
            long startMedianTime = System.nanoTime();

            QuickSortMedian(medianOfThree, 0, medianOfThree.length-1);

            long endMedianTime = System.nanoTime();
            long timeElapsedMedian = endMedianTime - startMedianTime;
            medianMilliseconds = timeElapsedMedian/1_000_000.0;

            sortTime tempMedium = new sortTime();
            tempMedium.TypeSort = "Quick sort (Median of Three)";
            tempMedium.milliseconds = medianMilliseconds;
            ranking.add(tempMedium);

            if(size <= 20) {
                for (int i = 0; i < medianOfThree.length; i++) {
                    System.out.print(medianOfThree[i] + " ");
                }
            }
        }

        System.out.println("\n==================== Execution Result ====================");

        System.out.printf("Quick sort: %.7f milliseconds\n", quickMilliseconds);

        if(insert.equals("y")) {
            System.out.printf("Insertion sort: %.7f milliseconds\n", insertionMilliseconds);
        }

        if(quick.equals("y")){
            System.out.printf("Quick sort (Median of Three): %.7f milliseconds\n", medianMilliseconds);
        }

        System.out.println("============================================================");

        System.out.println("\n========================== Ranking =========================");
        ranking.sort((a, b) -> Double.compare(a.milliseconds, b.milliseconds));
        for (int i = 0; i < ranking.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + ranking.get(i).TypeSort);
        }
        System.out.println("============================================================");

    }

    static class sortTime{
        public double milliseconds;
        public String TypeSort;
    }

    static Integer[] GenerateNumbers(int type, int size){
        Integer[] list = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list[i] = random.nextInt(size * 10);
        }
        if(type == 1){
            Arrays.sort(list);
        } else if(type == 2){
            Arrays.sort(list, Collections.reverseOrder());
        }
        return list;
    }

    static void InsertionSort(Integer[] list){
        int v, j;
        for (int i = 1; i < list.length; i++) {
            v = list[i];
            j = i - 1;
            while(j >= 0 && list[j] >= v){
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = v;
        }
    }
    static void QuickSort(Integer[] list, int l, int r){
        if(l < r) {
            int s = Partition(list, l, r);
            QuickSort(list, l, s-1);
            QuickSort(list, s+1, r);
        }
    }
    static int Partition(Integer[] list, int l, int r){
        int p = list[l];
        int i = l;
        int j = r + 1;

        while (true) {
            do {
                i++;
            } while (i <= r && list[i] < p);

            do {
                j--;
            } while (j >= l && list[j] > p);

            if (i >= j) {
                break;
            }
            swap(list, i, j);
        }
        swap(list, l, j);
        return j;
    }

    static int MedianPartition(Integer[] list, int l, int r){
        int mid = (l + r) / 2;
        if(list[l] > list[mid]){
            swap(list, l, mid);
        }
        if(list[mid] > list[r]){
            swap(list, mid, r);
        }
        if(list[r] < list[l]){
            swap(list, l, r);
        }

        swap(list, l + 1, mid);
        int p = list[l + 1];
        int i = l + 1;
        int j = r;

        while (true) {
            do {
                i++;
            } while (i <= r && list[i] < p);

            do {
                j--;
            } while (j >= l + 1 && list[j] > p);

            if (i >= j) {
                break;
            }
            swap(list, i, j);
        }
        swap(list, l + 1, j);
        return j;
    }

    static void QuickSortMedian(Integer[] list, int l, int r){
        if(l < r) {
            int s = MedianPartition(list, l, r);
            QuickSortMedian(list, l, s-1);
            QuickSortMedian(list, s+1, r);
        }
    }

    static void swap(Integer[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
