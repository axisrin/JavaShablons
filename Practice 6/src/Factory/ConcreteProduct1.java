package Factory;

public class ConcreteProduct1 implements Product {

    @Override
    public void getInfo() {
        System.out.print("This one is product numba #1");
    }
}
