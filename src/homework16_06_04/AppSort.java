package homework16_06_04;

//    Дан массив пар, состоящий из двух строк с именами и фамилиями,
//    отсортировать массив в возрастающем лексикографическом порядке имени,
//    и если две строки одинаковы, отсортируйте их по фамилии.
//    Input: { {"abc", "last"}, {"pklz", "yelp"}, {"rpng", "note"}, {"ppza", "xyz"}}
//    Output: { {"abc", "last"}, {"pklz", "yelp"}, {"ppza", "xyz"}, {"rpng", "note"}}

// 1) В домашней работе от 21.03 использовали свой компаратор для сортировки строк.
// Переделать данный компаратор на запись в виде lambda выражения, аналогично примеру на уроке.


import java.util.*;
public class AppSort {

    public static void main(String[] args) {

        String[][] students = {{"abc", "last"}, {"pklz", "yelp"}, {"rpng", "note"}, {"ppza", "xyz"}, {"rpng", "abs"}};

        List<Students> studentsList = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            studentsList.add(new Students(students[i][0],students[i][1]));
        }


        System.out.println("Input : "+ studentsList);
//        StudyComparatorImplement studyComparator = new StudyComparatorImplement();
//        Collections.sort(studentsList, studyComparator);
        Collections.sort(studentsList, (o1, o2) -> {
            int resultByLastName = o1.getLastName().compareTo(o2.getLastName());
            int resultByFirstName = o1.getFirstName().compareTo(o2.getFirstName());
            return resultByLastName == 0 ? resultByFirstName : resultByLastName;

        });

        System.out.println("Output byAll : "+ studentsList);




    }


}
