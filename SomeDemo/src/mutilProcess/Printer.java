package mutilProcess;


public class Printer{

    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread(()->{
            char i = 'A';
            for(int j=0; j<26; j++) {
                synchronized (o) {
                    System.out.println(i);
                    i++;
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(()->{
            int i = 1;
            for (int j = 0; j < 26; j++)
                synchronized (o) {
                System.out.println(i);
                i++;
                o.notify();
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
