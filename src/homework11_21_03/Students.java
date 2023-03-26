package homework11_21_03;

public class Students{

    String lastName;
    String firstName;

    public Students(String lastName, String firstName) {
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
                "\"" + lastName +"\""+
                ", \"" + firstName + "\""+
                '}';
    }

}
