package datastructure;
import java.util.Scanner;

public class ReturnKeyapd {
	
	public static String getOptions(int digit) {
		if(digit == 2) {
			return "abc";
		}
		if(digit == 3) {
			return "def";
		}
		if(digit == 4) {
			return "ghi";
		}
		if(digit == 5) {
			return "jkl";
		}
		if(digit == 6) {
			return "mno";
		}
		if(digit == 7) {
			return "pqrs";
		}
		if(digit == 8) {
			return "tuv";
		}
		if(digit == 9) {
			return "wxyz";
		}
		return "";
	}
	
	public static String[] keypadCombination(int input) {
		if(input == 0) {
			String[] output = new String[1];
			output[0] = "";
			return output;
		}
		int k = 0;
		String[] samllOutput = keypadCombination(input / 10);
		int lastDigit = input % 10;
		String lastDigitOption = getOptions(lastDigit);
		String [] output = new String[samllOutput.length * lastDigitOption.length()];
		for(int i = 0 ; i < samllOutput.length;i++) {
			for(int j = 0 ; j < lastDigitOption.length();j++) {
				output[k++] = samllOutput[i] + lastDigitOption.charAt(j);
			}
		}
		return output;
		
	}
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		String[] output = keypadCombination(input);
		for(String ans : output) {
			System.out.println(ans);
		}
	}

}
