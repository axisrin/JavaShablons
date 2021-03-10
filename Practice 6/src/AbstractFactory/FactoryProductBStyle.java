package AbstractFactory;

public class FactoryProductBStyle implements AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductAB();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductBB();
    }
}
