import java.util.Scanner;

public class mp1_sumofallcubes {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
            /* Hardcode a limit n.
                Print numbers from 1 to n along with their square and cube.
                Challenge: Compute the sum of all cubes.
             */

        int n = 23;
        int sum = 0;

        System.out.println("Printing the square and cube of numbers 1-" + n + ":");

        for(int i = 1; i <= n; i ++){
            int square = i * i;
            int cube = i * i * i;
            sum += cube;
            System.out.println("Number: " + i + "\tSquare: " + square + "\tCube: " + cube);


        }
        System.out.println("sum of all cubes: "+ sum);

        sc.close();
        System.exit(0);
    }
}