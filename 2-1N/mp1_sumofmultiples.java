import java.util.Scanner;

public class mp1_sumofmultiples {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
            /* Hardcode a number n.
               Compute the sum of all numbers from 1 to 100 that are divisible by n.
               Challenge: Print the average of these numbers.
             */

        int n = 23;
        int sum = 0;
        int count = 0;

        System.out.println("Numbers from 1-100 that are divisible to " + n + ":");

        for (int i = 1; i <= 100; i ++){
            if (i % n == 0){
                System.out.print(i + ", ");
                sum += i;
                count ++;
                if (count % 5 == 0){
                    System.out.print("\n");
                }

            }
        }
        int average = sum / count;
        System.out.println("\nAverage of multiples: " + average);



        sc.close();
        System.exit(0);
    }
}