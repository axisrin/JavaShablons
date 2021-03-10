package Flyweight;

public class Client {

    public static void main(String[] args) {
        int extrincsicState = 10;

        Flyweight flyweight = null;
        FlyweightFactory flyweightFactory = new FlyweightFactory();

        flyweight = flyweightFactory.GetFlyweight(2);
        flyweight.operation(extrincsicState);

        flyweight = flyweightFactory.GetFlyweight(20);
        flyweight.operation(extrincsicState);

        flyweight = new UnsharedConcreteFlyweight();
        flyweight.operation(extrincsicState);
    }

}
