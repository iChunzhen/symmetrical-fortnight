package cn.ichunzhen.structure.map;

public class BTSMap<K extends Comparable<K>, V> implements IMap<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BTSMap() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (node.key.compareTo(node.key) < 0) {
            add(node.left, key, value);
        } else if (node.key.compareTo(node.key) > 0) {
            add(node.right, key, value);
        } else
            node.value = value;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V newValue) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
