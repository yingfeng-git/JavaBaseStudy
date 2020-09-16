package ProducerAndConsumerProblem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Msg> queue = new ArrayBlockingQueue<>(5);
        ProducerQueue producerQueue = new ProducerQueue(queue);
        ConsumerQueue consumerQueue = new ConsumerQueue(queue);

        Thread t1 = new Thread(producerQueue);
        Thread t2 = new Thread(consumerQueue);

        t1.start();
        t2.start();
    }
}
