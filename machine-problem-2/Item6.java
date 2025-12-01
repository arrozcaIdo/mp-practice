import java.util.*;

/* prime-factors-of-a-number
Ask the user to enter a number and display all its prime factors.
For example, the prime factors of 84 are 2, 2, 3, 7.
 */

public class Item6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.print("Prime Factors: ");
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }
        if (n > 1) System.out.print(n);

    }
}
