package homework9_14_03;

import java.util.ListIterator;

public class MyLinkedListIterator implements ListIterator<Integer> {

    private Node curr; //задайте переменную, которая будет указывать на текущий элемент

    public MyLinkedListIterator(MyLinkedList list) {
        //Конструктор нашего итератора должен принимать наш созданный MyLinkedList
        // и помещать первый элемент нашего листа(голову) в текущую переменную.
        curr = list.getHead();
    }


    @Override
    public boolean hasNext() {
        return curr != null;
    }

    @Override
    public Integer next() {
        Integer data = curr.getData();    // возвращает данные из текущей ноды
        curr = curr.getNext();         //  и делает следующий элемент текущим
        return data;

    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Integer previous() {
        return null;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(Integer integer) {

    }

    @Override
    public void add(Integer integer) {

    }


}

