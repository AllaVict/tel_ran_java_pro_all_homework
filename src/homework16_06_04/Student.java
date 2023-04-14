package homework16_06_04;

public class Student {

    String lastName;
    String firstName;

    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    // {{"abc", "last"}, {"pklz", "yelp"}, {"rpng", "note"}, {"ppza", "xyz"}, {"rpng", "abs"}};


    @Override
    public String toString() {
        return "{" +
                "\"" + lastName + "\"" +
                ", \"" + firstName + "\"" +
                '}';
    }

}