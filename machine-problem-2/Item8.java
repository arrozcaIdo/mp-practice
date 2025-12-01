import java.util.*;

/* automorphic-number
A number is Automorphic if its
square ends with the number itself (e.g., 76² = 5776).
 */

public class Item8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        long sq = (long) n * n;
        String s = Long.toString(sq);
        String nStr = Integer.toString(n);

        if (s.endsWith(nStr)) System.out.println("Automorphic Number");
        else System.out.println("Not an Automorphic Number");
    }
}
