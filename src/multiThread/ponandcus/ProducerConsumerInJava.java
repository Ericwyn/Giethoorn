package multiThread.ponandcus;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 简单的消费者、生成者问题的多线程
 *
 * 1. 你可以使用wait和notify函数来实现线程间通信。你可以用它们来实现多线程（>3）之间的通信。
 *
 * 2. 永远在synchronized的函数或对象里使用wait、notify和notifyAll，不然Java虚拟机会生成 IllegalMonitorStateException。
 *
 * 3. 永远在while循环里而不是if语句下使用wait。这样，循环会在线程睡眠前后都检查wait的条件，并在条件实际上并未改变的情况下处理唤醒通知。
 *
 * 4. 永远在多线程间共享的对象（在生产者消费者模型里即缓冲区队列）上使用wait。
 *
 * 5. 基于前文提及的理由，更倾向用 notifyAll()，而不是 notify()。
 *
 * Created by Ericwyn on 18-9-23.
 */
public class ProducerConsumerInJava {
    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 20;
        Thread product = new Producer(buffer,maxSize,"PRODUCT-1");
        Thread product2 = new Producer(buffer,maxSize,"PRODUCT-2");

        Thread customer = new Customer(buffer,maxSize,"CUSTOMER");
        product2.start();
        product.start();
        customer.start();
    }

}
