import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < 4; i++) {
            // add，放到尾巴
            deque.add(i);
            System.out.println(deque);

            // offer，放到尾巴
            deque.offer(i);
            System.out.println(deque);

            // push，头插法
            deque.push(i);
            System.out.println(deque);
        }

        // peek，看一眼头
        System.out.println(deque.peek());
        System.out.println(deque);

        // poll，删除并返回头
        System.out.println(deque.poll());
        System.out.println(deque);

        // pop，删除并返回头会抛异常
        System.out.println(deque.pop());
        System.out.println(deque);

        // remove，换皮的pop
        System.out.println(deque.remove());
        System.out.println(deque);

        /**
         * 总结：删除和插入两类方法：
         *     插入：add，添加到尾部，offer，添加到尾部
         */
    }
}
