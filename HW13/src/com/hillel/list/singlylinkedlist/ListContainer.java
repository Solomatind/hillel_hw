package com.hillel.list.singlylinkedlist;

public class ListContainer<E> {

    private class Node<E> {

        private E currentElement;
        private Node<E> nextElement;

        private Node() {
            currentElement = null;
            nextElement = null;
        }
    }

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
        Node<E> node = head;
        int counter = 0;
        while (counter != index) {
            node = node.nextElement;
            counter++;
        }
        return node;
    }

    public void addByIndex(E element, int index) {
        if (index == 0) {
            addFirst(element);
            return;
        } else {
            Node currentNode = getNodeByIndex(index - 1);
            Node nodeToAdd = new Node<>();
            nodeToAdd.currentElement = element;
            nodeToAdd.nextElement = currentNode.nextElement;
            currentNode.nextElement = nodeToAdd;
        }
        size++;
    }

    public void addFirst(E element) {
        Node node = new Node<>();
        node.currentElement = element;
        if (head == null) {
            head = node;
        } else {
            node.nextElement = head;
            head = node;
        }
        size++;
    }

    public void addLast(E element) {
        Node node = new Node<>();
        node.currentElement = element;
        if (head == null) {
            head = node;
        } else {
            Node last = getNodeByIndex(size - 1);
            last.nextElement = node;
        }
        size++;
    }

    public void replaceElements(int index1, int index2) {
        Node first;
        Node second;
        Node temp;
        if (index1 == 0) {
            first = head;
            second = getNodeByIndex(index2 - 1);
            temp = second.nextElement.nextElement;
            head = second.nextElement;
            second.nextElement = first;
            head.nextElement = first.nextElement;
            second.nextElement.nextElement = temp;
        } else if (index2 == 0) {
            first = head;
            second = getNodeByIndex(index1 - 1);
            temp = second.nextElement.nextElement;
            head = second.nextElement;
            second.nextElement = first;
            head.nextElement = first.nextElement;
            second.nextElement.nextElement = temp;

        } else {
            first = getNodeByIndex(index1 - 1);
            second = getNodeByIndex(index2 - 1);
            temp = first.nextElement;
            first.nextElement = second.nextElement;
            second.nextElement = temp;
            temp = first.nextElement.nextElement;
            first.nextElement.nextElement = second.nextElement.nextElement;
            second.nextElement.nextElement = temp;
        }
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty");
            return;
        } else {
            head = head.nextElement;
        }
        size--;
    }

    public void removeLast() {
        if (size == 1) {
            head = null;
            return;
        } else {
            Node node = getNodeByIndex(size - 2);
            node.nextElement = null;
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
            head = head.nextElement;
        } else {
            Node node = getNodeByIndex(index - 1);
            node.nextElement = node.nextElement.nextElement;
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
        Node node = head;
        String result = "";
        while (node != null) {
            result += node.currentElement + " ";
            node = node.nextElement;
        }
        return result;
    }

}
