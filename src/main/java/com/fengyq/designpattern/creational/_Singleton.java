package com.fengyq.designpattern.creational;

public class _Singleton {
	private volatile static _Singleton singleton;

	private _Singleton() {
	}

	public static _Singleton getSingletonByStaticInnerClass() {
		return SingletonHolder.singleton;
	}

	static class SingletonHolder {
		static _Singleton singleton = new _Singleton();
	}

	public static _Singleton getSingletonByDoubleCheckLock() {
		if (singleton == null) {
			synchronized (_Singleton.class) {
				if (singleton == null) {
					singleton = new _Singleton();
				}
			}
		}
		return singleton;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()
						+ "->StaticInnerClass:"
						+ _Singleton.getSingletonByStaticInnerClass()
						+ "->DCL:"
						+ _Singleton.getSingletonByDoubleCheckLock());
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()
						+ "->StaticInnerClass:"
						+ _Singleton.getSingletonByStaticInnerClass()
						+ "->DCL:"
						+ _Singleton.getSingletonByDoubleCheckLock());
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()
						+ "->StaticInnerClass:"
						+ _Singleton.getSingletonByStaticInnerClass()
						+ "->DCL:"
						+ _Singleton.getSingletonByDoubleCheckLock());
			}
		});
		t1.start();
		t2.start();
		t3.start();
	}
}
