package com.fengyq.designpattern.structural;

public class _Facade {
	static class Light {
		private void open() {
			System.out.println("开灯...");
		}
	}
	static class Heater {
		private void open() {
			System.out.println("开热水器...");
		}
	}
	static class TV {
		private void open() {
			System.out.println("开电视...");
		}
	}
	static class Facade {
		Light light;
		Heater heater;
		TV tv;
		public Facade() {
			this.light=new Light();
			this.heater=new Heater();
			this.tv=new TV();
		}
		public void open() {
			System.out.println("一键打开所有...");
			light.open();
			heater.open();
			tv.open();
		}
	}
	public static void main(String[] args) {
		Facade facade=new Facade();
		facade.open();
	}
}
