package Flyweight;

public class ConcreteFlyweight implements Flyweight {

    int intrinsicState;

    @Override
    public void operation(int extrinsicState) {
        intrinsicState = extrinsicState;
    }
}
