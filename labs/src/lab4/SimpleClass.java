package lab4;

class SimpleClass {
    public int x = 10;
    public String y = "hello";
}

record RecordClass(int x, String y) {
}

class ReferenceClass {
    public int value;
    public ReferenceClass next;

    public ReferenceClass(int value) {
        this.value = value;
    }
}

class WithInteger {
    public int x = 10;
    public Integer y = 20;
}
