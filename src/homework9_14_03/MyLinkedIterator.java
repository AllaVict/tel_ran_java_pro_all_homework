package homework9_14_03;


import java.util.Iterator;

public class MyLinkedIterator implements Iterator<Integer> { // Имплементируйте интерфес Iterator
    private Node current; //задайте переменную, которая будет указывать на текущий элемент

    public MyLinkedIterator(MyLinkedList list) {
        //Конструктор нашего итератора должен принимать наш созданный MyLinkedList
        // и помещать первый элемент нашего листа(голову) в текущую переменную.
        current = list.getHead();
    }


    // В интерфейсе Iterator есть нам знакомые методы hasNext И next, надо их надо реализовать
    @Override
    public boolean hasNext() {
        return current != null;  // проверяет что еще есть элементы
    }

    @Override
    public Integer next() {
        Integer data = current.getData();    // возвращает данные из текущей ноды
        current = current.getNext();         //  и делает следующий элемент текущим
        return data;
    }


}