public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("Nurali");
        list.add("Nurbol");
        list.add("Bekbolat");
        list.add("Alikhan");
        list.add("Alisher");
        list.add("Nurkuisa");
        list.add("Dias");
        System.out.println(list.get(3));
        list.add("Aldiyar", 3);
        System.out.println(list.get(3));
    }
}