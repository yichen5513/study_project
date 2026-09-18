package org.example.springboot.demos.web.interview.oop;/*
 * @author      :  YC
 * @date        :  2026/9/18 19:00
 * @description :  some description
 */

public class Dog extends Animal{
    String name = "子类名字";

    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name+"吃鸡腿...");
    }
}
