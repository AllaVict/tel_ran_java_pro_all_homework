package homework10_16_03;

import java.util.HashSet;
import java.util.Set;

public class Task2 {


//    Задача 2,надо потерять объект.
// ***   Создать свой собственный класс, с двумя строковыми полями и одним целочисленным.
// ***   Создать 5 объектов данного класса. Поместить все объекты в Set.
// ***   Вывести сет в консоль.
// ***   а) Сделать так, что бы размер Set == 5, но один из созданных объектов нельзя было найти в сете.
// ***   Вывести сет в консоль за минусом объекта, который не находится среди созданных 5ти.

    public static void main(String[] args) {
        Pupils one = new Pupils("Alina","G",18);
        Pupils two = new Pupils("Monika","L",19);
        Pupils three = new Pupils("Kate","P",17);
        Pupils four = new Pupils("Sandra","R",21);
        Pupils five = new Pupils("Barbara","S",20);

        Set<Pupils> pupilsSet = new HashSet<>();

        pupilsSet.add(one);
        pupilsSet.add(two);
        pupilsSet.add(three);
        pupilsSet.add(four);
        pupilsSet.add(five);
        System.out.println("pupilsSet before : \n" + pupilsSet);

        two.setFirstName(""); // потеряли обект five


        if (pupilsSet.contains(two)) {
            System.out.println("All done");
        } else {
            System.out.println("Note done");
        }
        System.out.println("pupilsSet after : \n" + pupilsSet);




    }




}
