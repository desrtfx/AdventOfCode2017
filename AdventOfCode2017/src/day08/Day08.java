package day08;

import java.util.regex.Pattern;

public class Day08 {
	
	private static final String FILENAME = "./resources/Input_Day08.txt";
	
	private static final String PATTERN = "(?<reg>[a-z]+)\\s(?<inst>(inc|dec))\\s(?<amt>\\-?\\d+)\\sif\\s(?<src>[a-z]+)\\s(?<cmp>[><!=]=?)\\s(?<val>\\-?\\d+)";

}

class Command {

	private static final String PATTERNSTRING = "(?<reg>[a-z]+)\\s(?<inst>(inc|dec))\\s(?<amt>\\-?\\d+)\\sif\\s(?<src>[a-z]+)\\s(?<cmp>[><!=]=?)\\s(?<val>\\-?\\d+)";
	// regex URL: https://regex101.com/r/eIqvcj/1
	private static final Pattern PATTERN = Pattern.compile(PATTERNSTRING);
	
	String regDest;
	String inst;
	int amtChg;
	String regSrc;
	String op;
	int amtComp;
}
