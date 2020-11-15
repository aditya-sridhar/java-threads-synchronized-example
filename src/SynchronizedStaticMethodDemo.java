/**
 * Utility to print numbers from 0 to 5
 */
class PrintUtilExample2 {
    /**
     * Function to print numbers form 0 to 5
     */
    public static synchronized void printNumbers() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                //Sleep is used to simulate delay in thread operations
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * Thread worker
 */
class RunnableWorkerExample2 implements Runnable {
    @Override
    public void run() {
        PrintUtilExample2.printNumbers();
    }
}

/**
 * Main Class
 */
public class SynchronizedStaticMethodDemo {
    public static void main(String[] args) {
        Runnable r = new RunnableWorkerExample2();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
    }
}