package com.hillel.list.singlylinkedlist;

import java.util.Iterator;

public class ListIterator<E> implements Iterator<Node<E>> {
    private Node<E> current;

    public ListIterator(Node<E> head) {
        current = head;
    }

    public boolean hasNext() {
        return current != null;
    }

    public Node<E> next() {
        Node<E> temp = current;
        current = current.getNextElement();
        return temp;
    }
    
    public String toString() { 
        return current.toString();
    }

}
