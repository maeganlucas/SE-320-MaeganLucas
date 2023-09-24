/*
    Author: Maegan Lucas
    Project: Assignment 1
    Class: SE 320
    Professor: Dr. Akbas
    File: ArrayIndex.java
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayIndex {
    public static void main(String[] args) {
        int[] randomArray = generateArray();
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        System.out.print("Please enter an integer to see the corresponding value within the array: ");
        try {
            index = scanner.nextInt();
            int value = randomArray[index];
            System.out.print("The value is: " + value);
        } catch (InputMismatchException e) {
            System.out.print("Please try again and enter an integer number.");
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Your index is out of bounds. Please try again.");
        }
    }

    public static int[] generateArray() {
        int min = 0;
        int max = 2222;
        int[] randomArray = new int[100];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        return randomArray;
    }
}

