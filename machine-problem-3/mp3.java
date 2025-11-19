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
                break;


                case 3: System.out.print("Enter first string: ");
                String string1 = sc.nextLine();
                System.out.print("Enter second string: ");
                String string2 = sc.nextLine();
                break;

                case 4: System.out.print("Enter string: ");
                System.out.println("Word count: ");
                break;

                case 5: System.out.print("Enter string: ");
                System.out.println("Character count: ");
                break;

                case 6: System.out.print("Enter text: ");
                String stringText = sc.nextLine();
                System.out.print("Enter substring: ");
                String stringSub = sc.nextLine();


                break;

                case 7: System.out.print("Enter string: ");
                System.out.println("Lowercase: ");
                break;

                case 8: System.out.print("Enter string: ");
                System.out.println("Uppercase: ");
                break;

                case 9: System.out.print("Enter string: ");
                System.out.println("Without vowels: ");
                break;

                case 10: System.out.print("Enter string: ");
                System.out.println("Without consonants: ");
                break;

                case 11: System.out.println("----Thank you for using the String Manipulation Toolkit!----");
                break;

                default:
                    System.out.println("Invalid! Please try again.");
            }

        } while (intChoice != 11);

        sc.close();
    }
}
