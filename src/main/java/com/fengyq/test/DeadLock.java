package com.fengyq.test;

public class DeadLock {
	static class SynAddRunalbe implements Runnable {
		int a, b;
		public SynAddRunalbe(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public void run() {
			synchronized (Integer.valueOf(a)) {
				synchronized (Integer.valueOf(b)) {
					System.out.println(a + b);
				}
			}
		}
		public static void main(String[] args) {
			for (int i = 0; i < 100; i++) {
				new Thread(new SynAddRunalbe(1, 2)).start();
				new Thread(new SynAddRunalbe(2, 1)).start();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized ("abc") {
					try {
						System.out.println("线程1拿到abc的锁");
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized ("abcd") {
						System.out.println("线程1拿到abcd的锁");
					}
				}
			}
		}).start();
		Thread.sleep(1);
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized ("abcd") {
					try {
						System.out.println("线程2拿到abcd的锁");
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized ("abc") {
						System.out.println("线程s拿到abc的锁");
					}
				}
			}
		}).start();
	}
}
