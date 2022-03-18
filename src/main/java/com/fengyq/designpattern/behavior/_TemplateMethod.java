package com.fengyq.designpattern.behavior;

public class _TemplateMethod {
	static abstract class TemplateMethod {
		abstract void step1();
		abstract void step2();
		void step3() {
			System.out.println("父类的step3方法...");
		}
		void templateMethod() {
			step1();
			step2();
			if(doStep3()) {
				step3();
			}
		}
		boolean doStep3() {
			return true;
		}
	}
	static class ConcreteClass1 extends TemplateMethod {
		@Override
		void step1() {
			System.out.println("子类1的step1方法...");
		}
		@Override
		void step2() {
			System.out.println("子类1的step2方法...");
		}
		@Override
		boolean doStep3() {
			return false;
		}
	}
	static class ConcreteClass2 extends TemplateMethod {
		@Override
		void step1() {
			System.out.println("子类2的step1方法...");
		}
		@Override
		void step2() {
			System.out.println("子类2的step2方法...");
		}
	}
	public static void main(String[] args) {
		new ConcreteClass1().templateMethod();
		System.out.println();
		new ConcreteClass2().templateMethod();
	}
}
