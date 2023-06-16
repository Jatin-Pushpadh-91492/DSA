package datastructure;

import java.util.Scanner;

public class MinSquare {
	public static int minSquare(int n,int dp[]) {
		if(n==0) {
			return 0;
		}
		int minAns = Integer.MAX_VALUE;
		for(int i = 1 ; i * i <= n; i++) {
			int curr;
			if(dp[n-(i*i)] == -1) {
				curr = minSquare(n-(i*i),dp);
				dp[n-(i*i)] = curr;
			}else {
				curr = dp[n-(i*i)];
			}
			if(minAns > curr) {
				minAns = curr;
			}
		}
		int myAns = 1 + minAns;
		return myAns;
	}
	public static void main(String [] args) {
//		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
//		int result = minSquare(n);
//		System.out.println(result);
		int n = 11;
		int dp[] = new int[n + 1];
		for(int i = 0 ; i < dp.length ; i++) {
			dp[i] = -1;
		}
		int ans = minSquare(n,dp);
		System.out.println(ans);
	}

}
