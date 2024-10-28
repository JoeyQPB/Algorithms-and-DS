package joey.com.dataStructures.Set.impls;

import joey.com.dataStructures.Set.ISet;

import java.util.HashMap;
import java.util.Map;

public class HashSetImpl<E> implements ISet<E> {

    private Integer size = 0;
    private static final Boolean PRESENT = Boolean.TRUE;
    private Map<E, Boolean> map;

    public HashSetImpl() {
        map = new HashMap<>();
    }

    @Override
    public boolean add(E element) {
        if (map.containsKey(element)) {
            return false;
        }
        map.put(element, PRESENT);
        return true;
    }

    @Override
    public boolean remove(E element) {
        if (map.containsKey(element)) {
            map.remove(element);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        return map.containsKey(element);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void clear() {

    }
}
