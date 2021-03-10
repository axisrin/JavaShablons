package Prototype;

public class ConcretePrototype1 implements Prototype<ConcretePrototype1> {

    public int field1;
    public int field2;
    public Boolean field3;

    public ConcretePrototype1() {
        this.field1 = 1;
        this.field2 = 2;
        this.field3 = false;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public void setField3(Boolean field3) {
        this.field3 = field3;
    }

    public ConcretePrototype1(ConcretePrototype1 concretePrototype1) {
        this.field1 = concretePrototype1.field1;
        this.field2 = concretePrototype1.field2;
        this.field3 = concretePrototype1.field3;
    }

    @Override
    public ConcretePrototype1 clone() {
        return new ConcretePrototype1(this);
    }

    @Override
    public String toString() {
        return "ConcretePrototype1{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                ", field3=" + field3 +
                '}' + "Object is " + this.hashCode();
    }
}
