package SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        LLScratch LL1 = new LLScratch();
        LLScratch LL2 = new LLScratch();

        LL1.addLast(1);
//        LL1.addLast(2);
//        LL1.addLast(4);
//
//        LL2.addLast(1);
//        LL2.addLast(3);
        LL2.addLast(4);

        LLScratch ans = LLScratch.mergeSortedLists(LL1, LL2);
        ans.print();
    }
}