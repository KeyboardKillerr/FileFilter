package utilities.collections.setlikes;

import org.jetbrains.annotations.NotNull;
import java.util.*;

public class PseudoSet<E> implements SetWithGet<E> {
    private final Map<Integer, E> storage = new HashMap<>();
    private final Iterator<E> iterator = storage.values().iterator();

    public PseudoSet() { }

    @SuppressWarnings("unchecked")
    public PseudoSet(@NotNull E... items) {
        for (var item : items) storage.put(item.hashCode(), item);
    }
    public PseudoSet(@NotNull Collection<E> items) {
        for (var item : items) storage.put(item.hashCode(), item);
    }

    @Override
    public int size() { return storage.size(); }

    @Override
    public boolean isEmpty() { return storage.isEmpty(); }

    @Override
    public boolean contains(Object obj) { return storage.containsKey(obj.hashCode()); }

    @NotNull
    @Override
    public Iterator<E> iterator() { return iterator; }

    @NotNull
    @Override
    public Object[] toArray() { return storage.values().toArray(); }

    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        if (a.length != storage.size()) a = Arrays.copyOf(a, storage.size());
        int i = 0;
        for (var item : storage.values()) {
            a[i] = (T1) item;
            i++;
        }
        return a;
    }

    @Override
    public boolean add(E t) {
        var result = storage.put(t.hashCode(), t);
        return result == null;
    }

    @Override
    public boolean remove(@NotNull Object o) {
        var result = storage.remove(o.hashCode());
        return result == null;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) { return storage.values().containsAll(c); }

    @Override
    public boolean addAll(@NotNull Collection<? extends E> c) {
        if (storage.values().containsAll(c)) return false;
        for (var item : c) storage.put(item.hashCode(), item);
        return true;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        int previousSize = storage.size();
        for (var item : c) {
            if (!storage.containsKey(item.hashCode()))
                storage.remove(item.hashCode());
        }
        return storage.size() == previousSize;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        int previousSize = storage.size();
        for (var item : c) storage.remove(item.hashCode());
        return storage.size() == previousSize;
    }

    @Override
    public void clear() { storage.clear(); }

    @Override
    public E get(int key) { return storage.get(key); }
}
