package homework11_21_03;

import java.util.Comparator;

public class StudyComparator implements Comparator<Students> {

    @Override
    public int compare(Students o1, Students o2) {
        int resultByLastName = o1.getLastName().compareTo(o2.getLastName());
        int resultByFirstName = o1.getFirstName().compareTo(o2.getFirstName());
        return resultByLastName == 0 ? resultByFirstName : resultByLastName;

    }
}