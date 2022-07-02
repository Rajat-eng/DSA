package DP;

import java.util.Scanner;

public class fibonacci {
	
	public static int  fib(int n) {
		int [] a=new int [n+1];
		for(int i=0;i<=n;i++) {
			a[i]=-1;
		}
		return fibnum(n,a);
	}
		
		
	public static int  fibnum(int n ,int[]s) {
		if(n==0||n==1) {
			 s[n]=n;
			return s[n];
		}
		if(s[n]!=-1) {
			return s[n];
		}
		
		s[n]=fibnum(n-1,s)+fibnum(n-2,s);
		return s[n];
	}
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(fib(n));
		sc.close();

	}

}
