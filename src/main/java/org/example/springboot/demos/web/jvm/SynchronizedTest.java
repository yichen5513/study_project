package org.example.springboot.demos.web.jvm;/*
 * @author      :  YC
 * @date        :  2026/9/14 15:14
 * @description :  some description
 */

public class SynchronizedTest {
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
//        addSafe();
        addUnSafe();
        System.out.println("1...");
    }

    public synchronized static void addSafe() throws InterruptedException {
        Thread[] threads = new Thread[10];
        int size = threads.length;
        for (int i = 0; i < size; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count += 100;
                System.out.println("count:"+count);
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public  static void addUnSafe() throws InterruptedException {
        Thread[] threads = new Thread[10];
        int size = threads.length;
        for (int i = 0; i < size; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count += 100;
                System.out.println("count:"+count);
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("最终count:"+count);
    }

}
