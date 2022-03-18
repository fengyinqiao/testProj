package com.fengyq.leetcode.thread;

import java.util.concurrent.Semaphore;

class FizzBuzz {
    private int n;
    Semaphore Semaphore=new Semaphore(1);
    Semaphore Semaphore3=new Semaphore(0);
	Semaphore Semaphore5=new Semaphore(0);
	Semaphore Semaphore35=new Semaphore(0);
    
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
    	for (int i = 1; i <= n; i++) {
    		if(i%3==0&&i%5!=0) {
    			Semaphore3.acquire();
    			printFizz.run();
    			Semaphore.release();
    		}
		}
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
    	for (int i = 1; i <= n; i++) {
    		if(i%5==0&&i%3!=0) {
    			Semaphore5.acquire();
    			printBuzz.run();
    			Semaphore.release();
    		}
    	}
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    	for (int i = 1; i <= n; i++) {
    		if(i%3==0&&i%5==0) {
    			Semaphore35.acquire();
        		printFizzBuzz.run();
        		Semaphore.release();
    		}
    	}
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
    	for (int i = 1; i <= n; i++) {
    		Semaphore.acquire();
			if(i%3==0&&i%5==0) {
				Semaphore35.release();
			}else if(i%3==0) {
				Semaphore3.release();
			}else if(i%5==0) {
				Semaphore5.release();
			}else {
				printNumber.accept(i);
				Semaphore.release();
			}
		}
    }
    static interface IntConsumer{
    	public void accept(int x);
    }
    public static void main(String[] args) {
    	final FizzBuzz fb=new FizzBuzz(15);
    	final Runnable printFizz=new Runnable() {
			@Override
			public void run() {
				System.out.print("fizz,");
			}
		};
		final Runnable printBuzz=new Runnable() {
			@Override
			public void run() {
				System.out.print("buzz,");
			}
		};
		final Runnable printFizzBuzz=new Runnable() {
			@Override
			public void run() {
				System.out.print("fizzbuzz,");
			}
		};
		final IntConsumer printNumber=new IntConsumer() {
			@Override
			public void accept(int x) {
				System.out.print(x+",");
			}
		};
    	Runnable fizz=new Runnable() {
			@Override
			public void run() {
				try {
					fb.fizz(printFizz);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable buzz=new Runnable() {
			@Override
			public void run() {
				try {
					fb.buzz(printBuzz);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable fizzbuzz=new Runnable() {
			@Override
			public void run() {
				try {
					fb.fizzbuzz(printFizzBuzz);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable number=new Runnable() {
			@Override
			public void run() {
				try {
					fb.number(printNumber);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t1=new Thread(fizz);
		Thread t2=new Thread(buzz);
		Thread t3=new Thread(fizzbuzz);
		Thread t4=new Thread(number);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
