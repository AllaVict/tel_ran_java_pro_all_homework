package lesson12_23_03;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayDeque implements MyDeque {
        /*
    indexHead = 0;
    _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
    0                           10
    addToHead(2);  // add by indexHead and indexHead++;
    addToHead(4);
    addToHead(6);

     2 4 6 _ _ _ _ _ _ _ _ _ _ _ _
     0                           10
    indexTail = elements.length -1;
    addToTail(3);  indexTail--
    addToTail(5);
    addToTail(1);

    2 4 6 7 4 ___3 9 8 1 5 3
    0                           10

    --------------------->>>>>>
    ////  -> 9 8 1 5 3 2 4 6 7 4 3<-

     */

    private Integer[] elements;
    private int numberOfElements = 0;
    private int indexHead = 0;
    private int indexTail;

    public MyArrayDeque(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elements = new Integer[initialCapacity];
            indexTail = elements.length - 1;
        }
    }

    @Override
    public void addToHead(Integer element) {
        if (elements.length == numberOfElements) {
            elements = this.getNewDeque();
        }
        elements[indexHead] = element;
        indexHead++;
        numberOfElements++;
    }

    @Override
    public void addToTail(Integer element) {
        if (numberOfElements == elements.length){
            //  throw new IllegalStateException("Deque is full");
            elements = this.getNewDeque();
        }
        elements[indexTail] = element;
        indexTail--;
        numberOfElements++;
    }

    private Integer[] getNewDeque() {
        //    2 4 6 7 4 _ _ _ 3 9 8 1 5 3
        //    0     Head    Tail        newLength-1
        int newLength = elements.length + 5;
        Integer[] newElements = new Integer[newLength];
        int newIndexTail = indexTail + (newLength - elements.length);
        if (indexHead != 0) {
            System.arraycopy(elements, 0, newElements, 0, indexHead);
        }
        if (indexTail != elements.length - 1) {
            System.arraycopy(elements, indexTail + 1, newElements, newIndexTail + 1, elements.length - indexTail - 1);

        }
        //   System.out.println("newElements" + Arrays.toString(newElements));
        indexTail = newIndexTail;
        return newElements;
    }


    @Override
    public Integer removeHead() {
        if (numberOfElements == 0) {
            throw new NoSuchElementException();
        }
        Integer integer = peekHead();
        elements[indexHead] = null;
        indexHead--;
        numberOfElements--;

        return integer;
    }

    @Override
    public Integer removeTail() {
        if (numberOfElements == 0) {
            throw new NoSuchElementException();
        }
        Integer integer = peekTail();
        elements[indexTail] = null;
        indexTail++;
        numberOfElements--;

        return integer;
    }

    @Override
    public Integer peekHead() {
        if (numberOfElements == 0) {
            throw new NoSuchElementException();
        }

        return elements[indexHead];
    }

    @Override
    public Integer peekTail() {
        if (numberOfElements == 0) {
            throw new NoSuchElementException();
        }

        return elements[indexTail];
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean contains(Integer element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyArrayDeque{" +
                "elements=" + Arrays.toString(elements) +
                ", numberOfElements=" + numberOfElements +
                ", indexHead=" + indexHead +
                ", indexTail=" + indexTail +
                '}';
    }

}
