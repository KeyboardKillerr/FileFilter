package utilities.collections.setlikes;

import java.util.Set;

public interface SetWithGet<E> extends Set<E> {
    E get(int key);
}
