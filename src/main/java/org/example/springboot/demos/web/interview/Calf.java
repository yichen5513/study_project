package org.example.springboot.demos.web.interview;/*
 * @author      :  YC
 * @date        :  2026/9/18 13:06
 * @description :  这是小牛的类
 */

import lombok.Data;

@Data
public class Calf extends Cow{

    public Calf() {
    }

    public Calf(String name,int age) {
        super(name,age);
        System.out.println("小牛【"+name+"】出生了...");
    }

    @Override
    public void bear() {
        System.out.println(getName()+"生了头小牛");
    }
}
