package com.fengyq.test;

import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
	static LinkedBlockingQueue q=new LinkedBlockingQueue();
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1; j++) {
						try {
							System.out.println(Thread.currentThread().getName() + "放入:" + j);
							q.put(Thread.currentThread().getName() + "放入的:" + j);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1; j++) {
						try {
							System.out.println(Thread.currentThread().getName() + "取出:" + q.take());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
}
