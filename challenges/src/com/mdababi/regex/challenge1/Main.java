package com.mdababi.regex.challenge1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {


		
		String regex = "^\\d{5}(-\\d{4}){0,1}$";
		System.out.println("11111".matches(regex));
		System.out.println("11111-1111".matches(regex));
		
		
		
		
		
		
		
		
		
		
		
		
//		String challenge11 = "{0,2},{0,5},{1,3},{2,4}";
//		
//		Pattern pattern = Pattern.compile("\\{(.+?)\\}");
//		Matcher matcher = pattern.matcher(challenge11);
//		
//		while(matcher.find()) {
//			System.out.println(matcher.group(1));
//		}

//		String challenge1 = "I want a bike.";
//		String challenge2 = "I want a ball.";
//		String challenge4 = "Replace all blanks with underscores.";
//		String challenge5 = "aaabccccccccdddefffg";
//
//		
//		String challenge8 = "abcd.135\tuvqz.7\ttzik.999\n";
//		String challenge8regex = "[A-Za-z]+\\.(\\d+)\\s";
//		
//		Pattern pattern = Pattern.compile(challenge8regex);
//		Matcher matcher = pattern.matcher(challenge8);
//		
//		while (matcher.find()) {
//			System.out.println("occurence :" + matcher.start(1)+" to "+ matcher.end(1));
//		}
//		
//		String regex = "[a-z]+[.][0-9]+";
//		System.out.println("aaaa.555".matches(regex));
//	
//		
//		String challengeRegex = "I want a \\w+.";
//		Pattern pattern = Pattern.compile(challengeRegex);
//
//		System.out.println(pattern.matcher(challenge1).matches());
//		System.out.println(pattern.matcher(challenge2).matches());
//
//		System.out.println(challenge4.replaceAll("[ ]", "_"));

//		System.out.println(challenge1.matches("^I[ ][a-z]{4}[ ][a-z]{1}[ ][a-z]{4}."));
//		System.out.println(challenge1.matches("^I"));
//		
//		System.out.println(challenge1.replaceAll("^I[ ][a-z]{4}[ ][a-z]{1}[ ][a-z]{4}.", "X"));
//		
//		
//		String challenge1Regex = "^I[ ]?{3}[ ]?{1}[ ]?{5}$";
//		
//		Pattern pattern = Pattern.compile(challenge1Regex);
//		Matcher matcher = pattern.matcher(challenge1);		
//		System.out.println(matcher.matches());

	}
}
