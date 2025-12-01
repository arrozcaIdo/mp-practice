import java.util.*;

/* happy-number
A Happy Number is a number that
eventually reaches 1 when repeatedly replaced by the sum of the squares
of its digits. If it loops endlessly, it is not a Happy Number.
 */

public class Item4 {
        static int sumofSquares(int n){
            int sum = 0;
            while (n > 0) {
                int d = n % 10;
                sum += d * d;
                n /= 10;
            }
            return sum;
        }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int n = sc.nextInt();

            int slow = n, fast = n;
            do {
                slow = sumofSquares(slow);
                fast = sumofSquares(sumofSquares(fast));
            } while (slow != fast);

            System.out.println(slow == 1 ? "[" + n + "] is a Happy Number!" : "[" + n + "] is NOT a happy number.");
    }
}
