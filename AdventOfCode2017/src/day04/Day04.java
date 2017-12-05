package day04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.FileIO;

public class Day04 {

	private static final String FILENAME = "./resources/Input_Day04.txt";

	private static List<String> data = FileIO.getFileAsList(FILENAME);

	private static boolean isValid(String data) {
		String[] line = data.split("\\s+");
		Set<String> unique = new HashSet<>(Arrays.asList(line));
		return line.length == unique.size();
	}

	private static boolean isAnagram(String first, String second) {
		if (first.length() != second.length()) { // all characters used rule
			return false; // if not all characters are used, can't be an anagram
		}
		char[] firstC = first.toCharArray();
		char[] secondC = second.toCharArray();
		Arrays.sort(firstC);
		Arrays.sort(secondC);
		return Arrays.equals(firstC, secondC);
	}

	private static boolean noAnagrams(String data) {
		String[] line = data.split("\\s+");
		for (int i = 0; i < line.length - 1; i++) {
			for (int j = i + 1; j < line.length; j++) {
				if (isAnagram(line[i], line[j])) {
					return false;
				}
			}
		}
		return true;
	}

	private static int part1(List<String> data) {
		int count = 0;

		for (int i = 0; i < data.size(); i++) {
			if (isValid(data.get(i))) {
				count++;
			}
		}
		return count;
	}

	private static int part2(List<String> data) {
		int count = 0;
		for (int i = 0; i < data.size(); i++) {
			String curr = data.get(i);
			if (isValid(curr) && noAnagrams(curr)) {
				count++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		String[] sample1 = new String[] { "aa bb cc dd ee", "aa bb cc dd aa",
				"aa bb cc dd aaa" };
		int expected1 = 2;
		String[] sample2 = new String[] { "abcde fghij", "abcde xyz ecdab",
				"a ab abc abd abf abj", "iiii oiii ooii oooi oooo",
				"oiii ioii iioi iiio" };
		int expected2 = 3;

		int result1 = part1(Arrays.asList(sample1));
		int result2 = part2(Arrays.asList(sample2));

		System.out.printf(
				"Test data Part 1 - Result: %d - Expected: %d - %s%n", result1,
				expected1, (result1 == expected1 ? "PASS" : "FAIL"));
		System.out
				.printf("Result of Part 1 with input data: %d%n", part1(data));
		System.out.printf(
				"Test data Part 2 - Result: %d - Expected: %d - %s%n", result2,
				expected2, (result2 == expected2 ? "PASS" : "FAIL"));
		System.out
				.printf("Result of Part 1 with input data: %d%n", part2(data));
	}

}
