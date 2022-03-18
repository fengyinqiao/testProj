package com.fengyq.designpattern.behavior;

public class _ChainOfResponsibility {
	static abstract class Handler {
		Handler next;
		public Handler getNext() {
			return next;
		}
		public void setNext(Handler next) {
			this.next = next;
		}
		public abstract void handleRequest(String request);
	}
	static class ConcreteHandler extends Handler {
		@Override
		public void handleRequest(String request) {
			if(request.equals("1")) {
				System.out.println("ConcreteHandler处理该请求");
			}else {
				if(getNext()!=null) {
					getNext().handleRequest(request);
				}else {
					System.out.println("没有人处理该请求");
				}
			}
		}
	}
	static class ConcreteHandler2 extends Handler {
		@Override
		public void handleRequest(String request) {
			if(request.equals("2")) {
				System.out.println("ConcreteHandler2处理该请求");
			}else {
				if(getNext()!=null) {
					getNext().handleRequest(request);
				}else {
					System.out.println("没有人处理该请求");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Handler handler=new ConcreteHandler();
		Handler handler2=new ConcreteHandler2();
		handler.setNext(handler2);
		handler.handleRequest("1");
		handler.handleRequest("2");
		handler.handleRequest("3");
	}
}
