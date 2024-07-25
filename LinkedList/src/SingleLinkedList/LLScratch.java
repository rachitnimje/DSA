package SingleLinkedList;

import static java.lang.System.exit;

public class LLScratch {

    private Node head;
    private Node tail;

    private int size;

    public LLScratch() {
        this.size = 0;
    }

    Node getHead() {
        return head;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addLast(int value) {
        // if the list is empty
        if(tail == null) {
            addFirst(value);
            return;
        }

        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        size += 1;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void addAt(int index, int value) {
        if(head == null || index == 0) {
            addFirst(value);
            return;
        }
        else if(index == size) {
            addLast(value);
            return;
        }
        else if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index given exceeds the size of the list");
        }

        Node current = head;
        for(int i=0; i<index-1; i++) {
            current = current.next;
        }
        Node newNode = new Node(value, current.next);
        current.next = newNode;
        size += 1;
    }

    public void addRecursive(int value, int index, Node current, Node prev) {
        if(index == 0) {
            if(head == current) {
                addFirst(value);
                return;
            }
            prev.next = new Node(value, current);
            return;
        }
        addRecursive(value, index-1, current.next, current);
    }

    public void addRecursiveV2(int value, int index) {
        head = addRecursiveV2(value, index, head);
    }
    private Node addRecursiveV2(int value, int index, Node node) {
        if(index == 0) {
            size++;
            return new Node(value, node);
        }

        node.next = addRecursiveV2(value, index-1, node.next);
        return node;
    }

    public int deleteFirst() {
        // cond of empty list
        if(head == null) {
            System.out.println("LinkedList is already empty!");
            exit(0);
        }
        // cond of list of single element
        if(head == tail) {
            tail = null;
        }

        int value = head.value;
        head = head.next;
        size -= 1;

        return value;
    }

    public int deleteLast() {
        if(size == 0) {
            System.out.println("LinkedList is already empty!");
        }
        if(head == tail) {
            return deleteFirst();
        }
        Node current = head;
        Node prev = head;

        while(current.next != null) {
            prev = current;
            current = current.next;
        }

        int value = tail.value;
        prev.next = null;
        return value;
    }

    static LLScratch mergeSortedLists(LLScratch list1, LLScratch list2) {
        Node current1 = list1.head;
        Node current2 = list2.head;

        if(current1 == null && current2 == null) {
            return null;
        }

        LLScratch LL = new LLScratch();

        while(current1 != null && current2 != null) {

            if(current1.value < current2.value) {
                LL.addLast(current1.value);
                current1 = current1.next;
            }
            else {
                LL.addLast(current2.value);
                current2 = current2.next;
            }
        }
        while(current1 != null) {
            LL.addLast(current1.value);
            current1 = current1.next;
        }
        while(current2 != null) {
            LL.addLast(current2.value);
            current2 = current2.next;
        }

        return LL;
    }

    public int deleteAt(int index) {
        if(size < index-1)
            throw new IndexOutOfBoundsException("Invalid index!");
        else if(index == 0) {
            return deleteFirst();
        }
        else if(index == size - 1) {
            return deleteLast();
        }
        if(head == null) {
            System.out.println("The list is already empty!");
            exit(0);
        }

        Node current = head;
        Node prev = head;

        for(int i=0; i<=index-1; i++) {
            prev = current;
            current = current.next;
        }

        prev.next = current.next;
        size -= 1;
        return current.value;
    }

    public void print() {
        if(head == null) {
            System.out.println("The LinkedList is empty!");
            return;
        }

        Node current = head;
        System.out.print("");
        while(current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
