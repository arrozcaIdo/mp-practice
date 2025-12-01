import java.util.*;

/* twin-primes-of-a-number
Twin primes are two primes that differ by 2
(e.g., (11, 13), (17, 19)).
 */

public class Item7 {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter range (5 10): ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = a; i <= b - 2; i++) {
            if (isPrime(i) && isPrime(i + 2))
                System.out.println("(" + i + ", " + (i + 2) + ")");
        }
    }
}
