package joey.com.dataStructures.map.impl;

import joey.com.dataStructures.map.IMap;
import joey.com.dataStructures.map.Node;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class HashMapImpl<K, V> implements IMap<K, V> {

    private static final int INITIAL_CAPACITY = 16; // Tamanho inicial do HashMap
    private LinkedList<Node<K, V>>[] table; // Array de LinkedLists para buckets
    private int size = 0;

    public HashMapImpl() {
        table = new LinkedList[INITIAL_CAPACITY];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Node<K, V> node : table[index]) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }

        table[index].add(new Node<>(key, value, null));
        size++;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void remove(K key) {
        int index = hash(key);
        if (table[index] == null) return;

        for (Node<K,V> node : table[index]) {
            if (node.getKey().equals(key)) {
                table[index].remove(node);
                size--;
                return;
            }
        }
    }

    @Override
    public Integer size() {
        return this.size;
    }

    @Override
    public Boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new HashSet<V>();
        for (LinkedList<Node<K,V>> bucket : table) {
            if (bucket != null) {
                for (Node<K, V> node : bucket) {
                    values.add(node.getValue());
                }
            }
        }
        return values;
    }

    @Override
    public Boolean containsKey(K key) {
        int index = hash(key);
        if (table[index] == null) return false;

        for (Node<K,V> node : table[index]) {
            if (node.getKey().equals(key)) return true;
        }

        return false;
    }

    @Override
    public Boolean containsValue(V value) {
        for (LinkedList<Node<K, V>> bucket : table) {
            if (bucket != null) {
                for (Node<K, V> entry : bucket) {
                    if (entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
