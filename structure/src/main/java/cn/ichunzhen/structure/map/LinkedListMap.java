package cn.ichunzhen.structure.map;

import cn.ichunzhen.structure.list.ILinkList;

public class LinkedListMap<K, V> implements IMap<K, V> {
    private class Node {
        public V value;
        public K key;
        public Node next;

        public Node(K k, V v, Node node) {
            this.value = v;
            this.key = k;
            this.next = node;
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node cur = getNode(key);
        if (cur == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            cur.value = value;
        }
    }

    private Node getNode(K key) {
        Node cur = dummyHead;
        while (cur.next != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.key.equals(key)) {
                break;
            } else
                pre = pre.next;

        }
        if (pre != null) {
            Node cur = pre.next;
            pre.next = cur.next;
            cur.next = null;
            size--;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        return getNode(key).value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = newValue;
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
