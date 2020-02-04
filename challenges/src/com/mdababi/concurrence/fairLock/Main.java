package com.mdababi.concurrence.fairLock;

public class Main {

	public static void main(String[] args) {
		final Worker worker1 = new Worker("Worker1", true);
		final Worker worker2 = new Worker("Worker2", true);

		final SharedRecource sharedRecource = new SharedRecource(worker1);
		new Thread(() -> {
			worker1.work(sharedRecource, worker2);
		}).start();
		new Thread(() -> {
			worker2.work(sharedRecource, worker1);
		}).start();

	}

}
