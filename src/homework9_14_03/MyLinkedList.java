package homework9_14_03;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class MyLinkedList extends LinkedList<Integer> implements Iterable<Integer>  {

    private Node head;
    public Node getHead() {
        return head;
    }

    public void addToTail(int i) {
        Node node = new Node(i, null);
        if (head == null) {
            head = node;
            return;
        }
        // head -> data 4 -> 2 -> 5 -> 3 -> null
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);


    }

    public void addToHead(int i) {
        Node node = new Node(i, null);
        if (head == null) {
            head = node;
            return;
        }
        node.setNext(head);
        head = node;

    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    public int size() {
        int size = 0;
        if (head == null) {
            return 0;
        }
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.getNext();
        }
        return size;
    }

    public Integer get(int index) {
        if (head == null) {
            return -1;
        }
        if (index >= size() || index < 0) {
            return -1;
        }
        int count = -1;
        Node curr = head;
        while (curr != null) {
            count++;
            if (count == index) {
                return curr.getData(); // getData() - возращает данніе класса MyLinkedList

            }
            curr = curr.getNext();
        }
        return -1;
    }

    public void addOfIndex(int index, int i) {
        Node node = new Node(i, null);
        if (head == null) {
            head = node;
            return;
        }
        if (index >= size() || index <= 0) {
            System.out.println("Wrong index, index must be between 1 and " + (size() - 1));
        } else {

            int count = 0;
            Node current = head;
            while (current != null) {
                count++;
                if (count == index) {
                    Node nextOfCurrent = current.getNext(); //
                    current.setNext(node);
                    node.setNext(nextOfCurrent);
                }

                current = current.getNext();
            }
        }

    }

    public void removeOfIndex(int index) {
// index=0  index   index=last
// head -> data 4 -> 2 -> 5 -> 3 -> 6 -> 1 -> null
//        Node head = new Node(4, node1);  0
//        Node node1 = new Node(2, node2);  1  // node1.setNext(node3);
//----->>> Node node2 = new Node(5, node3);  2
//        Node node3 = new Node(3, node4);  3
//        Node node4 = new Node(3, node5);  4
//        Node node5 = new Node(3, null);   5
// myLinkedList.removeOfIndex(index=2);
// count=index ==1  current = Node node1 = new Node(2, node2 ->node3);
// count=index ==2  current = Node node2 = new Node(2, node3 ->null);

        if (index >= size() || index <= 0) {
            System.out.println("Wrong index, index must be between 1 and " + (size() - 1));
        } else {
            int count1 = -1;
            Node current1 = head;
            Node newNext = head;
            Node delete = head;
            // 0  1 2 3 4 5 6
            // 4 17 2 5 3 6 1
            while (current1 != null) {
                count1++;
                if (count1 == index) { // index=7
                    delete = current1;
                    newNext = current1.getNext();
                    break;
                }
                current1 = current1.getNext();
            }

            int count = -1;
            Node current = head;
            while (current != null) {
                count++;
                if (count == index - 1) {
                    current.setNext(newNext);
                    delete.setNext(null);
                    break;
                }
                current = current.getNext();
            }
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        // в данном методе создаем наш ранее созданный итератор , в конструктор которого
        // передадим this, что будет являться нашим текущим MyLinkedList
        return new MyLinkedIterator(this);
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        // return super.listIterator(index);
        return new MyLinkedListIterator(this);
    }
}

