package lab4;

import java.lang.reflect.Field;

public class BasicStringify implements Stringify {
    // Basic flawed version that only works for simple classes
    // No private fields, no cyclic graphs, no traversal of object graph
    public String stringify(Object o) {
        StringBuilder sb = new StringBuilder();
        sb.append(o.getClass().getSimpleName());
        sb.append("(");
        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                sb.append(f.getName()).append("=");
                sb.append(f.get(o)).append(", ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        sb.append(")");
        return sb.toString();
    }
}