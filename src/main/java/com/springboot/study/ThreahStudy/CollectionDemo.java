package com.springboot.study.ThreahStudy;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionDemo {

    public static void main(String[] args) {
        List list = new CopyOnWriteArrayList();//new ArrayList();

        for (int i = 0; i <30 ; i++) {
            new Thread(()->{

                list.add("a");
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
