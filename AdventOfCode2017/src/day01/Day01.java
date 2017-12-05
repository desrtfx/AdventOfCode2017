package day01;

import util.FileIO;

public class Day01 {

	private static final String FILENAME = "./resources/Input_Day01.txt";
	
	private static String data;
	
	static {
		data = FileIO.getFileAsString(FILENAME);
	}
	
	
	public static int part(String data,int offset) {
		char[] tmpDigits = data.toCharArray();
		int[] digits = new int[tmpDigits.length];
		int sum = 0;
		
		for(int i=0; i < tmpDigits.length; i++) {
			digits[i] = tmpDigits[i] - '0';
		}
		
		for(int i = 0; i < digits.length; i++) {
			if (digits[i] == digits[(i+offset) % digits.length]) {
				sum+=digits[i];
			}
		}
		
		return sum;
	}
	
	public static int part2(String data) {
		return 0;
	}
	
	public static void main(String[] args) {
		String[] testData = new String[] {"1122", "1111", "1234", "91212129"};
		int[] expected = new int[] {3, 4, 0, 9};
		for(int i= 0; i < testData.length; i++) {
			int result = part(testData[i],1);
			System.out.printf("Test data #%d - String: %s - Result: %d - Expected: %d - %s%n",i+1,testData[i],result,expected[i],(result == expected[i]?"PASS":"FAIL"));
		}
		System.out.println();
		System.out.printf("Result of Part 1 with input data: %d%n", part(data,1));
		System.out.printf("Result of Part 2 with input data: %d%n", part(data,data.length()/2));
		
	}
	
	
}
