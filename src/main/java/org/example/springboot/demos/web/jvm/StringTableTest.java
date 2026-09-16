package org.example.springboot.demos.web.jvm;/*
 * @author      :  YC
 * @date        :  2026/9/16 12:17
 * @description :  some description
 */

public class StringTableTest {
    public static void main(String[] args) {
        String b = new String("ab")+new String("c");
        b.intern();
        String a = "abc";
        System.out.println(a == b);
    }
}