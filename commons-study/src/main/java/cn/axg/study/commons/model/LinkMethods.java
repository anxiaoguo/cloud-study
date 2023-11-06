package cn.axg.study.commons.model;

import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

public class LinkMethods<E> {


    private Node<E> last;

    private Node<E> first;



    public void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e, null, l);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
    }

    @Override
    public String toString() {
        Node<E> temp = first;
        StringBuilder sb = new StringBuilder();
        for (;;){
            if(temp != null){
                sb.append(temp.item+"-");
                temp = temp.next;
            }else {
                return sb.toString();
            }
        }

    }
}
