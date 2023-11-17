import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/** Author: Maegan Lucas
 *  Localization.java
 *  Assignment 4
 *  November 17, 2023
 *  SE 320 - Software Construction
 *  Dr. Akbas
 *
 *  Format a given number into the UK and US locale formats and parses a given string into a number.
 **/

public class Localization {

    public static void main(String[] args) throws ParseException {
        Locale uk = Locale.UK;
        Locale us = Locale.US;
        double number = 12345.678;

        // Get number in UK locale format with only two digits
        NumberFormat ukNumber = NumberFormat.getNumberInstance(uk);
        ukNumber.setMaximumFractionDigits(2);
        System.out.println("\n12345.678 in UK locale format with only 2 digits after the decimal: " + ukNumber.format(number));

        // Get number in US currency format
        NumberFormat usCurrency = NumberFormat.getCurrencyInstance(us);
        System.out.println("12345.678 in US currency format: " + usCurrency.format(number));

        // Parse number from string
        String numberString = "12,345.678";
        NumberFormat usNumber = NumberFormat.getNumberInstance(us); // Gets normal number format for US locale
        System.out.println("'12,345.678' parsed into UK format: " + ukNumber.parse(numberString));
        System.out.println("'12,345.678 parsed into US format: " + usNumber.parse(numberString));

    }
}
