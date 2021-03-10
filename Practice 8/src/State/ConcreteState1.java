package State;

public class ConcreteState1 implements State{

    @Override
    public void handle(Context context) {
        System.out.println("Switched on new State1");
        context.setState(new ConcreteState2());
    }

}
