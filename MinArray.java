package datastructure;

public class MinArray {
	public static int findMin(int []input , int start) {
		if(start == input.length) {
			return Integer.MAX_VALUE;
		}
		int minSmallArray = findMin(input,start + 1);
		if(input[start] < minSmallArray) {
			return input[start];
		}else {
			return minSmallArray;
		}
	}
	
	public static void printMin1(int []a) {
		int min = findMin(a,0);
		System.out.println(min);
	}
	
	public static void printMin2(int []a , int start,int minSoFar) {
		if(start == a.length) {
			System.out.println(minSoFar);
			return;
		}
		int newMinimum = minSoFar;
		if(a[start] < minSoFar) {
			newMinimum = a[start];
		}
		printMin2(a ,start + 1 ,newMinimum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3,4,2,1,7,8};
		printMin2(a,0,Integer.MAX_VALUE);
	}

}
