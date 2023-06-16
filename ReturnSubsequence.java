package datastructure;

import java.util.Scanner;

public class ReturnSubsequence {
	
	public static String[] subsequences(String input) {

		
		
		if(input.length() == 0) {
			//base case
			String [] output = new String[1];
			output[0] = "";
			return output;
		}
		String[] smallOuput = subsequences(input.substring(1));
		String[] output = new String[smallOuput.length * 2];
		for(int i = 0 ; i < smallOuput.length ; i++) {
			output[i] = smallOuput[i];
		}
		for(int i = 0 ; i < smallOuput.length ; i++) {
			output[smallOuput.length + i] = input.charAt(0) + smallOuput[i];
		}
		return output;
	}

	public static void printsubsequences(String input,String stringSoFar) {
		if(input.length() == 0) {
			System.out.println(stringSoFar);
			return;
		}
		String smallInput = input.substring(1);
		printsubsequences(smallInput,stringSoFar);
		printsubsequences(smallInput,stringSoFar + input.charAt(0));
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
//		String[] output = subsequences(input);
//		for(String outputString : output) {
//			System.out.println(outputString);
//		}
		printsubsequences(input,"");

	}

}
