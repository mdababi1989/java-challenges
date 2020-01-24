package com.mdababi.concurrence.syncronize;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

	}
}

class Message {
	private String message;
	private boolean empty = true;

	public synchronized String read() {
		while (empty) {

		}
		empty = true;
		return message;
	}

	public synchronized void write(String message) {
		while (!empty) {

		}
		empty = false;
		this.message = message;

	}

	class Writer implements Runnable {
		private Message message;

		public Writer(Message message) {
			super();
			this.message = message;
		}

		@Override
		public void run() {
			String[] messages = { "sat on a wall", "had a great fall", "all the king's horsesand all the king's men",
					"coudn't put it together again" };

			Random random = new Random();
			for (int i = 0; i < messages.length; i++) {
				message.write(messages[i]);
				try {
					Thread.sleep(random.nextInt(2000));
				} catch (InterruptedException e) {

				}

			}
		}

	}
	
	class Reader implements Runnable{
		private Message message;
		
		public Reader(Message message) {
			this.message = message;
		}
		
		@Override
		public void run() {
			Random random = new Random();
			
		}
		
		
	}
}
