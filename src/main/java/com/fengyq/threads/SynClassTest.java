package com.fengyq.threads;

import java.util.Vector;

public class SynClassTest {
    static String s = new String();

    synchronized static void m() {
        System.out.println("SynClassTest.m() beg");
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SynClassTest.m() end");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SynClassTest.m();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (SynClassTest.s) {
                    System.out.println("SynClassTest.s beg");
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("SynClassTest.s end");
                }
            }
        });
        //t1.start();
        //t2.start();
        final Vector vector = new Vector<>();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    vector.add("s");
                    vector.remove("s");
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    int size=vector.size();
                    if(size>0) {
                        System.out.println(vector.get(size - 1));
                    }
                }
            }
        });
        t3.start();
        t4.start();
    }
}
