package State;

public class Context {

    State state = new ConcreteState1();

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
    
    public void request() {
        this.state.handle(this);
    }
}
