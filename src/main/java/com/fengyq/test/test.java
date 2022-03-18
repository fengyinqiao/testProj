package com.fengyq.test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class test implements Serializable{
	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	/*-verbose:gc -XX:+PrintGCDetails -Xmx2M -Xms2M -XX:+DisableExplicitGC*/
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException{
		/*int[] a={1,2,3};
		ArrayList arrayList=new ArrayList();
		arrayList.add(4);
        Collections.addAll(arrayList, a);
		System.out.println(arrayList);*/
		//评测题目1: 一个淘宝订单，能同时享受两个优惠策略，

		// 1. 打折优惠
		// 当用户的订单金额 》= 2000元，整单减免150元，当用户的订单金额 》= 3000元，整单减免280元。

		// 2. 阶梯优惠，类似个人所得税的算法。
		// 当用户的订单金额 0-1000（含）元，这部分金额享受95折优惠
		// 当用户的订单金额 1000-2000（含）元，这部分金额享受9折优惠
		// 当用户的订单金额 2000元以上（不含2000），这部分金额享受85折优惠

		// 订单在执行优惠时，为提高用户体检，多个优惠需要并行执行(不考虑优惠策略的优先级)来加快响应时间。

		// 定义以上的类、接口，并写出测试方法：给定一个订单的原始金额，计算出最终优惠后的实际支付价。
		/*double amt=3000;
		IStrategy Strategy1 = new Strategy1(amt);
		IStrategy Strategy2 = new Strategy2(amt);
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		FutureTask<Double> futureTask1=(FutureTask<Double>) threadPool.submit(Strategy1);
		FutureTask<Double> futureTask2=(FutureTask<Double>) threadPool.submit(Strategy2);
		double result1=futureTask1.get();
		double result2=futureTask2.get();
		System.out.println(amt-result1-result2);*/
		
/*		int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[] b={};
		int m=3;
		int n=4;
		int k=0;
		int x=3;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				b[k++]=a[i][j];
			}
		}
		System.out.println(find(b,x));*/
		/*System.out.println(TimeUnit.NANOSECONDS.toNanos(1000));*/
		List<String> userNames = new ArrayList<String>() {{
			add("Hollis");
			add("hollis");
			add("HollisChuang");
			add("H");
		}};
		Iterator iterator = userNames.iterator();
		for (int i = 0; i < userNames.size(); i++) {
			if (userNames.get(i).equals("Hollis")) {
			//if (userNames.get(i).equals("Hollis")||userNames.get(i).equals("hollis")) {
				userNames.remove(i);
			}
		}
		System.out.println(userNames);
	}

	private static boolean find(int[] b, int x) {
		// TODO Auto-generated method stub
		int l=b.length;
		int start = b[0];
		int end = b[l-1];
		while(start!=end){
			if(x>end||x<start){
				return false;
			}else if(x>start&&x<end){
				l=l/2;
				if(x<b[l]){
					end=b[l];
				}else{
					start=b[l];
				}
			}else if(x==start||x==end){
				return true;
			}
		}
		return false;
	}

	private static void find(int x) {
		
	}
	
}