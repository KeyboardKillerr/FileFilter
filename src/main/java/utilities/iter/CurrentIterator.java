package utilities.iter;

import utilities.iter.Exceptions.InitializationException;

import java.util.List;

public class CurrentIterator<E> implements IteratorWithGetCurrent<E> {
    private final List<E> list;
    private boolean isStarted = false;
    private int currentIndex = 0;

    public CurrentIterator(List<E> list) {
        if (list == null || list.isEmpty()) throw new InitializationException();
        this.list = list;
    }

    @Override
    public E current() { return list.get(currentIndex); }

    @Override
    public boolean hasNext() {
        if (!isStarted) return true;
        return list.size() - 1 > currentIndex;
    }

    @Override
    public E next() {
        if (!isStarted) {
            isStarted = true;
            return list.get(0);
        }
        return list.get(++currentIndex);
    }

    @Override
    public boolean hasPrevious() { return currentIndex > 0; }

    @Override
    public E previous() { return list.get(--currentIndex); }

    @Override
    public int nextIndex() { return currentIndex + 1; }

    @Override
    public int previousIndex() { return currentIndex - 1; }

    @Override
    public void remove() {

    }

    @Override
    public void set(E e) {

    }

    @Override
    public void add(E e) {

    }
}
