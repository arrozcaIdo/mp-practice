import java.util.*;

public class Item2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt(), temp = n, sum = 0;

        while(temp > 0){
            sum += temp % 10;
            temp /= 10;
        }

        System.out.println(n % sum == 0 ? "Harshad Number" : "NOT a Harshad Number");

    }
}
