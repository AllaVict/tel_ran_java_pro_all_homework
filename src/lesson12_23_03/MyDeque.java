package lesson12_23_03;

public interface MyDeque {

    void addToHead(Integer element);
    void addToTail(Integer element);
    Integer removeHead();
    Integer removeTail();

    Integer peekHead();

    Integer peekTail();

    boolean isEmpty();
    boolean contains(Integer element);



}
