import java.util.*;

/* perfect-number-checker
A Perfect Number is a number that is equal to the sum of its proper divisors (excluding itself).
For example, 28 is a Perfect Number because 1 + 2 + 4 + 7 + 14 = 28.
*/

public class Item1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int intNumber = sc.nextInt(), intSum = 0;

        for(int i = 1; i <= intNumber/2; i++)
            if(intNumber % i == 0) intSum += i;

        System.out.println(intNumber == intSum ? "PERFECT number!" : "not a perfect number.");
    }
}
