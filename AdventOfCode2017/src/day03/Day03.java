package day03;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import util.Direction;

public class Day03 {

	private static final int input = 368078;
		
	private static Map<Point, Integer> mem = new HashMap<>();
	
	private static Point move(Point p, Direction dir) {
		return new Point(p.x + dir.getDx(), p.y + dir.getDy());
	}
	
	private static int sumNeighbors(Point p) {
		int sum = 0;
		for(int y = -1; y < 2; y++) {
			for(int x = -1; x < 2; x++) {
				if (!((x == 0) && (y == 0))) {
					Point tmp = new Point(p.x + x, p.y + y);
					sum += mem.getOrDefault(tmp, 0);
				}
			}
		}
		
		return sum;
	}
	
	
	private static int part1(int input) {
		int result = 0;
		Direction dir = Direction.EAST; // first move goes to east
		boolean incMaxStep = false;
		int currVal = 1;
		int maxStep = 1;
		int step = 1;
		Point p;
		p = new Point(0,0);
		mem.put(p, currVal);
		while(currVal < input) {
			step++;
			currVal++;
			p = move(p, dir);
			mem.put(p, currVal);

			if (step >= maxStep) {
				dir = dir.getLeft();
				step = 0;
				incMaxStep = !incMaxStep;
				if (!incMaxStep) {
					maxStep++;
				}
				
			}
			
		}
		
		result = Math.abs(p.x) + Math.abs(p.y);
		
		return result;
	}

	private static int part2(int input) {
		mem.clear();
		int result = 0;
		Direction dir = Direction.EAST; // first move goes to east
		boolean incMaxStep = false;
		int currVal = 1;
		int maxStep = 1;
		int step = 1;
		Point p;
		p = new Point(0,0);
		mem.put(p, currVal);
		while(currVal < input) {
			step++;
			currVal++;
			p = move(p, dir);
			int s = sumNeighbors(p);
			mem.put(p, s);
			if(s > input) {
				return s;
			}

			if (step >= maxStep) {
				dir = dir.getLeft();
				step = 0;
				incMaxStep = !incMaxStep;
				if (!incMaxStep) {
					maxStep++;
				}
				
			}
			
		}
		
		result = Math.abs(p.x) + Math.abs(p.y);
		
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] sample1 = new int[] {1, 12, 23, 1024};
		int[] expected1 = new int[] {0, 3, 2, 31};
		
		for(int i = 0; i < sample1.length; i++) {
			int result = part1(sample1[i]);
			System.out.printf("Test data #%d - String: %s - Result: %d - Expected: %d - %s%n",i+1,sample1[i],result,expected1[i],(result == expected1[i]?"PASS":"FAIL"));

		}
		System.out.println();
		System.out.printf("Result of Part 1 with input data: %d%n", part1(input));
		System.out.printf("Result of Part 2 with input data: %d%n", part2(input));

	}
}
