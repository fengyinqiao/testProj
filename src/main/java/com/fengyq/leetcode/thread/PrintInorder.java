package com.fengyq.leetcode.thread;

import java.util.concurrent.Semaphore;

public class PrintInorder {
	/*
	* LC1114. 按序打印
	* */
//	我们提供了一个类：
//	public class Foo {
//	  public void one() { print("one"); }
//	  public void two() { print("two"); }
//	  public void three() { print("three"); }
//	}
//	三个不同的线程将会共用一个 Foo 实例。
//	线程 A 将会调用 one() 方法
//	线程 B 将会调用 two() 方法
//	线程 C 将会调用 three() 方法
//	请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
//	示例 1:
//	输入: [1,2,3]
//	输出: "onetwothree"
//	解释:
//	有三个线程会被异步启动。
//	输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
//	正确的输出是 "onetwothree"。
//	示例 2:
//	输入: [1,3,2]
//	输出: "onetwothree"
//	解释:
//	输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
//	正确的输出是 "onetwothree"。
//	注意:
//		尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
//		你看到的输入格式主要是为了确保测试的全面性。
	static class Foo {
		Semaphore semaphore=new Semaphore(0);
		Semaphore semaphore2=new Semaphore(0);
	    public Foo() {
	        
	    }
	    public void first(Runnable printFirst) throws InterruptedException {
	    	// printFirst.run() outputs "first". Do not change or remove this line.
	    	printFirst.run();
	    	semaphore.release(1);
	    }
	    public void second(Runnable printSecond) throws InterruptedException {
	        semaphore.acquire(1);
	    	// printSecond.run() outputs "second". Do not change or remove this line.
	        printSecond.run();
	        semaphore2.release(1);
	    }
	    public void third(Runnable printThird) throws InterruptedException {
	        semaphore2.acquire(1);
	    	// printThird.run() outputs "third". Do not change or remove this line.
	        printThird.run();
	    }
	    static class Task implements Runnable {
	    	Foo foo;
	    	int order;
	    	public Task(Foo foo,int order) {
	    		this.foo=foo;
	    		this.order=order;
	    	}
	    	@Override
	    	public void run() {
	    		Runnable printFirst=new Runnable() {
	    			@Override
	    			public void run() {
	    				System.out.print("one");
	    			}
	    		};
	    		Runnable printSecond=new Runnable() {
	    			@Override
	    			public void run() {
	    				System.out.print("two");
	    			}
	    		};
	    		Runnable printThird=new Runnable() {
	    			@Override
	    			public void run() {
	    				System.out.print("three");
	    			}
	    		};
	    		if(order==1) {
	    			try {
	    				foo.first(printFirst);
	    			} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		}else if(order==2) {
	    			try {
	    				foo.second(printSecond);
	    			} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		}else if(order==3) {
	    			try {
	    				foo.third(printThird);
	    			} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		}
	    	}
	    }
	}
	public static void main(String[] args) {
		Foo foo=new Foo();
		int[] orders={1,3,2};
		new Thread(new Foo.Task(foo, orders[0])).start();
		new Thread(new Foo.Task(foo, orders[1])).start();
		new Thread(new Foo.Task(foo, orders[2])).start();
	}
}
