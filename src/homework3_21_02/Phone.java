package homework3_21_02;

public abstract class Phone {

    protected String name;

    protected int number;

    public Phone() {
    }

    public Phone(int number) {
        this.number = number;
    }


    public abstract void call(String name);

    public abstract void receiveCall(String name);


}