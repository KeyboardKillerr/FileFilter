package utilities.iter;

import java.util.ListIterator;

public interface IteratorWithGetCurrent<E> extends ListIterator<E> {
    E current();
}
