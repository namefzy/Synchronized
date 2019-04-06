package com.gupao.syn;

import com.gupao.syn.instance.PrototypeInstance;
import com.gupao.syn.instance.SingletonInstance;

public class MyThread1 implements Runnable{
    public void run() {
        PrototypeInstance instance = new PrototypeInstance();
        instance.demo4();
    }
}
