package homework3_21_02;

public class Mobile extends Phone {


    public Mobile() {
    }

    public Mobile(int number) {
        super(number);
    }

    @Override
    public void call(String name) {
        System.out.println(name + " call to number " + number+" via Mobile");

    }

    @Override
    public void receiveCall(String name) {
        System.out.println(name + " receive call from number " + number +" via Mobile");

    }

    @Override
    public String toString() {
        return "Mobile{" +
                "name='" + name + '\'' +
                "number='" + number + '\'' +
                '}';
    }
}
