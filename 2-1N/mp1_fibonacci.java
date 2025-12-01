public class mp1_fibonacci {
    public static void main(String[] args){
        /*
        • Hardcode a limit n.
        • Print the first n Fibonacci numbers using a loop.
        • Challenge: Print the sum of the series.
        */

        int n = 6;
        int first = 0;
        int second = 1;
        int sum = 0;

        System.out.println("Fibonacci Series for " + n + " times:");

        for (int i = 1; i <= n; i ++){
            System.out.print(first + " ");
            sum += first;

            //next number
            int next = first + second;
            first = second;
            second = next;
        }

        System.out.println("\nSum of the sequence: " + sum);


        System.exit(0);
    }
}