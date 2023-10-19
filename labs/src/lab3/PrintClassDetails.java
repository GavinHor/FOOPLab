package lab3;
import java.lang.reflect.*;

public class PrintClassDetails {
    public static void main(String[] args) {
        printClass(MyCircle.class);
    }

    public static void printClass(Class<?> c) {
        System.out.println("Inspecting class: " + c.getName());
        System.out.println("\nFields: ");
        //Inspect fields
        for (Field field : c.getDeclaredFields()) {
            printType(field.getName(), field.getGenericType());
        }

        //Inspect methods - omitted for brevity
        //Inspect constructors
        System.out.println("\nConstructors: ");
        for (Constructor<?> constructor : c.getDeclaredConstructors()) {
            System.out.println(constructor);
            Type[] parameterTypes = constructor.getGenericParameterTypes();
            for(Type paramType : parameterTypes) {
                printType(constructor.getName(), paramType);
            }
            System.out.println();
        }

        System.out.println("Methods: ");
        for (Method method : c.getDeclaredMethods()) {
            System.out.println(method);
            System.out.println("Return Type: " + method.getGenericReturnType());
            Parameter[] parameters = method.getParameters();
            for(Parameter p : parameters) {
                System.out.println("Argument type and name: (" + p.getType() + " " + p.getName() + ")");
            }
            System.out.println();
        }
    }

    public static void printType(String name, Type type) {
        System.out.println("Name: " + name + " : " + type.getTypeName());
    }
}
