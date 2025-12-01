import java.util.*;

/* vowel-and-consonant-checker
Create a program that accepts a string and counts how many vowels and consonants it contains.
 */

public class Item11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine().toLowerCase();

        int v = 0, c = 0;

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) v++;
                else c++;
            }
        }

        System.out.println("Vowels: " + v);
        System.out.println("Consonants: " + c);
    }
}
