package DP;
// numbers whose prime factors is only given prime elements in arr
// find numbers till n

import java.util.*;

class C implements Comparable<C>{
	int prime;
	int pos;
	int value;
	C(int prime,int pos,int value){
		this.prime=prime;
		this.pos=pos;
		this.value=value;
	}
	public int compareTo(C o) {
		return this.value-o.value;
	}
}

public class UglyNumbers {
	
	private static void print(int[] arr, int n) {
		PriorityQueue<C> pq=new PriorityQueue<>();
		int[] dp=new int[1+n];
		for(int i=0;i<arr.length;i++) {
			pq.add(new C(arr[i],1,arr[i]));
		}
		dp[1]=1; // 1 has all prime factors
		for(int i=2;i<=n;) {
			C rem=pq.remove();
			if(dp[i-1]!=rem.value) {
				dp[i]=rem.value;
				i++;
			}
			pq.add(new C(rem.prime,rem.pos+1,rem.prime*dp[rem.pos+1]));
		}
		
		for(int i=1;i<=n;i++) {
			System.out.print(dp[i] + " ");
		}
	}

	public static void main(String[] args) {
		int [] arr= {3,5,7,11};
		int n=20;
		print(arr,n);
	}

	

}
