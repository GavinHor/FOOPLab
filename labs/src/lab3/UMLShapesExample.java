package lab3;
import java.util.ArrayList;
import java.util.List;

public class UMLShapesExample {
    public static void main(String[] args) {
        List<Class<?>> classes = new ArrayList<>();
        //add in all the classes we wish to generate UML for
        classes.add(MyShape.class);
        classes.add(MyCircle.class);
        classes.add(Connector.class);
        ClassData cd = new ClassData(classes);
        System.out.println(cd.toMermaid());
    }
}
