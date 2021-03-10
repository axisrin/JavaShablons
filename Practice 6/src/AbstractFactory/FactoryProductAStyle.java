package AbstractFactory;

public class FactoryProductAStyle implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductAA();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductBA();
    }
}
