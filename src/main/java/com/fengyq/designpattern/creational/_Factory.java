package com.fengyq.designpattern.creational;

public class _Factory {
//---------------------------------------简单工厂模式 begin----------------------------------
	static class SimpleFactory {
		public BMW createBMW(int type) {
			switch (type) {
				case 320:
					return new BMW320();

				case 523:
					return new BMW523();

				default:
					break;
			}
			return null;
		}
	}
//---------------------------------------简单工厂模式 end----------------------------------


//---------------------------------------工厂方法模式 begin----------------------------------
	static abstract class BMW {}
	static class BMW320 extends BMW {
		public BMW320() {
			System.out.println("制造-->BMW320");
		}
	}
	static class BMW523 extends BMW{
		public BMW523(){
			System.out.println("制造-->BMW523");
		}
	}

	static interface FactoryBMW {
		BMW createBMW();
	}
	static class FactoryBMW320 implements FactoryBMW{
		@Override
		public BMW createBMW() {
			return new BMW320();
		}
	}
	static class FactoryBMW523 implements FactoryBMW {
		@Override
		public BMW createBMW() {
			return new BMW523();
		}
	}
//---------------------------------------工厂方法模式 end----------------------------------



//---------------------------------------抽象工厂模式 begin----------------------------------
	//发动机以及型号
	static abstract class Engine { }
	static class EngineA extends Engine{
		public EngineA(){
			System.out.println("制造-->EngineA");
		}
	}
	static class EngineB extends Engine{
		public EngineB(){
			System.out.println("制造-->EngineB");
		}
	}

	//空调以及型号
	static abstract class Aircondition { }
	static class AirconditionA extends Aircondition{
		public AirconditionA(){
			System.out.println("制造-->AirconditionA");
		}
	}
	static class AirconditionB extends Aircondition{
		public AirconditionB(){
			System.out.println("制造-->AirconditionB");
		}
	}

	//创建工厂的接口
	static interface AbstractFactory {
		//制造发动机
		public Engine createEngine();
		//制造空调
		public Aircondition createAircondition();
	}

	//为宝马320系列生产配件
	static class FactoryBMW320_2 implements AbstractFactory{
		@Override
		public Engine createEngine() {
			return new EngineA();
		}
		@Override
		public Aircondition createAircondition() {
			return new AirconditionA();
		}
	}
	//宝马523系列
	static class FactoryBMW523_2 implements AbstractFactory {
		@Override
		public Engine createEngine() {
			return new EngineB();
		}
		@Override
		public Aircondition createAircondition() {
			return new AirconditionB();
		}
	}
//---------------------------------------抽象工厂模式 end----------------------------------

	public static void main(String[] args) {
		//简单（静态）工厂方法模式
		SimpleFactory simpleFactory = new SimpleFactory();
		BMW bmw320 = simpleFactory.createBMW(320);
		BMW bmw523 = simpleFactory.createBMW(523);

		//工厂方法模式，一个产品一个工厂，随着产品增多，工厂也会暴增。所以需要用抽象工厂模式，生产产品族
		FactoryBMW factoryBMW = new FactoryBMW320();
		bmw320 = factoryBMW.createBMW();

		factoryBMW = new FactoryBMW523();
		bmw523 = factoryBMW.createBMW();

		//抽象工厂模式
		AbstractFactory factory = new FactoryBMW320_2();//生产宝马320系列配件
		//AbstractFactory factory = new FactoryBMW523_2();//生产宝马523系列配件
		Engine engine = factory.createEngine();
		Aircondition aircondition=factory.createAircondition();
	}
}
