package cn.ichunzhen.structure.list;

public class ILinkList<E> {
    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(Node next) {
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
    }


    // 获得链表的第index(0-based)个位置的元素
    public E get(int index) {
    }

    public E getFirst() {
    }

    // 获得链表的最后一个元素
    public E getLast() {
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e) {
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
    }


    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index) {
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst() {
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast() {
    }

    // 从链表中删除元素e
    public void removeElement(E e) {
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
