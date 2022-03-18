package com.fengyq.leetcode.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class H2O {
	CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
	Semaphore h=new Semaphore(2);
	Semaphore o=new Semaphore(1);
    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    	h.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        try {
			cyclicBarrier.await();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		releaseHydrogen.run();
		h.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    	o.acquire(1);
    	try {
			cyclicBarrier.await();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		o.release(1);
    }
    
    static abstract class absTask implements Runnable {
    	public H2O h2o;
    }
    
    static class HTask extends absTask{
    	public HTask(H2O h2o) {
    		this.h2o=h2o;
    	}
    	@Override
    	public void run() {
    		Runnable releaseHydrogen=new Runnable() {
				@Override
				public void run() {
					System.out.print("H");
				}
			};
    		try {
				h2o.hydrogen(releaseHydrogen);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    static class OTask extends absTask{
    	public OTask(H2O h2o) {
    		this.h2o=h2o;
    	}
    	@Override
    	public void run() {
    		Runnable releaseOxygen=new Runnable() {
				@Override
				public void run() {
					System.out.print("O");
				}
			};
    		try {
				h2o.oxygen(releaseOxygen);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    public static void main(String[] args) {
		final H2O h2o=new H2O();
    	Thread h =new Thread(new HTask(h2o));
    	Thread h2=new Thread(new HTask(h2o));
    	Thread h3=new Thread(new HTask(h2o));
    	Thread h4=new Thread(new HTask(h2o));
    	Thread h5=new Thread(new HTask(h2o));
    	Thread h6=new Thread(new HTask(h2o));
    	Thread o =new Thread(new OTask(h2o));
    	Thread o2=new Thread(new OTask(h2o));
    	Thread o3=new Thread(new OTask(h2o));
    	o.start();
    	o2.start();
    	h.start();
    	h2.start();
    	o3.start();
    	h3.start();
    	h4.start();
    	h5.start();
    	h6.start();
	}
}