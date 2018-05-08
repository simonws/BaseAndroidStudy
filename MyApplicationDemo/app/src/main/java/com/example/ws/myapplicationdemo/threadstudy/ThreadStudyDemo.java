package com.example.ws.myapplicationdemo.threadstudy;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by ws on 18-2-24.
 */

public class ThreadStudyDemo extends Activity {
    private static final String TAG = "ThreadStudy_Demo";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(android.R.layout.list_content);
        super.onCreate(savedInstanceState);
//        new Thread1().start();
//        new Thread2().start();
//        testBarrier();
        Thread yieldThread1 = new YieldThread("yield1");
        Thread yieldThread2 = new YieldThread("yield2");
        yieldThread1.start();
        yieldThread2.start();
    }

    public void testCountDownLatch(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new CountDownReadNum(i, countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println("线程执行结束。。。。");
    }

    static class CountDownReadNum implements Runnable {
        private int id;
        private CountDownLatch latch;

        public CountDownReadNum(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("id:" + id);
                latch.countDown();
                System.out.println("线程组任务" + id + "结束，其他任务继续");
            }
        }
    }

    private void testBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "线程组执行结束");
            }
        });
        for (int i = 0; i < 10; i++) {
            new Thread(new CyclicBarrierReadNum(i, cyclicBarrier)).start();
        }
        // CyclicBarrier 可以重复利用，
        // 这个是CountDownLatch做不到的
//        for (int i = 11; i < 16; i++) {
//            new Thread(new CyclicBarrierReadNum(i, cyclicBarrier)).start();
//        }
    }

    static class CyclicBarrierReadNum implements Runnable {
        private int id;
        private CyclicBarrier cyc;

        public CyclicBarrierReadNum(int id, CyclicBarrier cyc) {
            this.id = id;
            this.cyc = cyc;
        }

        @Override
        public void run() {
            synchronized (this) {
                Log.d(TAG, "id:" + id);
                try {
                    cyc.await();
                    Log.d(TAG, "线程组任务" + id + "结束，其他任务继续");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (ThreadStudyDemo.this) {
                    Log.d(TAG, "Thread1 run");
                    try {
                        ThreadStudyDemo.this.notify();
                        ThreadStudyDemo.this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Thread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                while (true) {
                    synchronized (ThreadStudyDemo.this) {
                        Log.d(TAG, "Thread2 run");
                        try {
                            ThreadStudyDemo.this.notify();
                            ThreadStudyDemo.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    class YieldThread extends Thread {
        YieldThread(String s) {
            super(s);
        }

        public void run() {
            for (int i = 0; i <= 30; i++) {
                Log.d(TAG, getName() + ":" + i);
                if (("t1").equals(getName())) {
                    if (i == 0) {
                        yield();
                    }
                }
            }
        }

    }

    private void testIntercept() {
        MyThread thread = new MyThread();
        thread.start(); // 开启线程
//        thread.cancel(); // 中断线程
        Log.d(TAG, "onCreate InterruptedException " + thread.isInterrupted() + " == "
                + Thread.currentThread().getState());
    }

    class MyThread extends Thread {
        public void run() {
            int i = 0;
            try {
                while (!Thread.currentThread().isInterrupted()) { // 如果线程没有被中断就继续运行
                    // 阻塞代码：sleep,wait等
                    // 当其他线程，调用此线程的interrupt()方法时，会给此线程设置一个中断标志
                    // sleep,wait等方法会检测这个标志位，同时会抛出InterruptedException，并清除线程的中断标志
                    // 因此在异常段调用Thread.currentThread().isInterrupted()返回为false
                    if (i > 1) {
                        interrupt();
                    }
                    Log.d(TAG, "run InterruptedException 22 " + " == " + Thread.currentThread().getState());
                    Thread.currentThread().sleep(2000);
                    Log.d(TAG, "run InterruptedException 33 " + " == " + Thread.currentThread().getState());
                    i++;
                }
            } catch (InterruptedException e) {
                // 由于阻塞库函数，如：Object.wait,Thread.sleep除了抛出异常外，还会清除线程中断状态，因此可能在这里要保留线程的中断状态
                Log.d(TAG, "run InterruptedException 00 " + isInterrupted() + " == "
                        + Thread.currentThread().getState());
                Thread.currentThread().interrupt();// 从新设置线程的中断标志
            }

            Log.d(TAG, "run InterruptedException 11 " + isInterrupted() + " == "
                    + Thread.currentThread().getState());
        }

        public void cancel() {
            interrupt(); // 中断线程
        }
    }

}
