import java.util.*;

/* kaprekar-number
 A number is Kaprekar if the
square of the number can be split into two parts that add up to the original number.
For example, 45² = 2025 → 20 + 25 = 45.
 */

public class Item5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        long sq = (long) n * n;
        String s = Long.toString(sq);

        boolean isKaprekar = false;

        for (int i = 1; i < s.length(); i++) {
            long left = Long.parseLong(s.substring(0, i));
            long right = Long.parseLong(s.substring(i));

            if (left + right == n) {
                isKaprekar = true;
                break;
            }
        }

        System.out.println(isKaprekar ? "[" + n + "] is a KAPREKAR Number!" : "[" + n + "] is NOT a kaprekar number.");
    }
}
