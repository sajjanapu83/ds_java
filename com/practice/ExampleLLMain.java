package com.datastructures;

public class ExampleLLMain {
    public static void main(String[] args) {
        ExampleLL newList = new ExampleLL();
        newList.addLast(10);
        newList.addLast(20);
        newList.addLast(30);
        newList.addLast(40);
        newList.addLast(50);
        newList.addLast(60);
        newList.addLast(70);
        newList.addLast(80);
        newList.addLast(90);
        newList.addLast(100);
        newList.printList();
        System.out.println(newList.indexOf(30));
        //int value = newList.findKthNodeFromEnd(8);
        //System.out.println(value);

        // newList.deleteFirst();
        // newList.deleteLast();
        // newList.addFirst(50);
        // newList.addLast(10);
        // newList.printList();
        // newList.addFirst(10);
        // newList.addFirst(20);
        // newList.addFirst(30);
        // newList.addFirst(40);
        // newList.addFirst(50);
        // newList.printList();
        //
    }

}