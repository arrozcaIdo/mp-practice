public class mp1_leapyear {
    public static void main(String[] args){
        /*• Hardcode a year.
            Print if it is a leap year or not using conditional logic.
            Challenge: Print all leap years between 1900 and 2100.

         */
        int year = 1996;

        if (year % 4 == 0){
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year");
        }

        //all leap year 1990-2100
        System.out.println("Printing all Leap Years from 1900 to 2100");
        int counter = 0;
        for (int leapYear = 1900; leapYear <= 2100; leapYear ++){
            if (leapYear % 4 == 0){
                System.out.print(leapYear + ", ");
                counter ++;
                if(counter % 10 == 0){
                    System.out.print("\n");
                }
            }
        }




    }
}