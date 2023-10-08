package lab1;

class EfficientArrayList implements List {
    int[] values;
    int len;

    public EfficientArrayList() {
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
        if (len == values.length) {
            int[] newValues = new int[(len * 2) + 1];
            for (int i = 0; i < len; i++) {
                newValues[i] = values[i];
            }
            newValues[len] = value;
            values = newValues;
        } else {
            values[len] = value;
        }
        len++;
    }

    public int length() {
        return len;
    }
}
