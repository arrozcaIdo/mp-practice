import java.util.*;

public class mp3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intChoice;

        do {
            System.out.println("----String Manipulation Toolkit----");
            System.out.println("1. Reverse");
            System.out.println("2. Palindrome");
            System.out.println("3. Anagram");
            System.out.println("4. Word Count");
            System.out.println("5. Character Count");
            System.out.println("6. Substring Finder");
            System.out.println("7. Lowercase");
            System.out.println("8. Uppercase");
            System.out.println("9. Remove Vowels");
            System.out.println("10. Remove Consonants");
            System.out.println("11. Exit");

            System.out.print("Choice: ");
            intChoice = sc.nextInt();
            sc.nextLine();

            switch (intChoice){
                case 1: System.out.print("Enter string: ");
                System.out.println("Reversed: ");
                break;

                case 2: System.out.print("Enter string: ");
                // teka lng
                case 3: System.out.print("Enter first string: ");
                String string1 = sc.nextLine();
                System.out.print("Enter second string: ");
                String string2 = sc.nextLine();
                // kulang pa

                default:
                    System.out.println("Invalid! Please try again.");
            }

        } while (intChoice != 11);
    }
}
