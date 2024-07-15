package work;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {

    private Semaphore sem;

    public MyThread( String threadName, Semaphore sem) {
        super(threadName);
        this.sem = sem;
    }

    @Override
    public void run() {
        System.out.println("Поток '" + getName() + "' начался и ожидает семафор.");
        try {
            sem.acquire();
            System.out.println("Поток '" + getName() + "' захватывает семафор.");
            System.out.println("Поток '" + getName() + "' в семафоре.");
            System.out.println("Переменная семафора равна: " + sem.drainPermits() + ". Поток '" + getName() + "' выходит из семафора.");
            sem.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
