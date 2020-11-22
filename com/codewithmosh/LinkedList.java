package com.codewithmosh;

import java.util.NoSuchElementException;

public class LinkedList {
    Node first;
    Node last;

    class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void addFirst(int value) {
        var newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    public void addLast(int value) {
        var newNode = new Node(value);
        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (first == last) {
            first = last = null;
        } else {
            Node temp = first;
            first = first.next;
            temp = null;
        }

    }

    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (first == last) {
            first = last = null;
        } else {
            var toBeLast = first;
            while (toBeLast != null) {
                if (toBeLast.next == last)
                    break;
                toBeLast = toBeLast.next;
            }
            last = toBeLast;
            last.next = null;

        }
    }

    public boolean contains(int value) {
        while (first != last) {
            if (first.value == value)
                return true;
            first = first.next;
        }
        return false;
    }

    public int indexOf(int value) {
        int counter = 0;
        while (first != last) {
            if (first.value == value)
                return counter;
            first = first.next;
            counter++;
        }
        return -1;
    }

    public void printList() {
        var tempNode = first;
        while (tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }

    public void reverse() {
        // [10 -> 20 -> 30 -> 40 -> 50]
        // p c n
        // c.next = p
        // p = c
        // c = n
        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;

    }

    public void reverseSpaceComplexity() {
        // This is with increased space as we are creating a new list based on the size
        // of list to be reversed.
        LinkedList revList = new LinkedList();
        var tempNode = first;
        while (tempNode != null) {
            revList.addFirst(tempNode.value);
            tempNode = tempNode.next;
        }
        revList.printList();
    }

    public int findKthNodeFromEnd(int index){
        // [10 -> 20 -> 30 -> 40 -> 50]
        //  k   
        return -1;
    }
}
