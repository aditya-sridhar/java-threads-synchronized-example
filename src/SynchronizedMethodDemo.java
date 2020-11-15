/**
 * Utility to print numbers from 0 to 5
 */
class PrintUtil {
    /**
     * Function to print numbers from 0 to 5
     */
    public synchronized void printNumbers() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                //simulates delay
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
class RunnableWorker implements Runnable {
    PrintUtil pu;
    public RunnableWorker(PrintUtil pu) {
        this.pu = pu;
    }

    @Override
    public void run() {
        pu.printNumbers();
    }
}

/**
 * Main Class
 */
public class SynchronizedMethodDemo {
    public static void main(String[] args) {
        PrintUtil pu = new PrintUtil();
        Runnable r = new RunnableWorker(pu);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
    }
}