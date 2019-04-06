package com.gupao.syn;

public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread1());
        thread1.start();
        thread2.start();
    }
}
