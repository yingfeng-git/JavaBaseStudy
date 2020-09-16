package ProducerAndConsumerProblem;

import java.util.concurrent.BlockingQueue;

public class ProducerQueue implements Runnable {
    BlockingQueue<Msg> queue;

    ProducerQueue(BlockingQueue<Msg> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Msg msg = new Msg(i, "消息" + i);
            try {
                queue.put(msg);
                System.out.println("放入一条消息: " + msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
