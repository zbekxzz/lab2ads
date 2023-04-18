import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        /* MyArrayList list = new MyArrayList();
        list.add("Aldiyar");
        list.add("Nurbol");
        list.add("Bekbolat");
        list.add("Alisher");
        list.add("Nurkuisa");
        list.add("Nurbol");
        list.add("Dias");
        System.out.println(list.get(6));
        list.add("667", 3);
        System.out.println(list.get(3));
        System.out.println(list.indexOf("Nurbol"));
        System.out.println(list.lastIndexOf("Nurbol"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        */
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

    }
}