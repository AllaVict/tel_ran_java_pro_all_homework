package homework10_16_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Task1 {

//    Задача 1, есть массив :
//    arr = {1,1,5,3,3,4,3,2,4,2,7,6,9,11,14,1,7,15,0,8};
//    Написать метод, который будет принимать данный массив и
//    вернет новый массив, который состоит только из :
//    a) уникальных элементов
//    b) элементов, которые как минимум присутствуют дважды в оригинальном массиве
//    Результатом будет класс в котором есть метод main и два метода для случая a И b.

    public static void main(String[] args) {
        Integer arr[] = {1, 1, 5, 3, 3, 4, 3, 2, 4, 2, 7, 6, 9, 11, 14, 1, 7, 15, 0, 8};

        // метод,кот принимает данный массив и вернет новый массив,кот состоит только из
        // a) уникальных элементов
        Object[] newArray1 = uniqeElements(arr);
        System.out.println(Arrays.toString(newArray1)); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 14, 15]

        // метод,кот принимает данный массив и вернет новый массив,кот состоит только из
        //b) элементов, которые как минимум присутствуют дважды в оригинальном массиве

        Object[] newArray2 = dublicateElements(arr);
        System.out.println(Arrays.toString(newArray2)); //

    }

    public static Object[] uniqeElements(Integer[] array) {
        // метод,кот принимает данный массив и вернет новый массив,кот состоит только из
        // a) уникальных элементов
        Set<Integer> set = new TreeSet<>();
//        for (int i = 0; i < arr.length(); i++) {
//            set.add(arr[i]);
//        }
        for (int temp : array) {
            set.add(temp);
        }
        Object[] uniqeElements = set.toArray();
        return uniqeElements;

    }

    public static Object[] dublicateElements(Integer[] array) {
        // метод,кот принимает данный массив и вернет новый массив,кот состоит только из
        //b) элементов, которые как минимум присутствуют дважды в оригинальном массиве
        // Integer arr[] = {1, 1, 5, 3, 3, 4, 3, 2, 4, 2, 7, 6, 9, 11, 14, 1, 7, 15, 0, 8};

        ArrayList<Integer> dublicateElementsArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            Integer currArray = array[i];
            int count = 0;
            for (int j = i + 1; j < array.length; j++) {
                if (currArray == array[j]) {
                    count++;
                }
            }
            if (count > 0) {
                dublicateElementsArray.add(currArray);
            }

        }

        Set<Integer> set = new TreeSet<>();
        for (int temp : dublicateElementsArray) {
            set.add(temp);
        }
        Object[] dublicateElements = set.toArray();

        return dublicateElements;
    }


}
