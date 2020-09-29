package cn.ichunzhen.structure.heap;


import cn.ichunzhen.structure.array.IArray;

/**
 * 普通队列：先进先出 后进后出
 * 优先队列： 最大元素先出 和进入顺序无关 和优先级有关
 */
public class MaxHeap<E extends Comparable<E>> {
    private IArray<E> datas;

    public MaxHeap(int capacity) {
        datas = new IArray<>(capacity);
    }

    public MaxHeap() {
        this(10);
    }

    public MaxHeap(E[] arr) {
        datas = new IArray<>(arr.length);
        for (int i = 0; i < arr.length; i++) {

        }
    }

    public int getSize() {
        return datas.getSize();
    }

    public boolean isEmpty() {
        return datas.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        datas.addLast(e);
        siftUp(datas.getSize() - 1);
    }

    //上浮操作
    private void siftUp(int k) {
        while (k > 0 && datas.get(parent(k)).compareTo(datas.get(k)) < 0) {
            datas.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (datas.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return datas.get(0);
    }

    // 取出堆中最大元素
    public E extractMax() {
        E ret = findMax();
        datas.swap(0, datas.getSize() - 1);
        datas.removeLast();
        siftDown(0);
        return ret;
    }

    //下沉操作
    private void siftDown(int i) {
        while (i < datas.getSize()) {
            int index = leftChild(i);
            if (datas.getSize() > index + 1 && datas.get(index + 1).compareTo(datas.get(index)) > 0) {
                index = index++;
            }
            if (datas.get(i).compareTo(datas.get(index)) < 0) {
                datas.swap(i, index);
            }
            i = index;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {
        E ret = findMax();
        datas.set(0, e);
        siftDown(0);
        return ret;
    }
}
