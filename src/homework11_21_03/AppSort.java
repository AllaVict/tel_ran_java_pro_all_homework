package homework11_21_03;

//    Дан массив пар, состоящий из двух строк с именами и фамилиями,
//    отсортировать массив в возрастающем лексикографическом порядке имени,
//    и если две строки одинаковы, отсортируйте их по фамилии.
//    Input: { {"abc", "last"}, {"pklz", "yelp"}, {"rpng", "note"}, {"ppza", "xyz"}}
//    Output: { {"abc", "last"}, {"pklz", "yelp"}, {"ppza", "xyz"}, {"rpng", "note"}}

import java.util.*;
public class AppSort {

    public static void main(String[] args) {

        String[][] students = {{"abc", "last"}, {"pklz", "yelp"}, {"rpng", "note"}, {"ppza", "xyz"}, {"rpng", "abs"}};

        List<Students> studentsList = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
           studentsList.add(new Students(students[i][0],students[i][1]));
        }

        System.out.println("Input  : "+ studentsList);
        StudyComparator studyComparator = new StudyComparator();
        Collections.sort(studentsList, studyComparator);
        System.out.println("Output : "+ studentsList);

    }
}
