

public class main {
    public static void main(String[] args) {
        // Single LinkedList
//        LL list = new LL();
//        list.insertFirst(3);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(17);
//        list.insertLast(18);
//        list.insert(100,4);
//        list.display();
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.delete(2));
//        list.display();

        // Double LinkedList
//        DLL list = new DLL();
//        list.insertFirst(3);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(17);
//        list.insertFirst(18);
//        list.insertLast(20);
//        list.insert(34,2);
//        list.insertAfter(2,22);
//        list.display();

        // Circular Linkedlist
        CLL list = new CLL();
        list.insert(4);
        list.insert(3);
        list.insert(5);
        list.insert(10);
        list.display();
        list.delete(4);
        list.display();
        list.delete(10);
        list.insert(15);
        list.display();
    }
}
