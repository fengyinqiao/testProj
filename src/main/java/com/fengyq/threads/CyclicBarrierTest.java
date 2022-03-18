package com.fengyq.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	static class Task implements Runnable {
		CyclicBarrier cyclicBarrier;
		public Task(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier=cyclicBarrier;
		}
		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName()+"等待");
				System.out.println(Thread.currentThread().getName()+"等待结束，返回："+cyclicBarrier.await());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier cb=new CyclicBarrier(3);
		Thread t1=new Thread(new Task(cb));
		Thread t2=new Thread(new Task(cb));
		t1.start();
		t2.start();
		Thread.sleep(100);
		System.out.println(Thread.currentThread().getName()+"开闸，返回："+cb.await());
	}
}
