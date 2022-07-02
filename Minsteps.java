package DP;
import java.util.Scanner;
// reduce n to 1 by perfroming one of follwoing operations
// subtract by 1
// divide by 2
// divide ny 3

public class Minsteps {
	
	public static int countsteps(int n) {
		int [] arr=new int[n+1];
		return countstepsM(n, arr);
	}
	
	public static int countstepsM(int n,int[] arr) {
        if(n==1) {
			return 0;
		}
		if(arr[n]!=0) {
			return arr[n];
		}
		int opt1=countstepsM(n-1,arr);
		int minsteps=opt1;
		if(n%2==0) {
			int opt2=countstepsM(n/2,arr);
			if(minsteps>opt2) {
				minsteps=opt2;
			}				
		}
		if(n%3==0) {
			int opt3=countstepsM(n/3,arr);
			if(minsteps>opt3) {
				minsteps=opt3;
			}	
		}
		arr[n]=1+minsteps;
		return 1+minsteps;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(countsteps(n));
		sc.close();
	}

}
