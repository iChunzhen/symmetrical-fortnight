package cn.ichunzhen.structure.stack;

public interface IStack<E> {
    int size();

    boolean isEmpty();

    void push(E e);

    E peek();

    E pop();
}
