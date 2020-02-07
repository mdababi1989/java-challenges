package com.mdababi.lambdas.Introduction;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Employee ali = new Employee("ali", 21);
		Employee mohamed = new Employee("mohamed", 22);
		Employee saleh = new Employee("saleh", 23);
		Employee ramzi = new Employee("ramzi", 24);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(saleh);
		employees.add(mohamed);
		employees.add(ramzi);
		employees.add(ali);

		employees.forEach(employee -> {
			System.out.println(employee.getName() + "****" + employee.getAge());

		});

//		  System.out.println(employees);
//		  
//		  for(Employee employee:employees) { System.out.println(employee.getName()
//		  +"****"+ employee.getAge()); new Thread(()->
//		  System.out.println(employee.getAge())).start();
//		  
//		  }

		/*
		 * new Thread(new CodeToRun()).start(); new Thread(() ->
		 * System.out.println("This is code to run")).start();
		 * 
		 * 
		 * 
		 * 
		 * Collections.sort(employees, (x,y)-> x.getName().compareTo(y.getName()));
		 * 
		 * System.out.println(employees);
		 * 
		 * UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase(); String
		 * stuff = doStringStaff(uc, employees.get(0).getName(),
		 * employees.get(1).getName());
		 */

	}

	public final static String doStringStaff(UpperConcat uc, String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
	}

}

class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName();
	}

}

class CodeToRun implements Runnable {

	@Override
	public void run() {
		System.out.println("This is code to run");
	}

}
