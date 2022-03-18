package com.fengyq.threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
//写两个线程，一个线程打印 1~52，另一个线程打印字母A-Z。打印顺序为12A34B56C……5152Z。要求用线程间的通信。
public class AlternatePrint {
	static int cnt=0;
	static void print2() {
		final Semaphore semaphore=new Semaphore(2);
		final Semaphore semaphore2=new Semaphore(0);
		Thread t1=new Thread(new Runnable() {
			public void run() {
				try {
					for (int i = 1; i <= 52; i++) {
						semaphore.acquire(1);
						System.out.print(i+" ");
						semaphore2.release(1);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2=new Thread(new Runnable() {
			public void run() {
				for (char i = 'A'; i <='Z'; i++) {
					try {
						semaphore2.acquire(2);
						System.out.print(i+" ");
						semaphore.release(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t2.start();
		t1.start();
	}
	static void print1() {
		final ReentrantLock lock=new ReentrantLock();
		final Condition condition=lock.newCondition();
		final Condition condition2=lock.newCondition();
		Thread t1=new Thread(new Runnable() {
			public void run() {
				try {
					lock.lock();
					for (int i = 1; i <=52 ; i++) {
						while(cnt%3!=0&&cnt%3!=1) {
							condition.await();
						}
						System.out.print(i+" ");
						cnt++;
						condition2.signal();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});
		Thread t2=new Thread(new Runnable() {
			public void run() {
				try {
					lock.lock();
					for (char i = 'A'; i <='Z'; i++) {
						while(cnt%3!=2) {
							condition2.await();
						}
						System.out.print(i+" ");
						cnt++;
						condition.signal();
					}
				} catch (Exception e) {
				}finally {
					lock.unlock();
				}
			}
		});
		t2.start();
		t1.start();
	}
	public static void main(String[] args) {
//		print1();
		print2();
	}
}
