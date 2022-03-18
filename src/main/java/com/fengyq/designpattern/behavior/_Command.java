package com.fengyq.designpattern.behavior;


public class _Command {
	static abstract class Command {
		Receiver receiver;
		public abstract void execute(Object arg);
	}
	static class ConcreteCommand extends Command{
		public ConcreteCommand(Receiver receiver) {
			this.receiver=receiver;
		}
		@Override
		public void execute(Object arg) {
			receiver.action(arg);
		}
	}
	static class Receiver {
		public void action(Object arg) {
			System.out.println("接收者响应命令："+arg);
		}
	}
	static class Invoker {
		Command command;
		public Invoker(Command command) {
			this.command=command;
		}
		public void invoke(Object arg) {
			command.execute(arg);
		}
	}
	public static void main(String[] args) {
		Receiver receiver=new Receiver();
		Command command=new ConcreteCommand(receiver);
		Invoker invoker=new Invoker(command);
		invoker.invoke("命令参数");
	}
}
