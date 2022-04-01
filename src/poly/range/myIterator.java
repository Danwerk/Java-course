package poly.range;

import java.util.Iterator;

public class myIterator implements Iterator<Integer> {
    private int start;
    private int end;

    public myIterator(int start, int end) {

        this.start = start;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        return start <= end;
    }

    @Override
    public Integer next() {
        return start++;
    }
}
