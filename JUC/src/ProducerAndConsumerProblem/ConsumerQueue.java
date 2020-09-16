package ProducerAndConsumerProblem;

import java.util.concurrent.BlockingQueue;

public class ConsumerQueue implements Runnable {
    BlockingQueue<Msg> queue;
    ConsumerQueue(BlockingQueue<Msg> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true){
                Msg msg = queue.take();
                System.out.println("消费一条消息: " + msg);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
