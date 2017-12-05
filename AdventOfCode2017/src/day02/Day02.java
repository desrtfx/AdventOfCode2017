package day02;

import java.util.Arrays;
import java.util.List;

import util.FileIO;

public class Day02 {

	private static final String FILENAME = "./resources/Input_Day02.txt";

	private static int[][] data;

	static {
		List<String> lines = FileIO.getFileAsList(FILENAME);
		data = new int[lines.size()][];
		for (int i = 0; i < lines.size(); i++) {
			String[] curr = lines.get(i).split("\\s+");
			data[i] = new int[curr.length];
			for (int j = 0; j < curr.length; j++) {
				data[i][j] = Integer.parseInt(curr[j]);
			}
			Arrays.sort(data[i]);
		}
	}

	private static int part1(int[][] data) {
		int sum = 0;
		for (int row = 0; row < data.length; row++) {
			int max = data[row][data[row].length - 1];
			int min = data[row][0];
			sum += (max - min);
		}

		return sum;
	}

	private static int part2(int[][] data) {
		int sum = 0;
		for (int row = 0; row < data.length; row++) {
			int result = 0;
			for (int colNum = data[row].length - 1; colNum > 0; colNum--) {
				boolean found = false;
				for (int colDen = colNum - 1; colDen >= 0; colDen--) {
					if (data[row][colNum] % data[row][colDen] == 0) {
						found = true;
						result = data[row][colNum] / data[row][colDen];
						break;
					}
				}
				if (found) {
					break;
				}
			}
			sum += result;
		}

		return sum;
	}

	public static void main(String[] args) {
		int[][] sample1 = new int[][] { { 5, 1, 9, 5 }, { 7, 5, 3 },
				{ 2, 4, 6, 8 } };
		for (int i = 0; i < sample1.length; i++) {
			Arrays.sort(sample1[i]);
		}
		int[][] sample2 = new int[][] { { 5, 9, 2, 8 }, { 9, 4, 7, 3 },
				{ 3, 8, 6, 5 } };
		for (int i = 0; i < sample2.length; i++) {
			Arrays.sort(sample2[i]);
		}

		int expected1 = 18;
		int expected2 = 9;
		int result1 = part1(sample1);
		int result2 = part2(sample2);
		System.out.printf(
				"Test data Part 1 - Result: %d - Expected: %d - %s%n", result1,
				expected1, (result1 == expected1 ? "PASS" : "FAIL"));
		System.out
				.printf("Result of Part 1 with input data: %d%n", part1(data));
		System.out.printf(
				"Test data Part 2 - Result: %d - Expected: %d - %s%n", result2,
				expected2, (result2 == expected2 ? "PASS" : "FAIL"));
		System.out
				.printf("Result of Part 2 with input data: %d%n", part2(data));

	}

}
