package com.fengyq.designpattern.structural;

public class _Decorator {
	static interface Component {
		public void operate();
	}
	static class ConcreteComponent implements Component{
		@Override
		public void operate() {
			System.out.println("具体组件的行为");
		}
	}
	static abstract class Decorator implements Component{
		Component component;
		@Override
		public void operate() {
			System.out.println("抽象装饰者的行为");
		};
	}
	static class ConcreteDecoratorA extends Decorator {
		public ConcreteDecoratorA(Component component) {
			this.component=component;
		}
		@Override
		public void operate() {
			super.operate();
			System.out.println("具体装饰者A的行为");
			component.operate();
		}
	}
	
	static class ConcreteDecoratorB extends Decorator {
		public ConcreteDecoratorB(Component component) {
			this.component=component;
		}
		@Override
		public void operate() {
			super.operate();
			System.out.println("具体装饰者B的行为");
			component.operate();
		}
	}
	public static void main(String[] args) {
		Component component = new ConcreteComponent();
		Component decorator=new ConcreteDecoratorA(component);
		decorator.operate();
		System.out.println();
		//被装饰的装饰者
		Component doubleDecorator=new ConcreteDecoratorB(decorator);
		doubleDecorator.operate();
	}
}
