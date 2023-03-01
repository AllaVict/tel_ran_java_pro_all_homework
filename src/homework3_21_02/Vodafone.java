package homework3_21_02;

public class  Vodafone extends Phone {

    public Vodafone() {
    }

    public Vodafone(int number) {
        super(number);
    }

    @Override
    public void call(String name) {
        System.out.println(name + " call to number " + number+" via Vodafone");
    }

    @Override
    public void receiveCall(String name) {
        System.out.println(name + " receive call from number " + number +" via Vodafone");
    }

    @Override
    public String toString() {
        return "Vodafone{" +
                "name='" + name + '\'' +
                "number='" + number + '\'' +
                '}';
    }

}