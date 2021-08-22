package WorkWithFile;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Iter implements Iterator<String> {
    private List<String> str;
    private int count ;

    private int currentIndex = 0;

    public Iter(List<String> str) {
        this.str = str;
        this.count = this.str.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return (0 < count) && (str.get(count) != null);
    }

    @Override
    public String next() {
        return str.get(count--);
    }
}
