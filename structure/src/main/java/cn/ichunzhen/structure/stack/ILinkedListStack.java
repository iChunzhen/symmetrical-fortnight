package cn.ichunzhen.structure.stack;


import cn.ichunzhen.structure.list.ILinkList;

public class ILinkedListStack<E> implements IStack<E> {
    ILinkList<E> list;

    public ILinkedListStack() {
        list = new ILinkList<>();
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E peek() {
        return list.get(0);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
    public static void main(String[] args) {

        ILinkedListStack<Integer> stack = new ILinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

}
