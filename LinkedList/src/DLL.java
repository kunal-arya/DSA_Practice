public class DLL {


    Node head;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        // if the head is itself null, no need to update head.prev == null
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int val) {
        if (head == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        node.next = null;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node tempNext = temp.next;
        Node node = new Node(val,tempNext,temp);
        tempNext.prev = node;
        temp.next = node;
    }

    public void insertAfter(int after, int val) {
        Node prevNode = find(after);
        if (prevNode == null) {
            System.out.println(after + " does not exist");
            return;
        }
        Node nextNode = prevNode.next;
        Node node = new Node(val,nextNode,prevNode);
        prevNode.next = node;
        if (nextNode != null) {
            nextNode.prev = node;
        }
    }

    public Node find(int val) {
        Node node = head;
        while (node != null) {
            if (node.val == val) {
                return node;
            }
            node = node.next;
        }

        // if the value is not found
        return null;
    }

    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("print in reverse");
        while(last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("END");
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 1; i <= index; i++) {
            node = node.next;
        }
        return node;
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
