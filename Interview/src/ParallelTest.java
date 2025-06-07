import java.time.Instant;

/**
 * @author mithl
 * @date 30-03-2025
 * @email mithleshshah84@gmail.com
 */
public class ParallelTest {

    public static void main(String[] args) {
       // threadTest();
        runnableTest();
    }

    public static void threadTest() {
        Thread t = new Thread (() -> {
            for(int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 1: " +i);
            }
        });

        Thread t2 = new Thread (() -> {
            for(int i = 5; i < 10; i++) {
                System.out.println("Thread 2: " + i);
            }
        });
    }

    public static void runnableTest() {

        Runnable r1 = () -> {
            for(int i = 0; i < 5; i++) {
                System.out.println("Running in runnable test: Thread 1: " +i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable r2 = () -> {
            for(int i = 5; i < 10; i++) {
                System.out.println("Running in runnable test: Thread 2: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t = new Thread(r1);
        Thread t2 = new Thread(r2);

        t.start();
        t2.start();


        

    }
}
