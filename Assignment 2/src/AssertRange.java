/*
    Author: Maegan Lucas
    Project: Assignment 2
    Class: SE 320
    Professor: Dr. Akbas
    File: AssertRange.java
*/

import java.util.Scanner;

public class AssertRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number between 0 and 10: ");
        int entry = scanner.nextInt();
        try {
            assert (entry >= 0 && entry <= 10);
            System.out.println("You entered: " + entry);
        } catch (AssertionError error) {
            System.out.print("The entered number is out of range.");
        }
    }
}
