package org.example.springboot.demos.web.jvm;/*
 * @author      :  YC
 * @date        :  2026/9/16 15:37
 * @description :  some description
 */

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

public class GcTest {
    public static void main(String[] args) throws InterruptedException {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryMXBean.getHeapMemoryUsage();

        System.out.printf("初始化堆内存: %d MB%n", heapUsage.getInit() / 1024 / 1024);
        System.out.printf("已使用堆内存: %d MB%n", heapUsage.getUsed() / 1024 / 1024);
        System.out.printf("已提交堆内存: %d MB%n", heapUsage.getCommitted() / 1024 / 1024);
        System.out.printf("最大堆内存:   %d MB%n", heapUsage.getMax() / 1024 / 1024);

        List<byte[]> list = new ArrayList<>();
        try {
            // 1. 不断往 List 中放入 1MB 大小的字节数组，占满堆内存
            for (int i = 0; i < 400; i++) {
                // 每次分配 1MB
                list.add(new byte[1024 * 1024]);
            }
        } catch (OutOfMemoryError e) {
            System.out.println("【第一阶段】堆内存已满，即将尝试触发 Full GC...");
            System.out.println("此时 List 中持有约 " + list.size() + " MB 存活数据。");

            // 2. 短暂休眠 3 秒，给你时间切换终端去运行 jstat 命令
            Thread.sleep(10000);

            // 3. 显式调用 Full GC
            System.out.println("正在执行 System.gc()...");
            System.gc();

            Thread.sleep(2000);
            System.out.println("Full GC 执行完毕。由于 List 强引用存活，内存并未被释放。");
            // 继续分配，最终导致 JVM 抛出 OOM 异常
            list.add(new byte[1024 * 1024]);
        }
    }
}
