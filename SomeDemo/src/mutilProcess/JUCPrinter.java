package mutilProcess;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUCPrinter {
    Lock lock = new ReentrantLock(true);

    Thread thread1 = new Thread(()->{
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            lock.lock();
            System.out.println(c++);
            lock.unlock();
        }
    });

    Thread thread2 = new Thread(()->{
        int c = 1;
        for (int i = 0; i < 26; i++) {
            lock.lock();
            System.out.println(c++);
            lock.unlock();
        }
    });

    public static void main(String[] args) {
        JUCPrinter jucPrinter = new JUCPrinter();
        jucPrinter.thread1.start();
        jucPrinter.thread2.start();
    }
}
