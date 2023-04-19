import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(228);
        list.add(667);
        list.add(677);
        list.add(1488);
        list.add(1337);
        list.add(45);
        list.add(88);
        list.printList();
        list.sort();
        list.printList();
        /*
        MyLinkedList lits = new MyLinkedList();
        lits.add(667);
        lits.add(228);
        lits.add(1337);
        lits.add(1488, 2);
        lits.printList();
        System.out.println(lits.size());
        System.out.println(lits.isSortable());
        lits.sort();
        lits.printList();

         */
    }
}