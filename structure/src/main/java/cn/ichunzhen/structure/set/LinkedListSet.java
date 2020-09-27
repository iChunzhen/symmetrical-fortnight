package cn.ichunzhen.structure.set;

import cn.ichunzhen.structure.list.ILinkList;

public class LinkedListSet<E extends Comparable<E>> implements ISet<E> {
    ILinkList<E> list;

    public LinkedListSet(ILinkList<E> list) {
        this.list = list;
    }

    @Override
    public void add(E e) {
        list.addFirst(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
