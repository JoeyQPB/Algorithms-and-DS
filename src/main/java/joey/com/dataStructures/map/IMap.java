package joey.com.dataStructures.map;

import java.util.Collection;
import java.util.HashMap;

public interface IMap<K, V> {

    void put (K key, V value);

    V get (K key);

    void remove (K key);

    Integer size();

    Boolean isEmpty();

    Collection<V> values();

    Boolean containsKey(K key);

    Boolean containsValue(V value);
}
