package com.fengyq.threads;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法 add,size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 */
public class Container {
	static CopyOnWriteArrayList<Object> list=new CopyOnWriteArrayList<Object>();
	static CountDownLatch latch=new CountDownLatch(5);
	static boolean flag=false;
	
	public void add(Object o) {
		list.add(o);
	}
	
	public void size() {
		list.size();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new Runnable() {
			public void run() {
				int i=0;
				while (!flag&&i<10) {
					list.add(i);
					latch.countDown();
					i++;
				}
			}
		});
		Thread t2=new Thread(new Runnable() {
			public void run() {
				try {
					latch.await();
					flag=true;
					System.out.println("容器已添加5个元素，退出");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t2.start();
		t1.start();
		Thread.sleep(100);
		for (Object o : list) {
			System.out.println(o);
		}
	}
}
