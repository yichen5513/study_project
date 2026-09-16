package org.example.springboot.demos.web.jvm;/*
 * @author      :  YC
 * @date        :  2026/9/15 12:17
 * @description :  some description
 */

public class DeadLockTest {
    static final Object lockA = new Object();
    static final Object lockB = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(DeadLockTest::getLock1,"线程1");
        Thread thread2 = new Thread(DeadLockTest::getLock2,"线程2");
        thread1.start();
        thread2.start();

    }

    public static void getLock1(){
        synchronized (lockA){
            System.out.println("获取到锁A...等待锁B");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lockB){
                System.out.println("获取到锁B...");
            }
        }
    }

    public static void getLock2(){
        synchronized (lockB){
            System.out.println("获取到锁B...等待锁A");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lockA){
                System.out.println("获取到锁A...");
            }
        }
    }

}
