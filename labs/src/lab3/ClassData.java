package lab3;
import java.lang.reflect.*;
import java.util.Set;
import  java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
public class ClassData {
    Set<Class<?>> classes = new HashSet<>();
    //should links be a set?
    List<Link> links = new ArrayList<>();


    public ClassData(List<Class<?>> classes) {
        this.classes.addAll(classes);
        findSuperClasses();
        findDependencies();
        findInterfaces();
        findFields();
    }
    //////////////////////////////////////////////////////////////////
    public void findSuperClasses() {
        for (Class<?> c : classes) {
            Class<?> sc = c.getSuperclass();
            if(sc != null && classes.contains(sc))
            {
                links.add(new Link(c, sc, LinkType.SUPERCLASS));
            }
        }
    }
    //////////////////////////////////////////////////////////////////
    public void findDependencies() {
        for (Class<?> c : classes) {
            for (Field f : c.getDeclaredFields()) {
                // Check if the field type is one of the classes in the set
                if (classes.contains(f.getType())) {
                    links.add(new Link(c, f.getType(), LinkType.DEPENDANCY));
                    // Recursively inspect dependencies of the field's type
                    inspectType(c, f.getGenericType());
                }
            }
        }
    }
    ///////////////////////////////////////////////////////////////////
    private void inspectType(Class<?> c, Type type) {
        if(type instanceof ParameterizedType) {
            for(Type argument : ((ParameterizedType) type).getActualTypeArguments()) {
                links.add(new Link(c, (Class<?>) argument, LinkType.DEPENDANCY));
                inspectType(c, argument);
            }
        }
    }
    ///////////////////////////////////////////////////////////////////
    public void findInterfaces() {
        for (Class<?> c : classes) {
            for (Class<?> i : c.getInterfaces()) {
                if (classes.contains(i)) {
                    links.add(new Link(i, c, LinkType.SUPERCLASS));
                }
            }
        }
    }

    public void findFields() {
        for (Class<?> c : classes) {
            for (Field f : c.getDeclaredFields()) {
                if (classes.contains(f.getType())) {
                    links.add(new Link(c, f.getType(), LinkType.DEPENDANCY));
                }
                inspectType(c, f.getGenericType());
            }
        }
    }

    public static String mermaidClassString(Class<?> c) {
        StringBuilder sb = new StringBuilder();
        sb.append("class ").append(c.getSimpleName()).append("{ \n");
        for (Field f : c.getDeclaredFields()) {
            appendModifiers(f.getModifiers(), sb);
            sb.append(f.getName())
                    .append(": ")
                    .append(f.getType().getSimpleName())
                    .append("\n");
        }
        for(Method m : c.getDeclaredMethods())
        {
            appendModifiers(m.getModifiers(), sb);
            sb.append(m.getName())
                    .append("(");
            Type[] parameterTypes = m.getGenericParameterTypes();
            for(Type type : parameterTypes) {
                sb.append(type.getTypeName() + " ");
            }
            sb.append("): ")
                    .append(m.getReturnType().getSimpleName())
                    .append("\n");
            for(Parameter p:m.getParameters()){
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    private static void appendModifiers(int modifier, StringBuilder sb) {
        if(modifier != 0)
        {
            sb.append(Modifier.toString(modifier) + " ");
        }
    }

    public String toMermaid() {
        StringBuilder sb = new StringBuilder();
        sb.append("classDiagram\n");
        for (Class<?> c : classes) {
            sb.append(mermaidClassString(c));
        }
        for (Link l : links) {
            String linkString = String.format("%s %s %s\n", l.from().getSimpleName(), l.type().linkString, l.to().getSimpleName());
            sb.append(linkString);
        }
        return sb.toString();
    }
}