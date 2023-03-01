package homework3_21_02;



public class Main {

    public static void main(String[] args) {

        Phone orangeOne = new Orange(777777);
        Phone mobileOne = new Mobile(888888);
        Phone vodafoneOne = new Vodafone(999999);

        orangeOne.call("Kate");
        mobileOne.call("Lily");
        vodafoneOne.call("Jane");
        System.out.println("-----------------1");
        orangeOne.receiveCall("Mike");
        mobileOne.receiveCall("Faina");
        vodafoneOne.receiveCall("Iren");
        System.out.println("-----------------2");
        Phone[] phones = {new Orange(444), new Mobile(555), new Vodafone(666)};
        makeCall(phones);
        makeCall(orangeOne);



    }
      public static void makeCall(Phone... phones) {
        for (Phone phone : phones) {
            phone.call("Mike");
            phone.receiveCall("James");
        }

    }

}