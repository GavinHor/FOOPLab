package lab1;

class ArrayList implements List {
    int[] values;
    int len;

    public ArrayList() {
        values = new int[0];
        len = 0;
    }

    public boolean contains(int value) {
        for (int i = 0; i < len; i++) {
            if (value == values[i]) {
                return true;
            }
        }
        return false;
    }

    public void append(int value) {
        int[] newValues = new int[len + 1];
        for (int i = 0; i < len; i++) {
            newValues[i] = values[i];
        }
        newValues[len] = value;
        values = newValues;
        len++;
    }

    public int length() {
        return len;
    }
}
