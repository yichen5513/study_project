package org.example.springboot.demos.web.interview;

import lombok.Data;

/*
 * @author      :  YC
 * @date        :  2026/9/18 13:01
 * @description :  这是母牛的类
 */
@Data
public class Cow {
    private String name;
    private int age;
    public int lastBearYear;

    public Cow() {
    }

    public Cow(String name,int age) {
        this.name = name;
        this.age = age;
        this.lastBearYear = -1; // -1代表从未生育
    }

    public void bear(){
        System.out.println(name+"生了头小牛");
    }

    // 判断当前年份能不能生小牛
    public boolean canBear(int currentYear) {
        // 年龄>=3岁，并且距离上次生育间隔>=3年
        return (age >= 3) && (currentYear-lastBearYear >= 3);
    }
}
