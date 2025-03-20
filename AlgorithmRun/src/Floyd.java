import java.util.Scanner;

public class Floyd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[][] Matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Matrix[i][j] = sc.nextInt();
            }
        }

        int[][] PathMatrix = Matrix;
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (PathMatrix[i][k] != -1 && PathMatrix[k][j] != -1) {
                        int newMatrix = PathMatrix[i][k] + PathMatrix[k][j];
                        if (PathMatrix[i][j] == -1) {
                            PathMatrix[i][j] = newMatrix;
                        }
                        if(newMatrix < PathMatrix[i][j]){
                            PathMatrix[i][j] = newMatrix;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0) {
                    System.out.print(PathMatrix[i][j]);
                } else {
                    System.out.print(" " + PathMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}

//Function(W[1..n, 1..n])
//D = W
//for k = 1 k < n
//  for i = 1 i < n
//      for j = 1 j < n
//          D[i,j] = min{D[i,j], D[i,k] + D[k, j]}
//return D