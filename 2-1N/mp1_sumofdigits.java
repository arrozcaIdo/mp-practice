public class mp1_sumofdigits {

    public static void main(String[] args){

        /* Hardcode a number.
        Use a loop with modulo/division to compute the sum of its digits.
        Challenge: Also compute the product of its digits.
         */

        int number = 3469;
        int temp = number;
        int sum = 0;
        int product = 1;

        while (temp != 0){
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }

        System.out.println("Number: " + number);
        System.out.println("Sum of digits: " + sum);
        System.out.println("Product of digits: " + product);


        System.exit(0);
    }
}