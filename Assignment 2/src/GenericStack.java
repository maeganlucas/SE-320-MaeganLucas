/*
    Author: Maegan Lucas
    Project: Assignment 2
    Class: SE 320
    Professor: Dr. Akbas
    File: GenericStack.java
    References:
        ~ https://www.softwaretestinghelp.com/java-generic-array/
*/

import java.lang.reflect.Array;

public class GenericStack<E> {
    private E[] array;
    private int maxSize = 0;

    public GenericStack() {
        array = (E[]) Array.newInstance(Object.class, 20); // https://www.softwaretestinghelp.com/java-generic-array/
        maxSize = 20;
    }

    public GenericStack(int size) {
        array = (E[]) Array.newInstance(Object.class, size); // https://www.softwaretestinghelp.com/java-generic-array/
        maxSize = size;
    }

    public int getSize() {
        return array.length;
    }

    public E peek() {
        E peek = null;
        for(int i = array.length - 1; i >= 0; i--) {
            if (array[i] != null) {
                peek = array[i];
                break;
            }
        }
        return peek;
    }

    public void push(E o) {
        if(array[array.length-1] != null) {
            E[] newArray = (E[]) Array.newInstance(Object.class, (maxSize * 2)); //https://www.softwaretestinghelp.com/java-generic-array;
            maxSize = maxSize * 2;
            int j = 0;
            for(int i = 0; i < array.length; i++) {
                if(array[i] != null) {
                    newArray[j] = array[i];
                    j++;
                }
            }
            array = newArray;
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] == null) {
                array[i] = o;
                break;
            }
        }
    }

    public E pop() {
        E pop = null;
        for(int i = array.length - 1; i >= 0; i--) {
            if(array[i] != null) {
                pop = array[i];
                array[i] = null;
                break;
            }
        }
        return pop;
    }

    public boolean isEmpty() {
        for(int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String arrayString = "";
        for (E element : array) {
            if (element != null) {
                arrayString += String.valueOf(element) + " ";
            }
        }

        return arrayString;
    }

}