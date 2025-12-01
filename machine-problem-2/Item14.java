import java.util.*;

/* transpose-of-a-matrix
Ask the user to enter a matrix and display its transpose.
 */

public class Item14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt(), c = sc.nextInt();

        int[][] A = new int[r][c];
        int[][] T = new int[c][r];

        System.out.println("Enter matrix:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                A[i][j] = sc.nextInt();

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                T[j][i] = A[i][j];

        System.out.println("Transpose:");
        for (int[] row : T) {
            for (int x : row) System.out.print(x + " ");
            System.out.println();
        }
    }
}
