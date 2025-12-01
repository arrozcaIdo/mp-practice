import java.util.*;
/* strong-number
A Strong Number is one
where the sum of the factorial of its digits equals the number itself (e.g., 145 because 1! + 4! + 5!
= 145).
 */

public class Item3 {

    static int fact(int x){
        int f = 1;
        for(int i = 1; i <= x; i++) f *= i;
        return f;
    }

    public static void main(String[] args){
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), temp = n, sum = 0;

        while (temp > 0){
            sum += fact(temp%10);
            temp /= 10;
        }

        System.out.println(sum == n ? "[" + n + "] is a STRONG NUMBER!" : "[" + n + "] is NOT a strong number.");
    }
}
