package com.fengyq.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ListDeleteTest {
	public static void main(String[] args) throws InterruptedException {
		List list=new LinkedList();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			list.remove(i);
		}
	}
}
