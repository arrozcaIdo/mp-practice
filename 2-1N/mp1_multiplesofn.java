import java.util.*;

public class mp1_multiplesofn {
    public static void main(String[] args){
        /*Hardcode a number n.
• Print all multiples of n from 1 to 100.
• Challenge: Print the sum of all multiples.
         */

        Scanner sc = new Scanner(System.in);

        int n = 0;
        int count = 0;
        int sum = 0;

        System.out.println("--MULTIPLES OF N--");

        System.out.print("Enter a number: ");
        if (sc.hasNextInt()){
            n = sc.nextInt();
        } else {
            System.out.println("Invalid input. Please enter an integer");
        }
        sc.nextLine();

        System.out.println("Printing the numbers 1-100 that are multiples of " + n);
        for (int i = 1; i <= 100; i ++){
            if (i % n == 0){
                System.out.print( i + ", ");
                count ++;
                sum += i;
                if (count % 10 == 0)
                    System.out.print("\n");
            }
        }

        System.out.println("Sum of multiples: " + sum);
        sc.close();
        System.exit(0);
    }
}