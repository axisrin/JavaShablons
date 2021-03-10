package Observer;

public class ConcreteObserver implements Observer{

    ConcreteSubject concreteSubject;
    String observerState;

    public ConcreteObserver(ConcreteSubject concreteSubject) {
        this.concreteSubject = concreteSubject;
    }

    @Override
    public void update() {
        this.observerState = this.concreteSubject.getSubjectState();
    }

}
