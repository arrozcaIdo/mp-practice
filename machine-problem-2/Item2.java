import java.util.*;
//harshad-number

public class Item2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt(), sum = 0, temp = n;

        while(temp > 0){
            sum += temp%10;
            temp /= 10;
        }
        System.out.println(n % sum == 0 ? "Harshad!" : "NOT Harshad.");
    }

}