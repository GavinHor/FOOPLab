package lab2;

public class MostRecentObject<T>{
    private T mostRecentObject;

    public void add(T object){
        mostRecentObject = object;
    }

    public T getMostRecentObject() {
        return mostRecentObject;
    }
}

