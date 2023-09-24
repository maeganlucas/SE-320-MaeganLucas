/*
    Author: Maegan Lucas
    Project: Assignment 1
    Class: SE 320
    Professor: Dr. Akbas
    File: Sum.java
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        int a, b = 0;
        System.out.print("Please enter the first of two integers to add: ");
        a = getInputs();
        System.out.print("Please enter the second of two integers to add: ");
        b = getInputs();
        int sum = sum(a, b);
        System.out.print("Your sum is: " + sum);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int getInputs() {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        try {
            a = scanner.nextInt();
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.print("Input is of the wrong type. Please enter an integer: ");
            return getInputs();
        }
        return a;
    }
}
