public class CodeLinkedList {

    private Node head;
    private Node tail;

    private class Node {
        private Node next;
        private int value;

    }

    public void addFirst(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    public void deleteFirst() {
        if (head == null) {
            throw new IllegalArgumentException();
        } else {
            Node temp = head;
            head = temp.next;
            temp.next = null;
        }
    }

    public void deleteLast() {
        if (head == null) {
            throw new IllegalArgumentException();
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    public boolean contains(int value) {
        if (head == null) {
            return false;
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.value == value) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public int indexOf(int value) {
        int count = -1;
        if (head == null) {
            throw new IllegalArgumentException();
        } else {
            Node temp = head;

            while (temp != null) {
                count++;
                if (temp.value == value) {
                    return count;
                }
                temp = temp.next;
            }
        }
        return count;
    }

    public void print() {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }

    }

}
