package com.mdababi.unitTesting.challenge;

public class Utilities {

	// return a char array containing every nth char
	// if sourceArray length <n return sourceArray
	public char[] everyNthChar(char[] sourceArray, int n) {
		if (sourceArray == null || sourceArray.length < n)
			return sourceArray;

		int retunedLength = sourceArray.length / n;
		char[] returnedArray = new char[retunedLength];
		for (int i = 1; i <= retunedLength; i++) {
			returnedArray[i - 1] = sourceArray[i * n - 1];
		}

		return returnedArray;
	}

	// remove pairs of the same character that are next to each other
	public String removePairs(String source) {
		if (source == null || source.length() < 2)
			return source;
		StringBuilder sb = new StringBuilder();
		sb.append(source.charAt(0));
		for (int i = 1; i < source.length(); i++)
			if (source.charAt(i) != source.charAt(i - 1))
				sb.append(source.charAt(i));
		return sb.toString();

	}

	// perform a conversion based on some internal business rules
	public int converter(int a, int b) {
		return (a / b) + (a * 30) - 2;
	}

	public String nullIfOddLength(String source) {
		return (source.length() % 2 == 0) ? source : null;
	}

}
