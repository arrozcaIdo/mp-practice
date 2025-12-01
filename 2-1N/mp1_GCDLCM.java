public class mp1_GCDLCM {

    public static void main(String[] args){
        /*
        • Hardcode two integers.
        • Compute their GCD (Greatest Common Divisor) using a loop.
        • Compute their LCM (Least Common Multiple) using the relation:
            LCM = (num1 * num2) / GCD
        • Challenge: Verify results with test numbers.
         */
        int num1 = 36;  // hardcoded
        int num2 = 60;  // hardcoded

        int a = num1;
        int b = num2;

        // Euclidean Algorithm (pure arithmetic)
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        int gcd = a;

        // LCM formula
        int lcm = (num1 * num2) / gcd;

        System.out.println("Numbers: " + num1 + " and " + num2);
        System.out.println("GCD = " + gcd);
        System.out.println("LCM = " + lcm);


    }
}