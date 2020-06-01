package org.example.guardian.snackshak;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SnackShack {
    private static  ScheduledExecutorService sc;
    private boolean isMaking;
    private Runnable serve;
    private static ScheduledFuture<?> scheduledFuture;
    private static int count;

    public static void main(String args[]) {
        SnackShack snackShack = new SnackShack();
        snackShack.takeOrder(3);
        snackShack.takeOrder(2);
        //snackShack.stop();
    }

    public int getCount() {
        return count;
    }

    public SnackShack() {
        sc = Executors.newScheduledThreadPool(1);
    }

    public void takeOrder(int num) {
        count += num;
        start();
    }

    private void start() {
        if (count > 0 && !isMaking) {
            isMaking = true;
            scheduledFuture = sc.scheduleAtFixedRate(makeBurger(), 3, 3, TimeUnit.SECONDS);

        }
    }

    private static Runnable makeBurger() {
        AtomicInteger num = new AtomicInteger(1);
        return () -> {
            System.out.println("make sandwich:" + num.get());
            sc.schedule(()-> System.out.println("serve sandwich" + num.getAndIncrement()), 1, TimeUnit.SECONDS);
            count--;

            if(count == 0){
                System.out.println("Shutting down");
                scheduledFuture.cancel(true);
                sc.shutdown();
            }
        };
    }

    /*public void stop() {
        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 0) {
                System.out.println("cancel the scheduledFuture!");
                scheduledFuture.cancel(true);
                sc.shutdown();
                break;
            }
        }

    }*/
}
