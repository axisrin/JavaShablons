package AbstractFactory;

public class Client {

    static AbstractFactory aFactoryA;

    public static void main(String[] args) {

        // Мы хотим Продукт А Стиля В
        aFactoryA = new FactoryProductBStyle();
        aFactoryA.createProductA();

        // Мы хотим Продукт Б Стиля Б и стиля А
        aFactoryA.createProductB();
        aFactoryA = new FactoryProductAStyle();
        aFactoryA.createProductB();

    }


}
