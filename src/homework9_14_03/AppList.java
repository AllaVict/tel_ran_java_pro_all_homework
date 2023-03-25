package homework9_14_03;
//    Для класса MyLinkedList, реализованного на уроке, реализовать методы :
//     1)Добавить элемент по индексу.
//     2)Удалить элемент по индексу.
// *  Добавить итератор в наш класс.
//**  Добавить ListIterator

import java.util.Iterator;
import java.util.ListIterator;

public class AppList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToHead(5);// 5
        myLinkedList.addToHead(2);// 2 5
        myLinkedList.addToHead(4);// 4 2 5
        myLinkedList.addToTail(3); // 4 2 5 3
        myLinkedList.addToTail(6); // 4 2 5 3 6
        myLinkedList.addToTail(1);  //4 2 5 3 6 1

        myLinkedList.print();
        System.out.println("Size = " + myLinkedList.size());

        System.out.print("myLinkedList before: ");
        myLinkedList.print();

        System.out.println("-----------------");
        //     1)Добавить элемент по индексу.
        myLinkedList.addOfIndex(1, 17);  //4 2 5 17 3 6 1
        System.out.print("myLinkedList after addOfIndex : ");
        myLinkedList.print();

        System.out.println("-----------------");
        myLinkedList.removeOfIndex(6);  //4 2 ---5 3 6 1
        //     2)Удалить элемент по индексу.
        System.out.print("myLinkedList after removeOfIndex : ");
        myLinkedList.print();

        // *  Добавить итератор в наш класс.
        System.out.println("iterator myLinkedList : ");
        Iterator<Integer> iterator = myLinkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }
        System.out.println();

        //**  Добавить ListIterator
        System.out.println("ListIterator myLinkedList : ");
        ListIterator<Integer> listIterator = myLinkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(" " + listIterator.next());
        }



    }




}
