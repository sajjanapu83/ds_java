package com.datastructures;

public class ExampleLL {

    private class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (first == null && last == null) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (first == null && last == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    public void printList() {
        if (first == null) {
            System.out.println("List is empty");
        } else {
            while (first != null) {
                System.out.println(first.value);
                first = first.next;
            }
        }

    }

    public void deleteFirst() {
        if (first == null) {
            throw new IllegalArgumentException();
        } else if (first == last) {
            first = last = null;
        } else {
            Node temp = first;
            first = first.next;
            temp = null;
        }

    }

    public void deleteLast() {
        if (first == null) {
            throw new IllegalArgumentException();
        } else if (first == last) {
            first = last = null;
        } else {
            var current = first;
            while (current != null) {
                if (current.next == last)
                    break;
                current = current.next;
            }
            last = current;
            last.next = null;
        }
    }

    public boolean contains(int value) {
        if (first == null) {
            return false;
        } else {
            while (first != null) {
                if (first.value == value) {
                    return true;
                }
                first = first.next;
            }

            return false;

        }
    }

    public int indexOf(int value) {
        if (first == null) {
            return -1;
        } else {
            int count = 0;
            while (first != null) {
                if (first.value == value) {
                    return count;
                }
                first = first.next;
                count++;
            }
            return -1;
        }
    }

    public int findKthNodeFromEnd(int kthNode) {
        var current = first;
        var forward = first;
        for (int i = 0; i < kthNode - 1; i++)
                forward = forward.next;

        while (forward != last) {
            if (forward == null) throw new IllegalArgumentException();
            forward = forward.next;
            current = current.next;
        }
        return current.value;
    }

}
