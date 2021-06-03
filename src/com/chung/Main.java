package com.chung;

import java.io.*;
import java.util.*;

public class Main {

    public static class MyThread1 extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("hello thread1!");
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                System.out.println("i am interrupted!");
            }
        }

    }

    public static class MyThread2 implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("hello thread2!");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("i am interrupted!");
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //상속받는 방법
        MyThread1 thread1 = new MyThread1();
//        thread1.start();

        //runnable 구현하는 방법
        Thread thread2 = new Thread(new MyThread2());
//        thread2.start();

        //람다식 이용하기
        Runnable task = () -> {
            try {
                int i = 0;
                while (i < 5) {
                    i++;
                    System.out.println("hello thread3!");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("i am interrupted!");
            }
        };

        Thread thread3 = new Thread(task);
//        thread3.start();

/*
        try {
            System.out.println("parent is wait you!!");
            thread3.join(); //부모쓰레드는 여기서 대기
        } catch (InterruptedException e) {
            System.out.println("parent interrupted");
        }
*/

        thread2.start();
        Thread.sleep(5000);
        thread2.interrupt();

        System.out.println("hello my child!");


    }
}
