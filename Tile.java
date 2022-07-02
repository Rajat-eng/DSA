package DP;
import java.util.Scanner;
//  tile is m*1
//  floor is m*n --> mis vertical n is horizontal
// find total ways to tile the floor
public class Tile {
	
	public static int ways(int m,int n) {
		int []dp=new int[1+n];
//		f(m,n)=f(m,n-1) + f(m,n-m)
		for(int i=1;i<=n;i++) {
			if(i<m)// floor is less than tile length thrn tile can be vertical only ( 5*1 tile can fit 5*4 floor only in vertical way)
				dp[i]=1;
			else if(i==m)
				dp[i]=2;
			else
				dp[i]=dp[i-1]+dp[i-m]; // vertical + horizontal
		}
		return dp[n];
	}
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		System.out.println(ways(m,n));
		sc.close();
	}

}
