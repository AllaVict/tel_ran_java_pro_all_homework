package homework7_07_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class HomeWork {


    public static void main(String[] args) {

//    создать лист, наполнить его 10М> елементами
//    2. внутри тела кладем i- тый элемент в переменную temp
        List<Integer> myList = new ArrayList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            myList.add(i);
            Integer temp = myList.get(i);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time create loop " + (finish - start)); //750

//    перебрать for-each loop
//    для всех случаев сделать замер времени
//    результат вывести в консоль
        start = System.currentTimeMillis();
        for (Integer value : myList) {
            Integer temp = myList.get(value);
        }
        finish = System.currentTimeMillis();
        System.out.println("Time for-each loop " + (finish - start)); // 53

//    classic for и вызываем list.size() для каждой итерации

        start = System.currentTimeMillis();
        for (int i = 0; i < myList.size(); i++) {
            myList.size();
        }
        finish = System.currentTimeMillis();
        System.out.println("Time fori loop = " + (finish - start)); // 8

//    classic for, но list.size() определяем в переменную
        start = System.currentTimeMillis();
        for (int i = 0; i < myList.size(); i++) {
            int size = myList.size();
        }
        finish = System.currentTimeMillis();
        System.out.println("Time fori loop = " + (finish - start)); // 3

//    classic for, list.size() определяем в переменную, перебираем с конца (i--)
        start = System.currentTimeMillis();
        for (int i = myList.size(); i >= 0; i--) {
            int size = myList.size();
        }
        finish = System.currentTimeMillis();
        System.out.println("Time fori loop (i--) = " + (finish - start)); // 8

//    используя Iterator
        long start1 = System.currentTimeMillis();
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
                    int temp = iterator.next();
        }
        long finish1 = System.currentTimeMillis();
        System.out.println("Time Iterator = " + (finish1 - start1)); // 8


//    используя ListIterator
        start = System.currentTimeMillis();
        ListIterator<Integer> listIterator = myList.listIterator();
        while (listIterator.hasNext()) {
            int temp = listIterator.next();
        }
        finish = System.currentTimeMillis();
        System.out.println("Time ListIterator = " + (finish - start)); // 8



    }



}
