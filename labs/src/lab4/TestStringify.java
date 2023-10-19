package lab4;

public class TestStringify {
    public static void main(String[] args) {
        BasicStringify stringify = new BasicStringify();

        // Stringify SimpleClass object
        System.out.println(stringify.stringify(new SimpleClass()));

        // Create and stringify ReferenceClass objects
        ReferenceClass a = new ReferenceClass(10);
        ReferenceClass b = new ReferenceClass(20);
        a.next = b;
        System.out.println(stringify.stringify(a));

        // Stringify RecordClass object
        System.out.println(stringify.stringify(new RecordClass(10, "Hello")));

        // Stringify WithInteger object
        System.out.println(stringify.stringify(new WithInteger()));
    }
}
