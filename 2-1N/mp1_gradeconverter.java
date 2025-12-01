import java.util.*;

public class mp1_gradeconverter {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        /*
        Hardcode a numerical grade (0–100).
        Convert to letter grade using conditionals:
            A (90–100), B (80–89), C (70–79), D (60–69), F (<60).
        Challenge: Print remarks (e.g., “Excellent”, “Needs Improvement”).
         */

        int grade = 98;  // You can replace this with user input if needed

        if (grade >= 90 && grade <= 100) {
            System.out.println("Grade: A (Excellent!)");
        } else if (grade >= 80 && grade <= 89) {
            System.out.println("Grade: B (Well Done)");
        } else if (grade >= 70 && grade <= 79) {
            System.out.println("Grade: C (Fair)");
        } else if (grade >= 60 && grade <= 69) {
            System.out.println("Grade: D (Needs Improvement)");
        } else if (grade >= 0 && grade < 60) {
            System.out.println("Grade: F (Failed)");
        } else {
            System.out.println("Invalid grade entered.");
        }

        sc.close();
        System.exit(0);
    }
}