package com.mdababi.concurrence.threads;

public class Main {

	public static void main(String[] args) {
		System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main method");

		Thread anotherThread = new AnotherThread();
		anotherThread.start();

		new Thread() {
			public void run() {
				System.out.println(ThreadColor.ANSI_GREEN + "hello from anonymous class thread");
			};
		}.start();

		Thread myRunnableThread = new Thread(new MyRunnable() {
			@Override
			public void run() {
				System.out.println(ThreadColor.ANSI_RED + "hello from myrunnable anonymous thread");

				try {
					anotherThread.join(2000);
					System.out.println(
							ThreadColor.ANSI_RED + "Another thread terminated or timed out so Im running again");
				} catch (InterruptedException e) {
					System.out.println(ThreadColor.ANSI_RED + "I coudn't wait after all. I was interrupted");
				}
			}
		});
		myRunnableThread.start();

		// anotherThread.interrupt();

		System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");

	}
}
