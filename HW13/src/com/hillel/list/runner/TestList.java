package com.hillel.list.runner;

import com.hillel.list.singlylinkedlist.ListContainer;

public class TestList {

    public static void main(String[] args) {
        Integer[] data = { 15, 3, 8, 12, 17 };
        ListContainer intList = new ListContainer(data);
        intList.addByIndex(2, 3);
        intList.addByIndex(3, 5);
        intList.addFirst(1);
        intList.addLast(18);
        intList.addByIndex(3, 0);
        intList.addByIndex(0, 9);
        System.out.println(intList.toString());
        intList.replaceElements(1, 5);
        System.out.println(intList.toString());
        System.out.println(intList.getSize());
    }

}
