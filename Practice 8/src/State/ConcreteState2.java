package State;

public class ConcreteState2 implements State{

    @Override
    public void handle(Context context) {
        System.out.println("Switched on new State2");
        context.setState(new ConcreteState1());
    }
}
