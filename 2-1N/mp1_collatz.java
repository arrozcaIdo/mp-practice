import java.util.Scanner;

public class mp1_collatz {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       /* int num = 12;

        int a = 15;
        int b = 4;
        int result = a/b;

        System.out.println(result);

        System.out.println("the number is " + num + " ya");



        System.out.println("six seven ! !");
        System.out.println("sybau !");
        System.out.println("erm what the helly");

    */

        int userNumber = 0;
        int count = 0;
        int number;



        System.out.print("Enter a number: ");
        if (scanner.hasNextInt()) {
            userNumber = scanner.nextInt();
        } else{
            System.out.println("Please enter a valid integer.");
        }
        scanner.nextLine(); //input buffer

        number = userNumber;

        //collatz
        while (userNumber != 1){
            if (userNumber % 2 == 0) {
                System.out.print(userNumber + " is even --> " + userNumber + "/2 = ");
                userNumber = userNumber / 2;
                System.out.println(userNumber);
                count++;
            } else{
                System.out.print(userNumber + " is odd --> " + "( " + userNumber + " * 3) + 1 = ");
                userNumber = (userNumber * 3) + 1;
                System.out.println(userNumber);
                count++;
            }
        }

        System.out.println("\n" + number + " has " + count + " iterations !");

        scanner.close();
    }
}