/**
 * Utility to print from 0 to 5
 */
class PrintUtilExample3 {

    //object to store the synchronized lock
    final Object lockObject = new Object();

    /**
     * Function to print numbers from 0 to 5
     */
    public void printNumbers() {
        synchronized(lockObject) {
            for (int i = 0; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * Thread worker
 */
class RunnableWorkerExample3 implements Runnable {
    PrintUtilExample3 pu3;
    public  RunnableWorkerExample3(PrintUtilExample3 pu3){
        this.pu3 = pu3;
    }
    @Override
    public void run() {
        pu3.printNumbers();
    }
}

/**
 * Main Class
 */
public class SynchronizedCustomObjectDemo {
    public static void main(String[] args) {
        PrintUtilExample3 pu3 = new PrintUtilExample3();
        Runnable r = new RunnableWorkerExample3(pu3);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
    }
}