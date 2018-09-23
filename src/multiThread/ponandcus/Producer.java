package multiThread.ponandcus;

import java.util.Queue;
import java.util.Random;

/**
 * Created by Ericwyn on 18-9-23.
 */
public class Producer extends Thread{
    private int count = 1;
    private Queue<Integer> queue;
    private int maxSize;
    public Producer(Queue<Integer> queue,int maxSize, String name){
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true){
            // 以需要作为同步变量的那个对象来作为锁
            synchronized (queue){
                while (queue.size() == maxSize){
                    System.out.println("队列已经满了，生成者停下来了");
                    try {
                        // 对锁头调用 wait() 方法
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("生产者"+getName()+"生成了第 "+count+" 产品 "+ i);
                queue.add(i);
                queue.notifyAll();
                if (count++ == 30){
                    break;
                }
            }
        }

    }
}
