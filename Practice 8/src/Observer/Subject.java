package Observer;

import java.util.ArrayList;

public interface Subject {

    ArrayList<Observer> observerArray = new ArrayList<>();

    default void attach(Observer observer) {
        observerArray.add(observer);
    }

    default void detach(Observer observer) {
        observerArray.remove(observer);
    }

    default void notifyObserver() {
        for (Observer o: observerArray)
        {
            o.update();
        }
    }

}
