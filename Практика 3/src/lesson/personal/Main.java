package lesson.personal;

import java.time.temporal.Temporal;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        LockContainerApplication lCApp = new LockContainerApplication();

        Thread t1 = new Thread(lCApp);
        Thread t2 = new Thread(lCApp);


        t1.start();
        t2.start();

    }


}

// You need prog 'unlock' in main or in app to unlock Thread.
class LockContainerSet<T> implements Set {

    protected Lock lock = new ReentrantLock();

    @Override
    public int size() {
        this.lock.lock();
        return 0;
    }

    @Override
    public boolean isEmpty() {
        this.lock.lock();
        return false;
    }

    @Override
    public boolean contains(Object o) {
        this.lock.lock();
        return false;
    }

    @Override
    public Iterator iterator() {
        this.lock.lock();
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        this.lock.lock();
    }

    @Override
    public Object[] toArray() {
        this.lock.lock();
        return new Object[0];
    }

    @Override
    public Object[] toArray(IntFunction generator) {
        this.lock.lock();
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        this.lock.lock();
        System.out.println("Has been added " + o.toString());
        return false;
    }

    @Override
    public boolean remove(Object o) {
        this.lock.lock();
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        this.lock.lock();
        return false;
    }

    @Override
    public boolean removeIf(Predicate filter) {
        this.lock.lock();
        return false;
    }

    @Override
    public void clear() {
        this.lock.lock();
    }

    @Override
    public Spliterator spliterator() {
        this.lock.lock();
        return null;
    }

    @Override
    public Stream stream() {
        this.lock.lock();
        return null;
    }

    @Override
    public Stream parallelStream() {
        this.lock.lock();
        return null;
    }

    @Override
    public boolean removeAll(Collection c) {
        this.lock.lock();
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        this.lock.lock();
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        this.lock.lock();
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        this.lock.lock();
        return new Object[0];
    }

    public void unlockSet() {
        this.lock.unlock();
    }
}