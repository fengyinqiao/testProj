package com.fengyq.designpattern.behavior;

import java.util.Vector;

public class _Observer {
	static interface Observer {
		public void update(Subject subject,Object arg);
	}
	static class ConcreteObserver implements Observer{
		@Override
		public void update(Subject subject, Object arg) {
			System.out.println("观察者收到通知。。。");
		}
	}
	static class ConcreteObserver2 implements Observer{
		@Override
		public void update(Subject subject, Object arg) {
			System.out.println("观察者2收到通知。。。");
		}
	}
	static abstract class Subject {
		Vector<Observer> observers;
		public Subject() {
			super();
			observers = new Vector<Observer>();
		}
		void addObserver(Observer observer) {
			observers.add(observer);
		}
		void deleteObserver(Observer observer) {
			observers.remove(observer);
		}
		void notifyObservers(Object arg) {
			for (Observer observer : observers) {
				observer.update(this, arg);
			}
		}
		abstract void doSomething(Object arg);
	}
	
	static class ConcreteSubject extends Subject {
		@Override
		void doSomething(Object arg) {
			System.out.println("通知观察者们。。。");
			notifyObservers(arg);
		}
	}
	
	public static void main(String[] args) {
		Observer observer=new ConcreteObserver();
		Observer observer2=new ConcreteObserver2();
		Subject subject=new ConcreteSubject();
		subject.addObserver(observer);
		subject.addObserver(observer2);
		subject.doSomething(null);
	}
}
