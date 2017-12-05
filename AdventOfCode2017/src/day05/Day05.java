package day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.FileIO;

public class Day05 {

	private static final String FILENAME = "./resources/Input_Day05.txt";

	private static List<String> rawData = new ArrayList<>();
	private static int[] data;
	
	static {
		rawData = FileIO.getFileAsList(FILENAME);
		data = new int[rawData.size()];
		for(int i=0; i < rawData.size();i++) {
			data[i] = Integer.parseInt(rawData.get(i));
		}
	}
	
	static int part1(int[] input) {
		int ip = 0; // Instruction Pointer
		int steps = 0; // Step counter
		int[] tmpData = Arrays.copyOf(input, input.length); // do not alter the original array
		
		do {
			int tmpIp = ip + tmpData[ip];
			tmpData[ip]++;
			ip = tmpIp;
			steps++;
			
		} while ((ip < tmpData.length) && (ip >= 0));
		
		
		
		return steps;
	}

	static int part2(int[] input) {
		int ip = 0; // Instruction Pointer
		int steps = 0; // Step counter
		int[] tmpData = Arrays.copyOf(input, input.length); // do not alter the original array
		
		do {
			int tmpIp = ip + tmpData[ip];
			if (tmpData[ip] >= 3) {
				tmpData[ip]--;
			} else {
				tmpData[ip]++;
			}
			ip = tmpIp;
			steps++;
			
		} while ((ip < tmpData.length) && (ip >= 0));
		
		
		
		return steps;
	}
	
	
	
	public static void main(String[] args) {
		
		int[] sample = new int[] {0, 3, 0, 1, -3};
		System.out.printf("Part1: Steps in sample: %d%n", part1(sample));
		System.out.printf("Part1: Steps in input data: %d%n", part1(data));
		System.out.printf("Part2: Steps in sample: %d%n", part2(sample));
		System.out.printf("Part2: Steps in input data: %d%n", part2(data));
		
	}
	
}
