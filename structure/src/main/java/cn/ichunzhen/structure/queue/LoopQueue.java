package cn.ichunzhen.structure.queue;


public class LoopQueue<E> implements IQueue<E> {
    E[] data;
    int size;
    int tail, front;
    //tail 尾巴 该位置不放置元素 浪费一个空间 创建的时候+1
    //front 第一个元素角标

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    private int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail=(tail+1)%data.length;
        size++;
    }


    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E et = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() != 0) {
            resize(getCapacity() / 2);
        }
        return et;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[tail];
    }

    private void resize(int i) {
        E[] temData = (E[]) new Object[i + 1];
        for (int j = 0; j < size; j++) {
            temData[j] = data[(front + j) % data.length];
        }
        data = temData;
        tail = size;
        front = 0;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
