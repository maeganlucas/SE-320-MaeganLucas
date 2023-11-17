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

    public static void createList1(LinkedHashSet<String> list1) {
        list1.add("George");
        list1.add("Jim");
        list1.add("John");
        list1.add("Blake");
        list1.add("Kevin");
        list1.add("Michael");
    }

    public static void createList2(LinkedHashSet<String> list2) {
        list2.add("George");
        list2.add("Katie");
        list2.add("Kevin");
        list2.add("Michelle");
        list2.add("Ryan");
    }

    public static LinkedHashSet<String> findUnion(LinkedHashSet<String> list1, LinkedHashSet<String> list2) {
        LinkedHashSet<String> list3 = (LinkedHashSet<String>) list1.clone();
        list3.addAll(list2);
        return list3;
    }

    public static LinkedHashSet<String> findIntersection(LinkedHashSet<String> list1, LinkedHashSet<String> list2) {
        LinkedHashSet<String> list3 = (LinkedHashSet<String>) list1.clone();
        list3.retainAll(list2);
        return list3;
    }

    public static LinkedHashSet<String> findDifference(LinkedHashSet<String> list1, LinkedHashSet<String> list2) {
        LinkedHashSet<String> list3 = (LinkedHashSet<String>) list1.clone();
        list3.removeAll(list2);
        return list3;
    }
}
