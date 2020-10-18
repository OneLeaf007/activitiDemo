package com.springboot.study.JvmStudy;

public class JvmDemo {

    public static void main(String[] args) {

        System.out.println("hello gc");
        try {
            Thread.sleep(200000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
