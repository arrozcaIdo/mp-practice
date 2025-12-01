import java.util.*;

public class mp1_numberguessing {

    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);

        /*• Hardcode a "secret number".
            Simulate guessing attempts (e.g., int guess1, int guess2, int guess3).
            Use conditionals to print if each guess is too high, too low, or correct.
            Challenge: Stop checking once the correct guess is found.
         */

        int secretNumber = 67;

        int guess =0;
        int count;
        System.out.println("--NUMBER GUESSING GAME--");

        for (count = 1; count <= 3; ++count ){
            System.out.print("Guess the number (Attempt " + count + "): ");
            if (sc.hasNextInt()){
                guess = sc.nextInt();
            } else {
                System.out.println("Invalid integer. Please enter valid input.");
            }
            sc.nextLine(); //input buffer

            if (guess > secretNumber){
                System.out.println("Your guess is too high.");
            } else if (guess < secretNumber) {
                System.out.println("Your guess is too low");
            } else {
                System.out.println("Wow that's correct");
                System.exit(0);
            }

        }

        System.out.println("You've ran out of attempts thank's for using the program haha bobo");
        System.exit(0);



        sc.close();
    }
}
