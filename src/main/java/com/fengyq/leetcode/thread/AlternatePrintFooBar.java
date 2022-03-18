package com.fengyq.leetcode.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/*
* 1115. 交替打印FooBar
* 我们提供一个类：
class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }
  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
请设计修改程序，以确保 "foobar" 被输出 n 次。
示例 1:
输入: n = 1
输出: "foobar"
解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。

示例 2:
输入: n = 2
输出: "foobarfoobar"
解释: "foobar" 将被输出两次。
* */
//4种解法，熟练掌握线程间通信
public class AlternatePrintFooBar {
    //解法1：信号量
    static class FooBar {
        private int n;
        Semaphore semaphore = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                semaphore.acquire(1);
                printFoo.run();
                semaphore2.release(1);
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                semaphore2.acquire(1);
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                semaphore.release(1);
            }
        }
    }

    //解法2：闭锁，需要注意闭锁没有重置功能，一旦打开，就要重置，否则下次再用就会有问题。可以用回环栅栏替代，见解法3
    static class FooBar2 {
        private int n;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                countDownLatch2.countDown();
                countDownLatch.await();
                countDownLatch = new CountDownLatch(1);//闭锁一旦打开，就要重置，否则下次再用就会有问题
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                countDownLatch2.await();
                countDownLatch2 = new CountDownLatch(1);
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                countDownLatch.countDown();
            }
        }
    }

    //解法3：回环栅栏，内部有“更新换代”的重置功能，忘了的再去翻翻aqs源码，加深记忆
    static class FooBar3 {
        private int n;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);

        public FooBar3(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                try {
                    cyclicBarrier2.await();
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                try {
                    cyclicBarrier2.await();
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    cyclicBarrier.await();
                } catch (BrokenBarrierException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }

    //解法4：volatile，两个特点：1>保证并发可见性 2>插入内存屏障，禁止jvm指令重排。但这解法会超时，原因未知！
    static class FooBar4 {
        private int n;
        volatile boolean flag;

        public FooBar4(int n) {
            this.n = n;
            this.flag = false;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (flag) {
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = true;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (!flag) {
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = false;
            }
        }
    }

    //测试案例：
    public static void main(String[] args) {
//		final FooBar foobar=new FooBar(10);
//		final FooBar2 foobar=new FooBar2(10);
//		final FooBar3 foobar=new FooBar3(10);
        final FooBar4 foobar = new FooBar4(10);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foobar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foobar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("bar ");
                        }
                    });
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t1.start();
    }
}
