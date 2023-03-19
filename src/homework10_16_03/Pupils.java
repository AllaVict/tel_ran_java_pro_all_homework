package homework10_16_03;

import java.util.Objects;

public class Pupils {
    //    Создать свой собственный класс, с двумя строковыми полями и одним целочисленным.
    String firstName;
    String lastName;
    int age;

    public Pupils() {
    }

    public Pupils(String firstName) {
        this.firstName = firstName;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Pupils(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return  "\n" +"Pupils{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pupils pupils = (Pupils) o;
        return age == pupils.age && Objects.equals(firstName, pupils.firstName) && Objects.equals(lastName, pupils.lastName);
        //          return true; //!!!!!!!!!!!!!!неверно
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
        //      return 34567; //!!!!!!!!!!!!!!неверно
    }




}
