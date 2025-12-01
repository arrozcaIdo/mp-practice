import java.util.*;

/* anagram-checker
Write a program that asks the user for two strings and checks if they are
anagrams of each other (contain the same characters in a different order).
 */

public class Item10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String a = sc.nextLine();
        System.out.print("Enter second string: ");
        String b = sc.nextLine();

        int[] freq = new int[256];

        for (char c : a.toCharArray()) freq[c]++;
        for (char c : b.toCharArray()) freq[c]--;

        for (int x : freq) {
            if (x != 0) {
                System.out.println("Not Anagrams");
                return;
            }
        }
        System.out.println("Anagrams");
    }
}
