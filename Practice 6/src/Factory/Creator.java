package Factory;

import java.util.Scanner;

public class Creator {

    private final Product product;

    public Creator(Product product) {
        this.product = product;
    }

    protected Product factoryMethod(String stringNumber) {
        if (stringNumber.equals("1")) {
            ConcreteCreator1 cc1 = new ConcreteCreator1(this.product);
            return cc1.factoryMethod();
        } else if (stringNumber.equals("2")) {
            ConcreteCreator2 cc2 = new ConcreteCreator2(this.product);
            return cc2.factoryMethod();
        }
        return null;
    }

    protected void anOperation(Product productTemple) {
        productTemple.getInfo();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Creator creator = new Creator(new ConcreteProduct1());

        Product myProduct = creator.factoryMethod(scanner.next());

        myProduct.getInfo();
    }

}
