package com.hillel.list.singlylinkedlist;

import java.util.Iterator;

public class ListContainer<E> implements Iterable<Node<E>> {

    private Node<E> head;
    private int size;

    public ListContainer() {
    }

    public ListContainer(E[] elements) {
        for (E e : elements) {
            addLast(e);
        }
    }

    private Node<E> getNodeByIndex(int index) {
        Iterator<Node<E>> iter = iterator();
        for (int i = 0; i < index; i++) {
            iter.next();
        }
        return iter.next();
    }

    public void addByIndex(E element, int index) {
        if (index == 0) {
            addFirst(element);
            return;
        } else {
            Node<E> currentNode = getNodeByIndex(index - 1);
            Node<E> nodeToAdd = new Node<>();
            nodeToAdd.setCurrentElement(element);
            nodeToAdd.setNextElement(currentNode.getNextElement());
            currentNode.setNextElement(nodeToAdd);
        }
        size++;
    }

    public void addFirst(E element) {
        Node<E> node = new Node<>();
        node.setCurrentElement(element);
        if (head == null) {
            head = node;
        } else {
            node.setNextElement(head);
            head = node;
        }
        size++;
    }

    public void addLast(E element) {
        Node<E> node = new Node<>();
        node.setCurrentElement(element);
        if (head == null) {
            head = node;
        } else {
            Node<E> last = getNodeByIndex(size - 1);
            last.setNextElement(node);
        }
        size++;
    }

    public void replaceElements(int index1, int index2) {
        Node<E> first;
        Node<E> second;
        Node<E> temp;
        if (index1 == 0) {
            first = head;
            second = getNodeByIndex(index2 - 1);
            temp = second.getNextElement().getNextElement();
            head = second.getNextElement();
            second.setNextElement(first);
            head.setNextElement(first.getNextElement());
            second.getNextElement().setNextElement(temp);
        } else if (index2 == 0) {
            first = head;
            second = getNodeByIndex(index1 - 1);
            temp = second.getNextElement().getNextElement();
            head = second.getNextElement();
            second.setNextElement(first);
            head.setNextElement(first.getNextElement());
            second.getNextElement().setNextElement(temp);

        } else {
            first = getNodeByIndex(index1 - 1);
            second = getNodeByIndex(index2 - 1);
            temp = first.getNextElement();
            first.setNextElement(second.getNextElement());
            second.setNextElement(temp);
            temp = first.getNextElement().getNextElement();
            first.getNextElement().setNextElement(second.getNextElement().getNextElement());
            second.getNextElement().setNextElement(temp);
        }
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty");
            return;
        } else {
            head = head.getNextElement();
        }
        size--;
    }

    public void removeLast() {
        if (size == 1) {
            head = null;
            return;
        } else {
            Node<E> node = getNodeByIndex(size - 2);
            node.setNextElement(null);
        }
        size--;
    }

    public void removeByIndex(int index) {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        if (size == 1) {
            head = null;
        } else if (index == 0) {
            head = head.getNextElement();
        } else {
            Node<E> node = getNodeByIndex(index - 1);
            node.setNextElement(node.getNextElement().getNextElement());
        }
        size--;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        Iterator<Node<E>> iter = iterator();
        String result = "";
        while (iter.hasNext()) {
            result += iter.next().getCurrentElement() + " ";
        }
        return result;
    }

    public Iterator<Node<E>> iterator() {
        return new ListIterator<E>(head);
    }
    
}

class Node<E> {

    private E currentElement;
    private Node<E> nextElement;

    Node() {
        setCurrentElement(null);
        setNextElement(null);
    }
    
    public String toString() {
        return currentElement.toString();
    }

    public Node<E> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node<E> nextElement) {
        this.nextElement = nextElement;
    }

    public E getCurrentElement() {
        return currentElement;
    }

    public void setCurrentElement(E currentElement) {
        this.currentElement = currentElement;
    }
}
