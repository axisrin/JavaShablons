package Factory;

public class ConcreteCreator2 extends Creator{

    public ConcreteCreator2(Product product) {
        super(product);
    }

    protected Product factoryMethod() {
        return new ConcreteProduct2();
    }

}
