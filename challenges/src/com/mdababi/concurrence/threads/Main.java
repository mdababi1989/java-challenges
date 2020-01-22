package com.mdababi.concurrence.threads;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello from the main method");
		
		Thread anotherThread = new AnotherThread();
		anotherThread.start();
		
		new Thread() {
			public void run() {
				System.out.println("hello from anonymous class thread");
			};
		}.start();
		
		System.out.println("Hello again from the main thread");
		
	}
}
