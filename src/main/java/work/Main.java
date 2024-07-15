package work;

import java.util.concurrent.Semaphore;

public class Main {
    public static synchronized void main(String[] args) throws InterruptedException {

        Semaphore sem1 = new Semaphore(1, true);
        Semaphore sem2 = new Semaphore(3, true);
        Semaphore sem3 = new Semaphore(3, true);
        Semaphore sem4 = new Semaphore(3, true);
        MyThread A = new MyThread("А", sem1);
        MyThread B = new MyThread("B", sem2);
        MyThread C = new MyThread("C", sem2);
        MyThread D = new MyThread("D", sem3);
        MyThread E = new MyThread("E", sem3);
        MyThread F = new MyThread("F", sem3);
        MyThread G = new MyThread("G", sem4);
        MyThread H = new MyThread("H", sem4);
        MyThread K = new MyThread("K", sem4);
        MyThread J = new MyThread("J", sem2);
        MyThread I = new MyThread("I", sem4);


        A.start();

        Thread.sleep(300);
        System.out.println(" ");
        for (int i = 0; i < 3; i++) sem4.acquire();
        B.start();
        C.start();
        J.start();
        I.start();

        Thread.sleep(300);
        System.out.println(" ");
        D.start();
        E.start();
        F.start();

        Thread.sleep(300);
        System.out.println(" ");
        for (int i = 0; i < 3; i++)sem4.release();
        G.start();
        H.start();

        Thread.sleep(300);
        System.out.println(" ");
        K.start();
    }
}

