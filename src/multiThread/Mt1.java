package multiThread;

/**
 * Created by Ericwyn on 18-9-23.
 */
public class Mt1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    for (int i=0;i<10;i++){
                        System.out.println("线程1:"+i);
                        if (i == 5){
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (thread1){
                    for (int i=0;i<10;i++){
                        System.out.println("线程2:"+i);
                        if (i == 5){
                            thread1.notify();
                        }
                    }
                }

            }
        });

        thread1.start();
        thread2.start();
    }

}
