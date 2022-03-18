package com.fengyq.designpattern.creational;

import java.util.ArrayList;

public class _Prototype {
	static class Prototype implements Cloneable{
		ArrayList list=new ArrayList();
		@Override
		public Prototype clone() throws CloneNotSupportedException {
			Prototype prototype=(Prototype) super.clone();
			//深拷贝list等引用类型变量
			prototype.list=(ArrayList) this.list.clone();
			return prototype;
		}
	}
	static class ConcretePrototype extends Prototype{
		
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Prototype prototype=new ConcretePrototype();
		Prototype newPrototype=prototype.clone();
		System.out.println(prototype);
		System.out.println(prototype.list==newPrototype.list);
		System.out.println(newPrototype);
	}
}
