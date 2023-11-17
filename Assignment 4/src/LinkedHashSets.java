/** Author: Maegan Lucas
 *  LinkedHashSet.java
 *  Assignment 4
 *  November 17, 2023
 *  SE 320 - Software Construction
 *  Dr. Akbas
 *
 *  Using two given lists, this program will create these lists and determine their union, intersection, and difference.
 **/

import java.util.LinkedHashSet;

public class LinkedHashSets {
    public static void main(String[] args) {
        LinkedHashSet<String> list1 = new LinkedHashSet<>();
        LinkedHashSet<String> list2 = new LinkedHashSet<>();
        createList1(list1);
        createList2(list2);
        System.out.println("\nUnion of List1 and List2: " + findUnion(list1, list2));
        System.out.println("Intersection of List1 and List2: " + findIntersection(list1, list2));
        System.out.println("Difference of List1 and List2: " + findDifference(list1, list2));
        System.out.println("Difference of List2 and List1:" + findDifference(list2, list1));
    }

    /**
     * Method: createList1
     * @param list1 - An empty LinkedHashSet of Strings
     * Adds the given list items from the assignment description into list1.
     */
    public static void createList1(LinkedHashSet<String> list1) {
        list1.add("George");
        list1.add("Jim");
        list1.add("John");
        list1.add("Blake");
        list1.add("Kevin");
        list1.add("Michael");
    }

    /**
     * Method: createList2
     * @param list2 - An empty LinkedHashSet of Strings
     * Adds the given list items from the assignment description into list2.
     */
    public static void createList2(LinkedHashSet<String> list2) {
        list2.add("George");
        list2.add("Katie");
        list2.add("Kevin");
        list2.add("Michelle");
        list2.add("Ryan");
    }

    /**
     * Method: findUnion
     * @param list1 - A non-empty LinkedHashSet of Strings
     * @param list2 - A non-empty LinkedHashSet of Strings
     * @return A LinkedHashSet of Strings, list3, that contains elements of both list1 and list2 parameters.
     */
    public static LinkedHashSet<String> findUnion(LinkedHashSet<String> list1, LinkedHashSet<String> list2) {
        LinkedHashSet<String> list3 = (LinkedHashSet<String>) list1.clone();
        list3.addAll(list2);
        return list3;
    }

    /**
     * Method: findIntersection
     * @param list1 - A non-empty LinkedHashSet of Strings
     * @param list2 - A non-empty LinkedHashSet of Strings
     * @return A LinkedHashSet of Strings, list3, that contains all elements that occur in both list1 and list2 parameters.
     */
    public static LinkedHashSet<String> findIntersection(LinkedHashSet<String> list1, LinkedHashSet<String> list2) {
        LinkedHashSet<String> list3 = (LinkedHashSet<String>) list1.clone();
        list3.retainAll(list2);
        return list3;
    }

    /**
     * Method: findDifference
     * @param list1 - A non-empty LinkedHashSet of Strings
     * @param list2 - A non-empty LinkedHashSet of Strings
     * @return A LinkedHashSet of Strings, list3, that contains the elements that occur only in the parameter list1
     *         and not in the parameter list2.
     */
    public static LinkedHashSet<String> findDifference(LinkedHashSet<String> list1, LinkedHashSet<String> list2) {
        LinkedHashSet<String> list3 = (LinkedHashSet<String>) list1.clone();
        list3.removeAll(list2);
        return list3;
    }
}
