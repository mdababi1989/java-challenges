package com.mdababi.regex.introduction;

public class Main {

	public static void main(String[] args) {
		String string = "I'm a String. Yes I'm ";
		String yourString = string.replaceAll("I", "You");
		System.out.println(yourString);
	}

}
