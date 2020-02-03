package com.mdababi.concurrence.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(100);

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		myProducer producer = new myProducer(buffer, ThreadColor.ANSI_BLUE);
		myConsumer consumer1 = new myConsumer(buffer, ThreadColor.ANSI_RED);
		myConsumer consumer2 = new myConsumer(buffer, ThreadColor.ANSI_GREEN);

		executorService.execute(producer);
		executorService.execute(consumer1);
		executorService.execute(consumer2);

		Future<String> future = executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println(ThreadColor.ANSI_BLACK + "Im being printed from callable");
				return "This is the callable result";
			}
		});

		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			System.out.println("thread running the task was interrupted");
		} catch (ExecutionException e) {
			System.out.println("sth went wrong");
		}

		executorService.shutdown();

	}
}

class myProducer implements Runnable {
	private ArrayBlockingQueue<String> buffer;
	private String color;

	public myProducer(ArrayBlockingQueue<String> buffer, String color) {
		super();
		this.buffer = buffer;
		this.color = color;
	}

	@Override
	public void run() {
		Random random = new Random();
		String[] nums = { "1", "2", "3", "4", "5" };

		for (String num : nums) {
			try {
				System.out.println(color + "Adding..." + num);
				buffer.put(num);
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				System.out.println("Producer was interrupted");
			}
		}
		System.out.println(color + "Adding EOF and exiting...");
		try {
			buffer.put("EOF");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class myConsumer implements Runnable {
	private ArrayBlockingQueue<String> buffer;
	private String color;

	public myConsumer(ArrayBlockingQueue<String> buffer, String color) {
		super();
		this.buffer = buffer;
		this.color = color;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (buffer) {
				try {
					if (buffer.isEmpty()) {
						continue;
					}
					if (buffer.peek().equals("EOF")) {
						System.out.println(color + "exiting...");
						break;
					} else {
						System.out.println(color + "removed" + buffer.take());
					}
				} catch (InterruptedException e) {

				}
			}
		}
	}
}
