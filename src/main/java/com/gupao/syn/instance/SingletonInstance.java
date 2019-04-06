package com.gupao.syn.instance;

/**
 * static synchronized synchronized (类.class):类锁
 * synchronized：对象锁
 * synchronized(this) synchronized(Object) synchronized method:对象锁
 */
public class SingletonInstance {
    private static SingletonInstance instance = new SingletonInstance();
    private SingletonInstance(){}
    public static SingletonInstance getInstance(){
        return instance;
    }

    /**
     * 单例情况：
     *  synchronized 类锁
     *  当两个线程调用对应的static synchronized的不同方法锁生效
     *
     */
    public static synchronized void demo1(){
        System.out.println("demo1");
    }
    public void demo2(){
        synchronized (SingletonInstance.class){
            System.out.println("demo2");
        }
    }
    /***
     * 问题：单例情况下static 和 未带static的方法锁未生效
     *  《Java多线程编程核心技术》对于同一个类A，线程1争夺A对象实例的对象锁，线程2争夺类A的类锁，这两者不存在竞争关系。也就说对象锁和类锁互补干预内政
     *  当调用demo1和demo3时没有竞争关系
     */
    /**
     * 单例情况：
     *  当两个线程分别调用不携带 static关键字的同步方法，锁依然生效
     *  锁在某一个实例对象上，如果该类是单例，那么该锁也具有全局锁的概念
     */
    public void demo3(){
        synchronized (this){
            System.out.println("demo3");
        }
    }
    public synchronized void demo4(){
        System.out.println("demo4");
    }
}
