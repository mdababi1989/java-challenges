package com.mdababi.concurrence.fairLock;

public class SharedRecource {
	private Worker owner;

	public SharedRecource(Worker owner) {
		super();
		this.owner = owner;
	}

	public Worker getOwner() {
		return owner;
	}

	public synchronized void setOwner(Worker owner) {
		this.owner = owner;
	}
	
}
