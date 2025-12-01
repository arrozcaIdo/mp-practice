import java.util.*;

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

        System.out.println(isKaprekar ? "Kaprekar Number!" : "NOT a Kaprekar number.");
    }
}
