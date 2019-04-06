package com.gupao.syn.instance;

/**
 * 多例
 */
public class PrototypeInstance {
    public PrototypeInstance(){

    }
    /**
     * 多例情况：
     *  synchronized 类锁
     *  当两个线程中多个实例调用对应的类锁方法 锁生效
     *
     */
    public static synchronized void demo1(){
        System.out.println("demo1");
    }
    public void demo2(){
        synchronized (PrototypeInstance.class){
            System.out.println("demo2");
        }
    }
    /***
     *  《Java多线程编程核心技术》对于同一个类A，线程1争夺A对象实例的对象锁，线程2争夺类A的类锁，这两者不存在竞争关系。也就说对象锁和类锁互补干预内政
     *  当调用demo1和demo3时没有竞争关系
     */
    /**
     * 多例情况：
     *  当两个线程分别用不同的对象调用不携带 static关键字的同步方法，锁不生效
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
