package lab2;

import java.util.Iterator;

public class OddRange implements Iterable<Integer> {
    private final int start;
    private final int end;

    public OddRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new OddRangeIterator(start, end);
    }

    private static class OddRangeIterator implements Iterator<Integer> {
        private int current;
        private final int end;

        public OddRangeIterator(int start, int end) {
            start = ChangeToOdd(start);
            end = ChangeToOdd(end);
            this.current = start;
            this.end = end;
        }

        private int ChangeToOdd(int value)
        {
            if(value % 2 == 0)
            {
                value--;
            }
            else
            {
                value -= 2;
            }
            return value;
        }

        @Override
        public boolean hasNext() {
            return current < end;
        }

        @Override
        public Integer next() {
            return current += 2;
        }
    }

    public static void main(String[] args) {
        OddRange range = new OddRange(-6, 5);
        for (int num : range) {
            System.out.println(num);
        }
    }
}