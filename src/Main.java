import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Salamaleksus!\n" +
                "Choose what class you want to check\n" +
                "MyArrayList -> 1\n" +
                "MyLinkedList -> 2\n" +
                "Enter your choice: ");
        int ans = sc.nextInt();
        if (ans == 1) testingArrayList();
        else testingLinkedList();
    }
    public static void testingArrayList() {
        Scanner sc = new Scanner(System.in);
        MyArrayList arrayList = new MyArrayList();
        System.out.println("\nLet's start testing with MyArrayList of integers\n" +
                "> Size of array: " + arrayList.size() + "\n" +
                "Add some values in array (if you want to sort it at the end add only integers or only doubles)\n" +
                "Enter '-1' to stop typing");
        int input;
        while (true) {
            input = sc.nextInt();
            if (input == -1) break;
            arrayList.add(input);
        }
        System.out.print("> Your array: ");
        arrayList.printList();
        System.out.println("> Size of array: " + arrayList.size());

        System.out.print("\nLet's add an element at specific index. Enter element and index separated by space: ");
        input = sc.nextInt();
        int index = sc.nextInt();
        arrayList.add(input, index);
        System.out.print("> Your array: ");
        arrayList.printList();

        System.out.print("\nLet's delete your element with index. Enter index: ");
        index = sc.nextInt();
        System.out.println("> You deleted - " + arrayList.remove(index));
        System.out.print("> Your array: ");
        arrayList.printList();

        System.out.print("\nLet's delete your element without knowing index. Enter your element: ");
        input = sc.nextInt();
        System.out.println("> Your element was deleted - " + arrayList.remove((Object) input));
        System.out.print("> Your array: ");
        arrayList.printList();

        System.out.print("\nNow let's find out if the element you entered is in the array. Enter your element: ");
        input = sc.nextInt();
        System.out.println("> Your element is in array - " + arrayList.contains((input)));
        System.out.print("> Your array: ");
        arrayList.printList();

        System.out.print("\nAnd now let's find out the first index of the occurrence of the element you entered in the array. Enter your element: ");
        input = sc.nextInt();
        System.out.println("> Your element's index - " + arrayList.indexOf(input));
        System.out.print("> Your array: ");
        arrayList.printList();

        System.out.print("\nNow let's find out the last index of the occurrence of the element you entered in the array. Enter your element: ");
        input = sc.nextInt();
        System.out.println("> Your element's last index - " + arrayList.lastIndexOf(input));
        System.out.print("> Your array: ");
        arrayList.printList();

        System.out.print("\nLet's try to find out your element with index. Enter your index: ");
        index = sc.nextInt();
        System.out.println("> Your element is - " + arrayList.get(index));
        System.out.print("> Your array: ");
        arrayList.printList();

        System.out.print("\nNow, let's sort your array!\n> Your array before sort - ");
        arrayList.printList();
        arrayList.sort();
        System.out.print("> Your array after sort - ");
        arrayList.printList();
    }
    public static void testingLinkedList() {
        Scanner sc = new Scanner(System.in);
        MyLinkedList linkedList = new MyLinkedList<Integer>();
        System.out.println("\nLet's start testing with MyLinkedList of integers\n" +
                "> Size of array: " + linkedList.size() + "\n" +
                "Add some values in array (if you want to sort it at the end add only integers or only doubles)\n" +
                "Enter '-1' to stop typing");
        int input;
        while (true) {
            input = sc.nextInt();
            if (input == -1) break;
            linkedList.add(input);
        }
        System.out.print("> Your array: ");
        linkedList.printList();
        System.out.println("> Size of array: " + linkedList.size());

        System.out.print("\nLet's add an element at specific index. Enter element and index separated by space: ");
        input = sc.nextInt();
        int index = sc.nextInt();
        linkedList.add(input, index);
        System.out.print("> Your array: ");
        linkedList.printList();

        System.out.print("\nLet's delete your element with index. Enter index: ");
        index = sc.nextInt();
        System.out.println("> You deleted - " + linkedList.remove(index));
        System.out.print("> Your array: ");
        linkedList.printList();

        System.out.print("\nLet's delete your element without knowing index. Enter your element: ");
        input = sc.nextInt();
        System.out.println("> Your element was deleted - " + linkedList.remove((Object) input));
        System.out.print("> Your array: ");
        linkedList.printList();

        System.out.print("\nNow let's find out if the element you entered is in the array. Enter your element: ");
        input = sc.nextInt();
        System.out.println("> Your element is in array - " + linkedList.contains((input)));
        System.out.print("> Your array: ");
        linkedList.printList();

        System.out.print("\nAnd now let's find out the first index of the occurrence of the element you entered in the array. Enter your element: ");
        input = sc.nextInt();
        System.out.println("> Your element's index - " + linkedList.indexOf(input));
        System.out.print("> Your array: ");
        linkedList.printList();

        System.out.print("\nNow let's find out the last index of the occurrence of the element you entered in the array. Enter your element: ");
        input = sc.nextInt();
        System.out.println("> Your element's last index - " + linkedList.lastIndexOf(input));
        System.out.print("> Your array: ");
        linkedList.printList();

        System.out.print("\nLet's try to find out your element with index. Enter your index: ");
        index = sc.nextInt();
        System.out.println("> Your element is - " + linkedList.get(index));
        System.out.print("> Your array: ");
        linkedList.printList();

        System.out.print("\nNow, let's sort your array!\n> Your array before sort - ");
        linkedList.printList();
        linkedList.sort();
        System.out.print("> Your array after sort - ");
        linkedList.printList();
    }
}