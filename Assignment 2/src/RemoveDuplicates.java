/*
    Author: Maegan Lucas
    Project: Assignment 2
    Class: SE 320
    Professor: Dr. Akbas
    File: RemoveDuplicates.java
*/

import java.util.ArrayList;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);
        ArrayList<Integer> newList = removeDuplicates(list);
        System.out.print(newList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();
        ArrayList<E> seen = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!seen.contains(list.get(i))) {
                seen.add(list.get(i));
                newList.add(list.get(i));
            }
        }

        return newList;
    }
}
