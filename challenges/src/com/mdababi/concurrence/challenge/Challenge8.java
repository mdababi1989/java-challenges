package com.mdababi.concurrence.challenge;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge8 {

	public static void main(String[] args) {
		final Tutor tutor = new Tutor();
		final Student student = new Student(tutor);

		tutor.setStudent(student);

		Thread tutorThread = new Thread(() -> {
			tutor.studyTime();
		});
		Thread studentThread = new Thread(() -> {
			student.handInAssignment();
		});
		tutorThread.start();
		studentThread.start();
	}
}

class Tutor {
	private Student student;

	public Tutor() {
		super();
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void studyTime() {
		synchronized (this) {
			System.out.println("tutor has arrived");
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
			this.notifyAll();
			synchronized (student) {
				student.startStudy();
				System.out.println("tutor is studying with student");
				try {
					student.wait();
				} catch (InterruptedException e) {
				}
				student.notifyAll();
			}
		}
	}

	public void getProgressReport() {
		System.out.println("Tutor gave progress report");
	}
}

class Student {
	private Tutor tutor;
	private Lock lock;

	public Student(Tutor tutor) {
		this.tutor = tutor;
	}

	public void startStudy() {
		System.out.println("Student is studying");
	}

	public void handInAssignment() {
		synchronized (tutor) {
			tutor.getProgressReport();
			synchronized (this) {
				System.out.println("Student hand in assignment");
				this.notifyAll();
			}
			tutor.notifyAll();
		}
	}

}
