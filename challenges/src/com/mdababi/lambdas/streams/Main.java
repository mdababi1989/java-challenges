package com.mdababi.lambdas.streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Employee john = new Employee("John Doe", 30);
		Employee jane = new Employee("Jane Deer", 25);
		Employee jack = new Employee("Jack jackie", 40);
		Employee snow = new Employee("Snow White", 22);

		Departement hr = new Departement("Human resources");
		hr.addEmployee(jane);
		hr.addEmployee(jack);
		hr.addEmployee(snow);

		Departement accounting = new Departement("Accounting");
		accounting.addEmployee(john);

		List<Departement> departements = new ArrayList<Departement>();
		departements.add(hr);
		departements.add(accounting);

		departements.stream().flatMap(departement -> departement.getEmployees().stream()).forEach(System.out::println);

		Set<String> sets = hr.getEmployees().stream().map(employee -> employee.getName()).collect(HashSet::new,
				HashSet::add, HashSet::addAll);
		System.out.println(sets);

		Map<Integer, List<Employee>> groupedByAge = departements.stream()
				.flatMap(departement -> departement.getEmployees().stream())
				.collect(Collectors.groupingBy(employee -> employee.getAge()));
		System.out.println(groupedByAge);
		
		departements.stream().flatMap(departement->departement.getEmployees().stream())
				.reduce((e1, e2)-> e1.getAge() > e2.getAge() ? e2:e1).ifPresent(System.out::println);;
//		List<String> someBingoNumbers = Arrays.asList("N40", "N36", 
//				"B12", "B5", 
//				"G53", "G49", "G60", "G50", "g64",
//				"I26", "I17", "I29", 
//				"O71");
//		List<String> gNumbers = new ArrayList<String>();
//		someBingoNumbers.forEach(name -> {
//			if (name.toUpperCase().startsWith("G")) {
//				gNumbers.add(name);
//			}
//		});
//
//		gNumbers.sort((string1, string2) -> string1.compareTo(string2));
//		gNumbers.forEach(number -> System.out.println(number));
//		
//		someBingoNumbers
//			.stream()
//			.map(String::toUpperCase)
//			.filter(s->s.startsWith("G"))
//			.sorted()
//			.forEach(System.out::println);
//		
//		Stream<String> ioStream = Stream.of("I26", "I17", "I29", "O79");
//		Stream<String> inStream = Stream.of("N40", "N36","I26", "I17", "I29", "O79");
//		
//		Stream<String> concatStream = Stream.concat(ioStream, inStream);
//		//concatStream.filter(s->s.startsWith("N")).forEach(System.out::println);
//		System.out.println(concatStream.distinct().peek(System.out::println).count());

	}

}
