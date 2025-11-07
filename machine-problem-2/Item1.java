import java.util.*;

public class Item1{
    public static void main (String[] args){
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int intNumber = sc.nextInt(), intSum = 0;

        for(int i = 1; i <= intNumber/2; i++)
            if(intNumber % i == 0) intSum += i;

        System.out.println(intSum == intNumber ? "This is a PERFECT NUMBER!" : "This is NOT a perfect number.");
    }
}