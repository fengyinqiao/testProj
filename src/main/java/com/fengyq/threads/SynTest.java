package com.fengyq.threads;

import java.util.PriorityQueue;

public class SynTest {
	static class Task implements Runnable {
		SynTest syn;
		public Task(SynTest syn) {
			this.syn=syn;
		}
		@Override
		public void run() {
			syn.test(Thread.currentThread().getName());
		}
	}
	
	static class Task2 implements Runnable {
		SynTest syn;
		public Task2(SynTest syn) {
			this.syn=syn;
		}
		@Override
		public void run() {
			synchronized(syn) {
				System.out.println(Thread.currentThread().getName());
			}
		}
	}
	
	public synchronized void test(String s) {
		System.out.println(s);
	};
	public static void main(String[] args) throws InterruptedException {
		SynTest syn=new SynTest();
		Thread t1=new Thread(new Task(syn));
		Thread t2=new Thread(new Task(syn));
		Thread t3=new Thread(new Task2(syn));
		Thread.sleep(100);
		t1.start();
		t2.start();
		t3.start();
	}
}
