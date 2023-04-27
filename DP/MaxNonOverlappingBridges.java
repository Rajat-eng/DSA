package DP;
import java.util.*;
class Bridge implements Comparable<Bridge>{
	int north;
	int south;
	Bridge(int north,int south){
		this.north=north;
		this.south=south;
	}
	public int compareTo(Bridge o) {
		if(north==south) {
			return this.south-o.south;
		}else {
			return this.north-o.north;
		}
	}
}

public class MaxNonOverlappingBridges {
	
	public static int solve(Bridge[] bdgs) {
		Arrays.sort(bdgs); // sorting north points of bridges
		int n=bdgs.length;
		int []dp=new int[n];
		int ans=0;
		for(int i=0;i<n;i++) {
			int max=0;
			for(int j=0;j<i;j++) {		
				if(bdgs[i].south>=bdgs[j].south) {// south of current bridge should be greater than other bridges
					if(dp[j]>max)
						max=dp[j];
				}
			}
			dp[i]=1+max;
			System.out.println(dp[i]);
			if(dp[i]>ans)
				ans=dp[i];
		}
		return ans;
	}

	public static void main(String[] args) {
//		10
//		10 20
//		2 7
//		8 15
//		17 3
//		21 40
//		50 4
//		41 57
//		60 80
//		80 90
//		1 30
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Bridge[] bdgs=new Bridge[n];
		for(int i=0;i<n;i++) {
			int north=sc.nextInt();
			int south=sc.nextInt();
			bdgs[i]=new Bridge(north,south);
		}
		System.out.println((solve(bdgs)));
		sc.close();
	}

}
