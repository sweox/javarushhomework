package test.runThreads;

/**
 * Created by Belshina on 09.03.16.
 */
public class RunThreads implements Runnable
{
    public static void main(String[] args)
    {
        RunThreads runner = new RunThreads();
        Thread alfa = new Thread(runner);
        Thread beta = new Thread(runner);
        alfa.setName("thread alfa");
        alfa.start();
        beta.start();
    }
    public void run() {
        for (int i = 0; i < 250; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}
