public class SampleLinkedList {
    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addFirst(int value) {
        var newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int value) {
        var newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    public void deleteFirst() {
        if (isEmpty())
            throw new IllegalArgumentException();

        var temp = head;
        head = head.next;
        temp.next = null;

    }

    public void deleteLast() {
        if (isEmpty())
            throw new IllegalArgumentException();

        var temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        tail = temp;
        temp.next = null;
    }

    public void reverseList() {
        var previous = head;
        var current = head.next;
        while (previous != tail) {
            var temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        tail = head;
        tail.next = null;
        head = previous;
    }

    public int findKthElementFromList(int k) {
        var first = head;
        var second = head;

        for (int i = 0; i < k - 1; i++) {
            if (second == tail) {
                throw new IllegalArgumentException();
            } else {
                second = second.next;
            }
        }
        while (second != tail) {
            first = first.next;
            second = second.next;
        }

        return first.value;
    }

    public void printMiddleValue(){
        var first = head;
        var second = head;

        while (second != tail && second.next != tail){
            first = first.next;
            second = second.next.next;
        }
        if (second == tail) {
            System.out.println(first.value);
        }
        if (second.next == tail)
            System.out.println(first.value +" -- "+ first.next.value);
    }

    public void createLoop(){
        var temp = head.next.next.next;
        tail.next = temp;
    }

    public boolean hasLoop(){
        var slow = head;
        var fast = head;

        while (slow != tail){
            slow = slow.next;

            if (fast.next == null)
                break;

            fast = fast.next.next;

            if (slow ==  fast){
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void print() {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

}
