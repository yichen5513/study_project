package org.example.springboot.demos.web.interview;/*
 * @author      :  YC
 * @date        :  2026/9/18 13:08
 * @description :  some description
 */

import java.util.ArrayList;
import java.util.List;

public class CattleCount {
    public static void main(String[] args) {
        List<Cow> farm = new ArrayList<>();
        // 第0年，初始母牛，age=0
        farm.add(new Cow("母牛", 0));
        int totalYear = 16;

        for (int year = 1; year <= totalYear; year++) {
            System.out.println("===== 第" + year + "年 =====");
            List<Cow> newBorn = new ArrayList<>();

            // 1.所有牛年龄+1
            for (Cow cow : farm) {
                cow.setAge(cow.getAge() + 1);
            }

            // 2.遍历农场所有牛，判断是否生育
            for (Cow cow : farm) {
                if (cow.canBear(year)) {
                    cow.bear();
                    // 小牛刚出生 age=0
                    Calf calf = new Calf(cow.getName() + "--小牛" + year, 0);
                    newBorn.add(calf);
                    cow.setLastBearYear(year); // 更新本次生育年份
                }
            }
            // 3.新生小牛加入农场
            farm.addAll(newBorn);
            System.out.println();
        }

        System.out.println("16年后农场总牛数：" + farm.size());
    }





}
