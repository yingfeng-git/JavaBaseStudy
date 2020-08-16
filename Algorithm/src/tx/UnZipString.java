package tx;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Thread1 extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("1");
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                notify();
            }
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("2");
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                notify();
            }
        }
    }
}

public class UnZipString {
    static String result = "";
    public static void main(String[] args) throws InterruptedException {
        String code = "HG[3|B[2|CA]]FHG[3|BCACA]FHGBCACABCACABCACAF";
        Object lock1 = new Object();

        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
