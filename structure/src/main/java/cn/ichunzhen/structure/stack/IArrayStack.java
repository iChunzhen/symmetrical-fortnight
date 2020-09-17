package cn.ichunzhen.structure.stack;

import cn.ichunzhen.structure.array.IArray;

public class IArrayStack<E> implements IStack<E> {
    IArray<E> data;

    public IArrayStack(int capacity) {
        data = new IArray(capacity);

    }

    public IArrayStack() {
        this(10);
    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }


    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public E pop() {
        return data.removeLast();
    }
}
