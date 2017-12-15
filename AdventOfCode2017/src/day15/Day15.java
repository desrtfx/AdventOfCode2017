package day15;

public class Day15 {
	
	private static final long GEN_A_START = 591L;
	private static final long GEN_B_START = 393L;
	
	private static final long GEN_A_FACTOR = 16807L;
	private static final long GEN_B_FACTOR = 48271L;
			
	private static final long DIVIDER = 2147483647L; // Integer.MAX_VALUE;
	
	public static int part1() {
		Generator a = new Generator(GEN_A_START, GEN_A_FACTOR, DIVIDER);
		Generator b = new Generator(GEN_B_START, GEN_B_FACTOR, DIVIDER);
		int count = 0;
		
		for(int i=0; i < 40000000; i++) {
			if((a.next() & 0xFFFF) == (b.next() & 0xFFFF)) {
				count++;
			}
		}
		
		return count;
	}

	public static int part2() {
		Generator a = new Generator(GEN_A_START, GEN_A_FACTOR, DIVIDER);
		Generator b = new Generator(GEN_B_START, GEN_B_FACTOR, DIVIDER);
		int count = 0;
		
		for(int i=0; i < 5000000; i++) {
			if((a.next4() & 0xFFFF) == (b.next8() & 0xFFFF)) {
				count++;
			}
		}
		
		return count;
	}

	
	public static void main(String[] args) {
		System.out.printf("Result of Part 1 with input data: %d%n", part1());
		System.out.printf("Result of Part 1 with input data: %d%n", part2());
	}
	
	
	
	
}

class Generator {
	long last;
	long factor;
	long divisor;
	
	public Generator(long start, long factor, long divisor) {
		this.last = start;
		this.factor = factor;
		this.divisor = divisor;
	}
	
	public long next() {
		last = (last * factor) % divisor;
		return last;
	}
	
	public long next4() {
		long tmp = next();
		while ((tmp % 4L) != 0) {
			tmp = next();
		}
		return tmp;
	}
	
	public long next8() {
		long tmp = next();
		while ((tmp % 8L) != 0) {
			tmp = next();
		}
		return tmp;
	}
	
}
