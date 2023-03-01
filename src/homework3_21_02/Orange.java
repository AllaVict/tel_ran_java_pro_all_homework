package homework3_21_02;

public class Orange extends Phone {


    public Orange() {
    }

    public Orange(int number) {
        super(number);
    }

    @Override
    public void call(String name) {
        System.out.println(name + " call to number " + number+" via Orange");
    }

    @Override
    public void receiveCall(String name) {
        System.out.println(name + " receive call from number " + number +" via Orange");

    }

    @Override
    public String toString() {
        return "Orange{" +
                "name='" + name + '\'' +
                "number='" + number + '\'' +
                '}';
    }

}