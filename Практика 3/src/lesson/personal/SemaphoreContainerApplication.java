package lesson.personal;

import java.util.concurrent.Semaphore;

public class SemaphoreContainerApplication extends SemaphoreContainerMap implements Runnable{

    //Here is your nums of semaphores!
    Semaphore appSemaphore = new Semaphore(1);

    //Create the super semaphore!
    SemaphoreContainerMap<Integer,String> passNames = new SemaphoreContainerMap<>(appSemaphore);

    SemaphoreContainerApplication(Semaphore appSemaphore) {
        super(appSemaphore);
    }

    @Override
    public void run() {

        //Start YourCode!
        try {
            this.appSemaphore.acquire();

            System.out.println("Thread Has acessed and simaphore is done!");

            //Write your code!
            passNames.put(505704,"Jennifer Wotson");
            passNames.put(905595,"Melmon Hamfree");
            passNames.put(888777,"Walk Ganwinston");
            passNames.put(905595,"Jarles Sink");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread Has ended and simaphore is realesed!");
            this.appSemaphore.release();
        }

    }
}
