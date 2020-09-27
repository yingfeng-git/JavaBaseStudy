package ThreadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 可调度线程池，做定时任务用
 */
public class ScheduleThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        /**
         * 每3秒执行一次
         */
//        scheduledExecutorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("延迟2秒执行");
//            }
//        }, 2, TimeUnit.SECONDS);
//
//        scheduledExecutorService.shutdown();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟1秒执行，每3秒执行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }
}
