/**
    Author: Maegan Lucas
    TimeSinceBirth.java
    Assignment 5
    November 27, 2023
    SE 320 - Software Construction
    Dr. Akbas

    Determines the time since birth using the Day class. Using my birthday (02/22/2002) as a test case.

    References:
    [1] "Day.java.html, " SE 320 Canvas,
        https://erau.instructure.com/courses/162522/files/35571513?module_item_id=10025405&fd_cookie_set=1
        (accessed Nov. 27, 2023).
 **/

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TimeSinceBirth {
    public static final Day MAEGAN_LUCAS_BIRTHDAY = new Day(2002, 2, 22);
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
    public static NumberFormat nf = NumberFormat.getInstance(Locale.US);
    public static String todaysDate = df.format(new Date());
    public static Day today = createToday(todaysDate);

    public static void main(String[] args) {
        run();
    }

    /**
        Given today's date as a string, will break date into month,
        day, and year and create a new Day object with these values/
        @param todaysDate a formatted string of today's date
        @return new Day object of today's date
     */
    public static Day createToday(String todaysDate) {
        String[] today = new String[3];
        today[0] = todaysDate.substring(0, 4);
        today[1] = todaysDate.substring(5,7);
        today[2] = todaysDate.substring(8,10);
        int year = Integer.parseInt(today[0]);
        int month = Integer.parseInt(today[1]);
        int day = Integer.parseInt(today[2]);
        return new Day(year, month, day);
    }

    /**
        Prints the number of days from my birthday (Feb. 22, 2002)
        and calls to run the function for user input.
     */
    public static void run() {
        String daysFrom = nf.format(today.daysFrom(MAEGAN_LUCAS_BIRTHDAY));
        System.out.println("DAYS FROM MY BIRTHDAY - FEBRUARY 22, 2002: " + daysFrom);
        daysFrom = daysFromBirthday();
        System.out.println("DAYS FROM YOUR BIRTHDAY: " + daysFrom);
    }

    /**
        Asks user for birthday input and then calculates the number
        of days since that day.
        @return Formatted String of days since given birthday
     */
    public static String daysFromBirthday() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPlease enter the month (mm) of your birthday: ");
        int month = scanner.nextInt();
        System.out.print("Please enter the day (dd) of your birthday: ");
        int day = scanner.nextInt();
        System.out.print("Please enter the year (yyyy) of your birthday: ");
        int year = scanner.nextInt();
        Day birthday = new Day(year, month, day);

        return nf.format(today.daysFrom(birthday));
    }

}
