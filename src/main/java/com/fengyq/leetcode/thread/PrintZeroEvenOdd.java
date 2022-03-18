package com.fengyq.leetcode.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

//相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
//线程 A 将调用 zero()，它只输出 0 。
//线程 B 将调用 even()，它只输出偶数。
//线程 C 将调用 odd()，它只输出奇数。
//每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，
//其中序列的长度必须为 2n。
public class PrintZeroEvenOdd {
	static interface IntConsumer{
    	public void accept(int x);
    }
	static class ZeroEvenOdd {
	    private int n;
	    Semaphore semaphore=new Semaphore(0);
	    Semaphore semaphore2=new Semaphore(0);
	    Semaphore semaphore3=new Semaphore(0);
	    
	    public ZeroEvenOdd(int n) {
	        this.n = n;
	    }

	    // printNumber.accept(x) outputs "x", where x is an integer.
	    public void zero(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		printNumber.accept(0);
	    		semaphore3.release(1);
	    		semaphore.acquire(1);
	    	}
	    }

	    public void odd(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		semaphore3.acquire(1);
	    		if(i%2!=0) {
	    			printNumber.accept(i);
	    		}
	    		semaphore2.release(1);
			}
	    }
	    
	    public void even(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		semaphore2.acquire(1);
	    		if(i%2==0) {
	    			printNumber.accept(i);
	    		}
	    		semaphore.release(1);
			}
	    }
	}
	static class ZeroEvenOdd2 {
	    private int n;
	    CountDownLatch countDownLatch=new CountDownLatch(1);
		CountDownLatch countDownLatch2=new CountDownLatch(1);
		CountDownLatch countDownLatch3=new CountDownLatch(1);
	    
	    public ZeroEvenOdd2(int n) {
	        this.n = n;
	    }

	    // printNumber.accept(x) outputs "x", where x is an integer.
	    public void zero(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		printNumber.accept(0);
	    		countDownLatch3.countDown();
	    		countDownLatch.await();
	    		countDownLatch=new CountDownLatch(1);
	    	}
	    }

	    public void odd(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		countDownLatch3.await();
	    		countDownLatch3=new CountDownLatch(1);
	    		if(i%2!=0) {
	    			printNumber.accept(i);
	    		}
	    		countDownLatch2.countDown();
			}
	    }
	    
	    public void even(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		countDownLatch2.await();
	    		countDownLatch2=new CountDownLatch(1);
	    		if(i%2==0) {
	    			printNumber.accept(i);
	    		}
	    		countDownLatch.countDown();
			}
	    }
	}
	static class ZeroEvenOdd3 {
	    private int n;
	    CyclicBarrier zero_odd=new CyclicBarrier(2);
	    CyclicBarrier odd_even=new CyclicBarrier(2);
	    CyclicBarrier zero_even=new CyclicBarrier(2);
	    
	    public ZeroEvenOdd3(int n) {
	        this.n = n;
	    }

	    // printNumber.accept(x) outputs "x", where x is an integer.
	    public void zero(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		printNumber.accept(0);
	    		try {
					zero_odd.await();
					zero_even.await();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }

	    public void odd(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		try {
					zero_odd.await();
					if(i%2!=0) {
		    			printNumber.accept(i);
		    		}
		    		odd_even.await();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    }
	    
	    public void even(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		try {
					odd_even.await();
					if(i%2==0) {
		    			printNumber.accept(i);
		    		}
		    		zero_even.await();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    }
	}
	static class ZeroEvenOdd4 {
	    private int n;
	    volatile boolean zero_odd=false;
	    volatile boolean odd_even=false;
	    volatile boolean zero_even=false;
	    
	    public ZeroEvenOdd4(int n) {
	        this.n = n;
	    }

	    // printNumber.accept(x) outputs "x", where x is an integer.
	    public void zero(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		while(zero_odd||zero_even){
	    			
	    		}
	    		printNumber.accept(0);
	    		zero_odd=true;
	    		odd_even=true;
	    	}
	    }

	    public void odd(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		while(!zero_odd||!odd_even){
	    			
	    		}
	    		if(i%2!=0) {
	    			printNumber.accept(i);
	    		}
	    		zero_even=true;
	    		zero_odd=false;
			}
	    }
	    
	    public void even(IntConsumer printNumber) throws InterruptedException {
	    	for (int i = 1; i <= n; i++) {
	    		while(!zero_even||!odd_even){
	    			
	    		}
	    		if(i%2==0) {
	    			printNumber.accept(i);
	    		}
	    		zero_even=false;
			}
	    }
	}
	public static void main(String[] args) {
//		final ZeroEvenOdd zeroEvenOdd=new ZeroEvenOdd(9);
//		final ZeroEvenOdd2 zeroEvenOdd=new ZeroEvenOdd2(9);
//		final ZeroEvenOdd3 zeroEvenOdd=new ZeroEvenOdd3(9);
		final ZeroEvenOdd4 zeroEvenOdd=new ZeroEvenOdd4(9);
		final IntConsumer printNumber=new IntConsumer() {
			@Override
			public void accept(int x) {
				System.out.print(x);
			}
		};
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					zeroEvenOdd.zero(printNumber);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					zeroEvenOdd.odd(printNumber);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t3=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					zeroEvenOdd.even(printNumber);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t3.start();
		t2.start();
		t1.start();
	}
}
