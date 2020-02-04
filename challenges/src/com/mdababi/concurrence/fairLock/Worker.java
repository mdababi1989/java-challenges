package com.mdababi.concurrence.fairLock;

public class Worker {

	private String name;
	private boolean active;

	public Worker(String name, boolean active) {
		super();
		this.name = name;
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public boolean isActive() {
		return active;
	}

	public synchronized void work(SharedRecource sharedRecource, Worker otherWorker) {
		while(active) {
			if(sharedRecource.getOwner() != this) {
				try {
					wait(10);
				}
				catch(InterruptedException e) {
					
				}
				continue;
			}
			if(otherWorker.isActive()) {
				System.out.println(getName() +" : give recource to the worker "+otherWorker.getName());
				sharedRecource.setOwner(otherWorker);
				continue;
			}
			System.out.println(getName()+": working at the same recource");
			active = false;
			sharedRecource.setOwner(otherWorker); 
		}
		
	}

}
