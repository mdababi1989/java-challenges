package com.mdababi.concurrence.threads;

public class AnotherThread extends Thread{
	
	@Override
	public void run() {
		System.out.println(ThreadColor.ANSI_BLUE +"Hello from another thread");
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(ThreadColor.ANSI_BLUE +"another thread: I have been Interrupted");
			return;
		}
		
		System.out.println(ThreadColor.ANSI_BLUE +"I'm awake after three seconds");

	}
}
