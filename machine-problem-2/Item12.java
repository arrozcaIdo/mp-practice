import java.util.*;

/* word-count
Ask the user to input a sentence and count how many words it contains.
 */

public class Item12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String s = sc.nextLine().trim();

        if (s.isEmpty()) {
            System.out.println("Words: 0");
            return;
        }

        String[] words = s.split("\\s+");
        System.out.println("Words: " + words.length);
    }
}
