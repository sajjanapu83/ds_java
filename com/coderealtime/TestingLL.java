package com.coderealtime;

public class TestingLL {

    public static void main(String[] args) {
        CodeLinkedList list = new CodeLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.deleteLast();
        list.print();
    }
    
}
