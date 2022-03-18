package com.fengyq.designpattern.structural;

public class _Proxy {
	static interface Subject {
		public void request();
	}
	static class Target implements Subject {
		@Override
		public void request() {
			System.out.println("目标对象的请求");
		}
		public void request2(){
			System.out.println("目标对象的请求2");
		}
	}
	static class Proxy implements Subject {
		Subject target;
		public Proxy(Subject target) {
			this.target=target;
		}
		
		@Override
		public void request() {
			System.out.println("代理对象方法调用");
			target.request();
		}
	}
	static class Proxy2 extends Target{
		@Override
		public void request2() {
			System.out.println("代理对象2方法调用");
			super.request2();
		}
	}
	public static void main(String[] args) {
		Subject target =new Target();
		Subject proxy=new Proxy(target);
		proxy.request();
		Target target2=new Proxy2();
		target2.request2();
	}
}
