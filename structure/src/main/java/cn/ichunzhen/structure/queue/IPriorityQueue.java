package cn.ichunzhen.structure.queue;

import cn.ichunzhen.structure.heap.MaxHeap;

/**
 *
 */
class IPriorityQueue<E extends Comparable<E>> implements IQueue<E> {

    private MaxHeap<E> maxHeap;

    public IPriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
