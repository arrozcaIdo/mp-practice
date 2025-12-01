import java.util.*;

public class Item5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        long sq = (long) n * n;
        String s = Long.toString(sq);

        for (int i = 1; i < s.length(); i++) {
            long left = Long.parseLong(s.substring(0, i));
            long right = Long.parseLong(s.substring(i));

            if (right != 0 && left + right == n) {
                System.out.println("Kaprekar Number");
                return;
            }
        }

        System.out.println("Not a Kaprekar Number");
    }
}
