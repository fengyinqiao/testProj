package com.fengyq.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalTask implements Callable<Double> {
	static class Order {
		double amt;
		public Order(double amt) {
			super();
			this.amt = amt;
		}
		public double getAmt() {
			return amt;
		}
		public void setAmt(double amt) {
			this.amt = amt;
		}
	}

	static interface CalStrategy {
		public double calDiscount();
	}

	static class CalStrategyByDiscount implements CalStrategy {
		Order order;
		public CalStrategyByDiscount(Order order) {
			super();
			this.order = order;
		}

		@Override
		public double calDiscount() {
			Double amt = order.getAmt();
			if(amt>=2000&&amt<3000){
				return (double) 150;
			}else if(amt>=3000){
				return (double) 280;
			}
			return (double) 0;
		}
	}

	static class CalStrategyByLadder implements CalStrategy {
		Order order;
		public CalStrategyByLadder(Order order) {
			super();
			this.order = order;
		}
		@Override
		public double calDiscount() {
			Double amt = order.getAmt();
			if(amt>0&&amt<=1000){
				amt=amt*(1-0.95);
			}else if(amt>1000&&amt<=2000){
				amt=amt*(1-0.9);
			}else if(amt>2000){
				amt=amt*(1-0.85);
			}
			return amt;
		}
	}

	CalStrategy calStrategy;
	
	public CalTask(CalStrategy calStrategy) {
		super();
		this.calStrategy = calStrategy;
	}

	@Override
	public Double call() throws Exception {
		// TODO Auto-generated method stub
		return calStrategy.calDiscount();
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//评测题目1: 一个淘宝订单，能同时享受两个优惠策略，

		// 1. 打折优惠
		// 当用户的订单金额 》= 2000元，整单减免150元，当用户的订单金额 》= 3000元，整单减免280元。

		// 2. 阶梯优惠，类似个人所得税的算法。
		// 当用户的订单金额 0-1000（含）元，这部分金额享受95折优惠
		// 当用户的订单金额 1000-2000（含）元，这部分金额享受9折优惠
		// 当用户的订单金额 2000元以上（不含2000），这部分金额享受85折优惠

		// 订单在执行优惠时，为提高用户体检，多个优惠需要并行执行(不考虑优惠策略的优先级)来加快响应时间。

		// 定义以上的类、接口，并写出测试方法：给定一个订单的原始金额，计算出最终优惠后的实际支付价。
		
		Order order = new Order(3000);
		CalStrategy calStrategy=new CalStrategyByDiscount(order);
		CalTask calTask=new CalTask(calStrategy);
		List<CalTask> calTaskList = new ArrayList<CalTask>();
		calTaskList.add(calTask);
		
		CalStrategy calStrategy2=new CalStrategyByLadder(order);
		CalTask calTask2=new CalTask(calStrategy2);
		calTaskList.add(calTask2);
		
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		List<Future> futureList=new ArrayList<Future>();
		for(CalTask task:calTaskList){
			Future futureTask=executorService.submit(task);
			futureList.add(futureTask);
		}
		
		Double result=0.0;
		for(Future future:futureList){
			result += (Double) future.get();
		}
		System.out.println(order.getAmt()+"->"+(order.getAmt()-result));
		
		executorService.shutdown();
	}
}
