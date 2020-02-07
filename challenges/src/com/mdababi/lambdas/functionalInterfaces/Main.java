package com.mdababi.lambdas.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		Employee ali = new Employee("ali alying", 21);
		Employee mohamed = new Employee("mohamed benhammouda", 40);
		Employee saleh = new Employee("saleh salehing", 23);
		Employee ramzi = new Employee("ramzi ramzying", 24);
		Employee red = new Employee("red redding", 31);
		Employee green = new Employee("green greening", 35);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(saleh);
		employees.add(mohamed);
		employees.add(ramzi);
		employees.add(ali);
		employees.add(green);
		employees.add(red);

		Function<Employee, String> getLastName = employee -> employee.getName()
				.substring(employee.getName().indexOf(' ' ) +1);
		employees.forEach(employee -> System.out.println(getLastName.apply(employee)));

//		printEmployeesPerAge(employees, "Employees over 30:", employee -> employee.getAge() > 30);
//		printEmployeesPerAge(employees, "\nEmployees 30 and younger:", employee -> employee.getAge() <= 30);
//
//		System.out.println("===========================");
//		IntPredicate greaterThan15 = i -> i > 15;
//		IntPredicate lessThen100 = i -> i < 100;
//
//		System.out.println(greaterThan15.and(lessThen100).test(52));
//		System.out.println(greaterThan15.or(lessThen100).test(15));
//
//		Random random = new Random();
//		Supplier<Integer> supplier = () -> random.nextInt(1000);
//		for (int i = 0; i < 10; i++) {
//			System.out.println(supplier.get());
//
//		}

//		System.out.println("Employees over 30:");
//		System.out.println("===========================");
//		
//		employees.forEach(employee -> {
//			if(employee.getAge()>30)
//				System.out.println(employee.getName());
//		});
//		
//		System.out.println("\nEmployees 30 and younger:");
//		System.out.println("===========================");
//		
//		employees.forEach(employee -> {
//			if(employee.getAge()<=30)
//				System.out.println(employee.getName());
//		});

	}

	private static void printEmployeesPerAge(List<Employee> employees, String ageText,
			Predicate<Employee> ageCondition) {

		System.out.println(ageText);
		System.out.println("===========================");

		employees.forEach(employee -> {
			if (ageCondition.test(employee))
				System.out.println(employee.getName());
		});

	}

}
