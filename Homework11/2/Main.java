/*
 * INSTRUCTION:
 *     This is a Java starting code for hw11.
 *     When you finish the development, commit and push the file to github.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: Main_hw11_2.java
 * Abstract: This program takes a matrix and uses floyd algorithm to find the shortest path through all areas.
 * Name: Colton Korhummel
 * Date: 5/10/2024
 */

import java.util.Scanner;

public class Main {
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
                    //I found this condition on GeeksForGeeks
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
