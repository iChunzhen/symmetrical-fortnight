package cn.ichunzhen.structure.set;

public interface ISet<E> {
    void add(E e);

    boolean contains(E e);

    int getSize();

    void remove(E e);

    boolean isEmpty();
}
