package Factory;

public class ConcreteCreator1 extends Creator{

    public ConcreteCreator1(Product product) {
        super(product);
    }


    protected Product factoryMethod(){
        return new ConcreteProduct1();
    }
}
