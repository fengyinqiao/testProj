package com.fengyq.threads;

import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class VolatileTest {
	static class VolatileTask implements Runnable {
		VolatileTest vt;
		public VolatileTask(VolatileTest vt) {
			this.vt = vt;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODOAuto-generated catch block e.printStackTrace();
			}
			vt.addNum();
		}
	}

	static class VolatileTask2 implements Runnable {
		VolatileTest vt;
		public VolatileTask2(VolatileTest vt) {
			this.vt = vt;
		}
		@Override
		public void run() {
			try {
				vt.cb.await();
				vt.init();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static class VolatileTask3 implements Runnable {
		VolatileTest vt;
		public VolatileTask3(VolatileTest vt) {
			this.vt = vt;
		}
		@Override
		public void run() {
			try {
				vt.cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(!vt.initialized) {
			}
			vt.addNum();
			System.out.println(vt.num);
		}
	}
	
	int num = 0;
	CyclicBarrier cb=new CyclicBarrier(2);
	boolean initialized;
	
	void addNum() {
		num = num + 1;
	}
	
	void init() throws InterruptedException {
		num=1;
		initialized=true;
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileTest vt = new VolatileTest();
//		VolatileTask task = new VolatileTask(vt);
		VolatileTask2 task2 = new VolatileTask2(vt);
		VolatileTask3 task3 = new VolatileTask3(vt);
		Thread t2 = new Thread(task2);
		Thread t3 = new Thread(task3);
		t2.start();
		t3.start();
//		Thread t = new Thread(task);
//		t.start();
////		Thread.sleep(1000);
//		while (vt.num == 0) {
//		}
//		System.out.println("主线程退出循环！");
	}

}
