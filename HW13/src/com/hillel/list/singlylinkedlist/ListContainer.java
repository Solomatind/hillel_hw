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
    private Node<E> tail;

    public ListContainer() {
        head = null;
    }

    public ListContainer(E[] elements) {
        addFirst(elements[0]);
        addLast(elements[elements.length - 1]);
        for (int i = 1; i < elements.length - 1; i++) {
            this.addByIndex(elements[i], i);
        }
    }

    public void addByIndex(E element, int index) {
        if (index == 0) {
            addFirst(element);
        } else if (index == (getSize() - 1)) {
            addLast(element);
        } else {
            Node node = head;
            Node nodeToAdd = new Node<>();
            int counter = 1;
            nodeToAdd.currentElement = element;
            while (node.nextElement != null) {
                if (counter == index) {
                    nodeToAdd.nextElement = node.nextElement;
                    node.nextElement = nodeToAdd;
                    return;
                }
                if (counter < index) {
                    node = node.nextElement;
                }
                counter++;
            }
        }
    }

    public void addFirst(E element) {
        Node node = new Node<>();
        node.currentElement = element;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.nextElement = head;
            head = node;
        }
    }

    public void addLast(E element) {
        Node node = new Node<>();
        node.currentElement = element;
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.nextElement = node;
            tail = node;
        }
    }

    public void replaceElements(int index1, int index2) {
        Node first = head;
        Node second = new Node<>();
        int counter = 0;
        while (first.nextElement != null) {
            if (counter == index1 - 1) {
                second = first;
                while (second.nextElement != null) {
                    if (counter == index2 - 1) {
                        Node temp = first.nextElement;
                        first.nextElement = second.nextElement;
                        second.nextElement = temp;
                        temp = first.nextElement.nextElement;
                        first.nextElement.nextElement = second.nextElement.nextElement;
                        second.nextElement.nextElement = temp;
                        return;
                    }
                    second = second.nextElement;
                    counter++;
                }
            }
            first = first.nextElement;
            counter++;
        }
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty");
        } else {
            head = head.nextElement;
        }
    }

    public void removeLast() {
        Node current = head;
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        if (current.nextElement != null) {
            while (current.nextElement != null) {
                if (current.nextElement.nextElement == null) {
                    current.nextElement = null;
                    tail = current;
                    return;
                }
                current = current.nextElement;
            }
        } else {
            head = null;
            tail = null;
        }
    }

    public void removeByIndex(int index) {
        int counter = 0;
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        Node current = head;
        while (current.nextElement != null) {
            if (counter == index) {
                if (tail == current.nextElement) {
                    tail = current;
                }
                current.nextElement = current.nextElement.nextElement;
                return;
            }
            current = current.nextElement;
            counter++;
        }
    }

    public int getSize() {
        Node node = head;
        int size = 1;
        if (isEmpty()) {
            return 0;
        } else {
            while (node.nextElement != null) {
                size++;
                node = node.nextElement;
            }
            return size;
        }
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
