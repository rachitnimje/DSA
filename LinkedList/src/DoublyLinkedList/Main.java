package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DLLScratch DLL = new DLLScratch();
        DLL.addFirst(4);
        DLL.addFirst(6);
        DLL.print();

        DLL.addLast(69);
        DLL.addAt(1, 70);
        DLL.print();

        DLL.deleteLast();
        DLL.print();

        DLL.deleteAt(0);
        DLL.print();

    }
}
