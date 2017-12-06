package day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day06 {

	private static final int[] data = { 4, 10, 4, 1, 8, 4, 9, 14, 5, 1, 14, 15,
			0, 15, 3, 5 };

	private static int maxIndex(int[] data) {
		int maxIdx = 0;
		int maxVal = data[0];
		for (int i = 1; i < data.length; i++) {
			if (maxVal < data[i]) {
				maxVal = data[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}

	private static int[] clone(int[] data) {
		return Arrays.copyOf(data, data.length);
	}

	private static int part1(int[] data) {
		List<int[]> combos = new ArrayList<>();
		int moves = 0;
		int[] mem = clone(data);
		combos.add(clone(mem));
		boolean unique = true;
		while (unique) {
			int idx = maxIndex(mem);
			int val = mem[idx];
			mem[idx] = 0;
			for (int i = 0; i < val; i++) {
				mem[(idx + 1 + i) % mem.length]++;
			}
			for (int[] a : combos) {
				if (Arrays.equals(mem, a)) {
					unique = false;
					break;
				}
			}
			combos.add(clone(mem));
			moves++;
		}

		return moves;
	}

	private static int part2(int[] data) {
		List<int[]> combos = new ArrayList<>();
		int moves = 0;
		int first = 0;
		int[] mem = clone(data);
		combos.add(clone(mem));
		boolean unique = true;
		while (unique) {
			int idx = maxIndex(mem);
			int val = mem[idx];
			mem[idx] = 0;
			for (int i = 0; i < val; i++) {
				mem[(idx + 1 + i) % mem.length]++;
			}
			for (int i = 0; i < combos.size(); i++) {
				if (Arrays.equals(mem, combos.get(i))) {
					unique = false;
					first = i;
					break;
				}
			}
			combos.add(clone(mem));
			moves++;
		}

		return moves - first;
	}

	public static void main(String[] args) {
		int[] sample1 = new int[] { 0, 2, 7, 0 };
		int expected1 = 5;
		int[] sample2 = new int[] { 0, 2, 7, 0 };
		int expected2 = 4;

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
