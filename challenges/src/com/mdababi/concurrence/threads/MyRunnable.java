package com.mdababi.concurrence.threads;

public class MyRunnable implements Runnable {

	
	
	
	@Override
	public void run() {
		System.out.println(ThreadColor.ANSI_RED+"hello from my runnable thread");
	}

}
