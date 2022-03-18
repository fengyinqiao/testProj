package com.fengyq.designpattern.creational;


public class _Builder {
	static class Director {
		Builder builder;
		public Director(Builder builder) {
			this.builder=builder;
		}
		public Product construct() {
			builder.buildPartA();
			builder.buildPartB();
			builder.buildPartC();
			builder.buildPartD();
			return builder.getProduct();
		}
	}
	static interface Builder {
		void buildPartA();
		void buildPartB();
		void buildPartC();
		void buildPartD();
		Product getProduct();
	}
	
	static class concreteBuilderA implements Builder{
		Product product=new Product();
		
		@Override
		public void buildPartA() {
			product.setA("A");
		}
		@Override
		public void buildPartB() {
			product.setB("B");
		}
		@Override
		public void buildPartC() {
			product.setC("C");
		}
		@Override
		public void buildPartD() {
			product.setD("D");
		}
		@Override
		public Product getProduct() {
			return product;
		}
		
	}
	
	static class Product {
		String A;
		String B;
		String C;
		String D;
		public String getA() {
			return A;
		}
		public void setA(String a) {
			A = a;
		}
		public String getB() {
			return B;
		}
		public void setB(String b) {
			B = b;
		}
		public String getC() {
			return C;
		}
		public void setC(String c) {
			C = c;
		}
		public String getD() {
			return D;
		}
		public void setD(String d) {
			D = d;
		}
		@Override
		public String toString() {
			return "A:"+this.getA()+",B:"+this.getB()+",C:"+this.getC()+",D:"+this.getD();
		}
	}
	
	public static void main(String[] args) {
		Builder builder=new concreteBuilderA();
		Director director=new Director(builder);
		Product product=director.construct();
		System.out.println(product.toString());
	}
	
}
