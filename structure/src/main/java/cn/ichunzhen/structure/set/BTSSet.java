package cn.ichunzhen.structure.set;

import cn.ichunzhen.structure.tree.BST;

public class BTSSet<E extends Comparable<E>> implements ISet<E> {
    BST<E> bst;

    public BTSSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
