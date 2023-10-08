package lab1;

public class ListsExample {
    static void testList(List list)
    {
        list.append(10);
        list.append(20);

        System.out.println(list.contains(10));
        System.out.println(list.contains(20));
        System.out.println(list.contains(30));

        System.out.println(list.length());
    }

    public static void main(String[] args)
    {
        testList(new LinkedList());
        System.out.println();
        testList (new ArrayList());
        System.out.println();
        testList(new EfficientLinkedList());
        System.out.println();
        testList (new EfficientArrayList());
        System.out.println();
    }
}