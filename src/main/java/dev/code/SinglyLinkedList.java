package dev.code;

public class SinglyLinkedList {

    public Node head;

    public Node tail;

    public SinglyLinkedList() {

    }

    public SinglyLinkedList(int value) {

        this.head = new Node();
        this.head.data = value;
        this.head.next = null;
        this.tail = this.head;
    }

    public SinglyLinkedList append(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;

        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;

        return this;
    }

    public void printList() {
        Node useNode = this.head;

        while (useNode != null) {
            System.out.println(useNode.data);
            useNode = useNode.next;
        }

        // print(useNode);

    }

    public void printList(Node head) {
        Node useNode = head;

        while (useNode != null) {
            System.out.print(useNode.data + "-->");
            useNode = useNode.next;
        }

        // print(useNode);

    }

    private void print(Node useNode) {
        if (useNode != null) {
            System.out.println(useNode.data);
            print(useNode.next);
        }
    }

    public SinglyLinkedList prepend(int i) {

        Node newNode = new Node(i);

        newNode.next = this.head;

        this.head = newNode;

        return this;
    }

    public void insert(int index, int value) {

        if (index == 0) {
            this.prepend(value);
            return;
        }

        if (index >= this.length()) {
            this.append(value);
            return;
        }

        Node nodeJustBeforeGivenIndex = traverseToIndex(index - 1);

        // make an insert
        Node newNode = new Node(value);
        newNode.next = nodeJustBeforeGivenIndex.next;
        nodeJustBeforeGivenIndex.next = newNode;

    }

    private Node traverseToIndex(int index) {
        Node nodeJustBeforeGivenIndex = this.head;

        // getting node just before given index using while loop
        while (index > 0) {
            nodeJustBeforeGivenIndex = nodeJustBeforeGivenIndex.next;
            index--;
        }
        return nodeJustBeforeGivenIndex;
    }

    public int length() {

        int count = 0;

        if (this.head != null) {

            Node currentNode = this.head;

            while (currentNode != null) {
                currentNode = currentNode.next;
                count++;
            }

        }

        return count;
    }

    public void remove(int i) {

        if (i == 0) {
            this.head = this.head.next;
            return;
        }

        if (i == this.length() - 1) {
            Node nodeJustBeforeGivenIndex = traverseToIndex(i - 1);

            nodeJustBeforeGivenIndex.next = null;
            return;

        }

        Node nodeJustBeforeGivenIndex = traverseToIndex(i - 1);

        nodeJustBeforeGivenIndex.next = nodeJustBeforeGivenIndex.next.next;

    }

    public void reverse() {

        //
        Node first = this.head;
        Node second;
        if (first != null) {
            second = first.next;
        } else {
            return;
        }

        if (second != null) {
            first.next = null;
            this.tail = first;
            while (second != null) {

                Node temp = second.next;
                second.next = first;
                first = second;
                second = temp;

            }

            this.head = first;

        } else {

            this.tail = this.head;

        }

    }

}
