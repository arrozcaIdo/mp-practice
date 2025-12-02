import java.util.*;

/* harshad-number
A number is Harshad if it is divisible by the sum of its digits.
For example, 18 is a Harshad Number because 18 ÷ (1+8) = 2
*/

public class Item2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt(), sum = 0, temp = n;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        System.out.println(n % sum == 0 ? "HARSHAD!" : "not harshad.");
    }
}
