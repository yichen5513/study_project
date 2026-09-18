package org.example.springboot.demos.web.interview.oop;/*
 * @author      :  YC
 * @date        :  2026/9/18 18:58
 * @description :  some description
 */

public class Animal {
    String name = "父类名字";

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    public void eat(){
        System.out.println(name+"吃东西...");
    }
}
