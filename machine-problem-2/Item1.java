import java.util.*;

public class Item1 {
    //perfect number checker
    public static void main(String[] args){
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;

        for(int i = 1; i <= n / 2; i++)
            if (n % i == 0) sum += i;

        System.out.println(sum == n ? "[" + n + "]" + " is a PERFECT Number" : "[" + n + "]" + " is NOT Perfect");
    }
}
