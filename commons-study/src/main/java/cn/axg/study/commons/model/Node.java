package cn.axg.study.commons.model;

/**
 * 模拟建链表的数据结构 Node 双向链表
 *
 * @param <E>
 */
public class Node<E> {

    E item;

    Node<E> next;

    Node<E> pre;

    public Node(E item, Node<E> next, Node<E> pre) {
        this.item = item;
        this.next = next;
        this.pre = pre;
    }

}
