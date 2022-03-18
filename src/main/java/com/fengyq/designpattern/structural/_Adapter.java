package com.fengyq.designpattern.structural;

public class _Adapter {
	static interface Target {
		public void request();
	}
	static class Adapter implements Target{
		Adaptee adaptee;
		public Adapter(Adaptee adaptee) {
			this.adaptee=adaptee;
		}
		@Override
		public void request() {
			System.out.println("组合方式适配");
			adaptee.specificRequest();
		}
	}
	static class Adapter2 extends Adaptee implements Target{
		@Override
		public void request() {
			System.out.println("继承方式适配");
			specificRequest();
		}
	}
	static class Adaptee {
		//主要是因为这个类的方法，和目标类的方法不一致，也就是两个类的行为不一致。
		// 所以才需要适配器去适配
		public void specificRequest() {
			System.out.println("被适配类具有 特殊功能...");
		}
	}
	public static void main(String[] args) {
		Adaptee adaptee=new Adaptee();
		Target target=new Adapter(adaptee);
		target.request();
		target=new Adapter2();
		target.request();
	}
}
