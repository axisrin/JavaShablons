package Observer;

public class ObserverTest {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.attach(new ConcreteObserver(concreteSubject));
        concreteSubject.attach(new ConcreteObserver(concreteSubject));
        concreteSubject.attach(new ConcreteObserver(concreteSubject));

        concreteSubject.setSubjectState("Where is my rice? Chin chan?");
        concreteSubject.notifyObserver();
    }

}
