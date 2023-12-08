/**
    Question3.java
    @author Dr. M. Ilhan Akbas, Maegan Lucas

    Given a list of objects and an object, key, returns the first
    index value that the key occurs. If key is not a part of the list,
    returns -1.
 */

public class Question3 {
    /**
        @author Dr. M. Ilhan Akbas, Maegan Lucas
            * Skeleton written by Dr. M. Ilhan Akbas
            * Implementation by Maegan Lucas
        @param list - E[] to search
        @param key - Object E being searched for
        @return Integer where key first occurs, -1 if key does not occur
     */
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
        @author Dr. M. Ilhan Akbas
        @param args
     */
    public static void main(String[] args) {
        Integer[] list = {3, 4, 5, 1, -3, -5, -1,};
        System.out.println(linearSearch(list, 2));
        System.out.println(linearSearch(list, 5));
    }
}
