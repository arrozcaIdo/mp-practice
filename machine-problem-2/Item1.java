import java.util.*;

public class Item1{
    public static void main(String[] args){
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;

        for(int i = 1; i <= n/2; i++)
            if(n % i == 0) sum += i;

        System.out.println(sum == n ? "PERFECT NUMBER!" : "not a perfect number." );
    }
}