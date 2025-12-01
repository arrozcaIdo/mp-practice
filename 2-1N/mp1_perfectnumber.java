public class mp1_perfectnumber {

    public static void main(String[] args){
        /*
        • Hardcode a number.
        • A number is perfect if the sum of its divisors (excluding itself) equals the number.
        • Challenge: Print all perfect numbers between 1 and 500.
        */

        int number = 28;
        int sum = 0;
        int count = 0;




        if (isPerfect(number)){
            System.out.println(number + " is NOT a perfect number");
        } else {
            System.out.println(number + " is a perfect number");
        }

        System.out.println("Printing all perfect numbers from 1-500");
        for (int i = 1; i <= 500; i ++){
            if (isPerfect(i)){
                System.out.print(i + " ");
                count ++;
                if (count % 10 == 0){
                    System.out.print("\n");
                }
            }
        }



        System.exit(0);
    }
    public static boolean isPerfect(int num){
        int sum = 0;
        for (int i = 1; i <= num / 2; i++){
            if (num % i == 0){
                sum += i;
            }
        }
        return sum == num;
    }
}

