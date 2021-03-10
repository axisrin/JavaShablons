package Prototype;

public class ConcretePrototype2 implements Prototype<ConcretePrototype2> {

    public ConcretePrototype2() {
        this.field4 = 4;
        this.field5 = "String";
    }

    public void setField4(int field4) {
        this.field4 = field4;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public int field4;
    public String field5;

    public ConcretePrototype2(ConcretePrototype2 concretePrototype2) {
        this.field4 = concretePrototype2.field4;
        this.field5 = concretePrototype2.field5;
    }

    @Override
    public ConcretePrototype2 clone() {
        return new ConcretePrototype2(this);
    }

    @Override
    public String toString() {
        return "ConcretePrototype2{" +
                "field4=" + field4 +
                ", field5='" + field5 + '\'' +
                '}' + "Object is " + this.hashCode();
    }
}
