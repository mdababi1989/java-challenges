package com.mdababi.lambdas.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
//		Runnable runnable = () -> {
//			String mystring = "let's split this up into an array";
//			String[] parts = mystring.split(" ");
//			for (String part : parts)
//				System.out.println(part);
//		};
//		new Thread(runnable).start();
//
//		Function<String, String> lambdaFunction = source -> {
//			StringBuilder returnval = new StringBuilder();
//			for (int i = 0; i < source.length(); i++) {
//				if (i % 2 == 1)
//					returnval.append(source.charAt(i));
//
//			}
//			return returnval.toString();
//		};
//		System.out.println(lambdaFunction.apply("1234567890"));
//		System.out.println(everySecondChar(lambdaFunction, "1234567890"));
//
//		Supplier<String> iLoveJava = () -> "I Love Java!";
//		String supplierResult = iLoveJava.get();
//		System.out.println(supplierResult);

		List<String> top2015 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie",
				"harry", "jacob");
//		List<String> firstUpperCaseList = new ArrayList<String>();
//		top2015.forEach(str -> firstUpperCaseList.add(str.substring(0, 1).toUpperCase() + str.substring(1)));
//		firstUpperCaseList.sort(String::compareTo);
//		firstUpperCaseList.forEach(System.out::println);

//		top2015.stream().map(str -> str.substring(0, 1).toUpperCase() + str.substring(1)).sorted(String::compareTo)
//				.forEach(System.out::println);
//
//		System.out.println(top2015.stream().map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
//				.filter(s -> s.startsWith("A")).count());

		top2015
		.stream()
		.map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
		.peek(System.out::println)
		.sorted(String::compareTo)
		.collect(Collectors.toList());
		
	}

	private static String everySecondChar(Function<String, String> lambdaFunction, String source) {
		return lambdaFunction.apply(source);
	}

}


















