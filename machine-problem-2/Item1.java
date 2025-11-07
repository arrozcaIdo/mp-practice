import java.util.*;
//perfect-number-checker

public class Item1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int intNumber = sc.nextInt(), intSum = 0;

        for(int i = 1; i <= intNumber/2; i++)
            if(intNumber % i == 0) intSum += i;

        System.out.println(intNumber == intSum ? "This is a PERFECT number!" : "This is NOT a perfect number.");
    }

}