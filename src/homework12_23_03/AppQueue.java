package homework12_23_03;

public class AppQueue {
    public static void main(String[] args) {
        MyArrayDeque myArrayDeque = new MyArrayDeque(7);

        myArrayDeque.addToHead(14); // 1
        myArrayDeque.addToHead(15); // 2
        myArrayDeque.addToHead(16); // 3
        myArrayDeque.addToTail(3); // 4
        myArrayDeque.addToTail(4); // 5
        myArrayDeque.addToTail(5); // 6
        myArrayDeque.addToTail(6); // 7

        System.out.println("Before " + myArrayDeque);// [14, 15, 16, 6, 5, 4, 3],
        myArrayDeque.addToHead(17); // 8
        myArrayDeque.addToHead(18); // 9
        myArrayDeque.addToHead(19); // 10
        myArrayDeque.addToHead(21); // 11
        myArrayDeque.addToHead(22); // 12
        myArrayDeque.addToTail(7);
        myArrayDeque.addToTail(8);
        System.out.println("After " + myArrayDeque);//[14, 15, 16, 17, 18, 19, 21, 22, null, null, null, 8, 7, 6, 5, 4, 3]

        System.out.println("contains 17 "+ myArrayDeque.contains(17));
        System.out.println("contains 36 "+ myArrayDeque.contains(36));



    }
}
