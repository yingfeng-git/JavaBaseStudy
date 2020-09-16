package ThreadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个简单的线程池使用的Demo
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        // 最多池子里有5个线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
