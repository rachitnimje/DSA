package DoublyLinkedList;

import static java.lang.System.exit;

public class DLLScratch {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public DLLScratch() {
        size = 0;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value, head, null);

        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void addLast(int value) {
        if(head == null) {
            addFirst(value);
            return;
        }

        Node newNode = new Node(value, null, tail);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void addAt(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(head == null ||  index == 0) {
            addFirst(value);
            return;
        }
        if(index == size) {
            addLast(value);
            return;
        }

        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        Node newNode = new Node(value, current, current.prev);
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    public int deleteFirst() {
        // cond: no element in the list
        if(head == null) {
            System.out.println("The list is already empty!");
            exit(0);
        }
        // cond: only one element in the list
        int value = head.value;
        if(head == tail) {
            head = tail = null;
            size--;
            return value;
        }
        head.next.prev = null;
        head = head.next;
        size--;
        return value;
    }

    public int deleteLast() {
        // no element in the list
        if(head == null) {
            System.out.println("The list is already empty!");
        }
        // only one element
        int value = tail.value;
        if(head == tail) {
            return deleteFirst();
        }

        tail.prev.next = null;
        tail = tail.prev;
        size--;
        return value;
    }

    public int deleteAt(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(head == null) {
            System.out.println("The list is already empty!");
            exit(0);
        }
        else if(index == 0 || head == tail) {
            return deleteFirst();
        }
        if(index == size-1) {
            System.out.println("chicken");
            return deleteLast();
        }

        Node current = head;
        for(int i=0 ;i <= index-1; i++) {
            current = current.next;
        }
        int value = current.value;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return value;
    }

    public void print() {
        if(head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;
        while(current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
