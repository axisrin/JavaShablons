package lesson.personal;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockContainerApplication extends LockContainerSet implements Runnable {

    LockContainerSet<String> lockContainerSet = new LockContainerSet<String>();
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        Set<String> names = lockContainerSet;
        try {
            if (this.lock.tryLock(10, TimeUnit.MILLISECONDS)) {

                System.out.println("Thread has been Started and Locked");

                //Here you should write what do you want to do with your programm.
                //After every operation you should write 'lockContainerSet.unlockSet();'.
                lockContainerSet.add("1 Pi Jay");
                lockContainerSet.unlockSet();
                lockContainerSet.add("2 Jeremmy");
                lockContainerSet.unlockSet();
                lockContainerSet.add("3 Frank");
                lockContainerSet.unlockSet();
                lockContainerSet.add("4 Hajima");
                lockContainerSet.unlockSet();
                lockContainerSet.add("5 Nemphis");
                lockContainerSet.unlockSet();
                lockContainerSet.add("6 Judie");
                lockContainerSet.unlockSet();
                lockContainerSet.add("7 Calwin");
                lockContainerSet.unlockSet();
                lockContainerSet.add("8 Magy");
                lockContainerSet.unlockSet();
                lockContainerSet.add("9 Danny");
                lockContainerSet.unlockSet();
                lockContainerSet.add("10 Kennedy");
                lockContainerSet.unlockSet();
                lockContainerSet.add("11 Morph");
                lockContainerSet.unlockSet();
                lockContainerSet.add("12 Fazie");
                lockContainerSet.unlockSet();
                lockContainerSet.add("13 Catchap");
                lockContainerSet.unlockSet();
                lockContainerSet.add("14 Hornie");
                lockContainerSet.unlockSet();
                lockContainerSet.add("15 Josh");
                lockContainerSet.unlockSet();
                lockContainerSet.add("16 Barbara");
                lockContainerSet.unlockSet();
                lockContainerSet.add("17 Woofle");
                lockContainerSet.unlockSet();
                lockContainerSet.add("18 Nuck");
                lockContainerSet.unlockSet();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread has been Finished and UnLocked");
            this.lock.unlock();
        }
    }
}
