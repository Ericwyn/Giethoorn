package multiThread.ponandcus;

import java.util.Queue;

/**
 * Created by Ericwyn on 18-9-23.
 */
public class Customer extends Thread {

    private Queue<Integer> queue;
    private int maxSize;
    public Customer(Queue<Integer> queue,int maxSize,String name){
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while (queue.isEmpty()){
                    System.out.println("队列已经空了，消费者线程停下来了");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者消费了"+queue.remove());
                queue.notifyAll();
            }
        }
    }
}
