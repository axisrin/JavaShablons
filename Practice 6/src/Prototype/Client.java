package Prototype;

public class Client {

    public static void main(String[] args) {
        ConcretePrototype1 concretePrototype1 = new ConcretePrototype1();
        concretePrototype1.setField1(10);
        concretePrototype1.setField2(20);
        concretePrototype1.setField3(true);

        ConcretePrototype2 concretePrototype2 = new ConcretePrototype2();
        concretePrototype2.setField4(40);
        concretePrototype2.setField5("Banger!");

        ConcretePrototype1 newConcretePrototype1 = concretePrototype1.clone();
        ConcretePrototype2 newConcretePrototype2 = concretePrototype2.clone();

        System.out.println("Old Proto 1 is = " + concretePrototype1.toString());
        System.out.println("Old Proto 2 is = " + concretePrototype2.toString());
        System.out.println("=========================== NEW PROTOS ===========================");
        System.out.println("New Proto 1 is = " + newConcretePrototype1.toString());
        System.out.println("New Proto 2 is = " + newConcretePrototype2.toString());
    }

}
