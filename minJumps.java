package DP;
import java.util.*;
import java.util.zip.CRC32;
class pair{
	int index;
	int steps; // jumps allowed in given array
	int jump;  // jump requied to reach end
	String psf;
	pair(int index,int steps,int jump,String psf){
		this.index=index;
		this.steps=steps;
		this.jump=jump;
		this.psf=psf;
	}
}

public class minJumps {
	
	public static void  solve(int[] jump) {
		
		int n=jump.length;
		Integer [] dp=new Integer[n];
		dp[n-1]=0;
		for(int i=n-2;i>=0;i--) {
			int step=jump[i];
			if(step==0)
				continue;
			int min=Integer.MAX_VALUE; // finding min 
			for(int j=1;j<=step && i+j<jump.length; j++) {
				if(dp[i+j]!=null && dp[i+j]<min)
					min=dp[i+j];
			}	
			dp[i]=1+min;	
		}
		
		Queue<pair> q=new LinkedList<pair>();
		q.add(new pair(0,jump[0],dp[0],0 + ""));
		while(!q.isEmpty()) {
			pair rem=q.remove();
			if(rem.jump==0)
				System.out.println(rem.psf);
			for(int i=1; i<=rem.steps  && rem.index + i<n; i++) {
				int curridex=rem.index + i;
				if(dp[curridex]!=null && dp[curridex]==rem.jump-1) {
					q.add(new pair(curridex,jump[curridex],dp[curridex],rem.psf + "-->" + curridex));
				}
			}
		}
	}


	public static void main(String[] args) {
		int[] arr= {3,3,0,2,1,2,4,2,0,0};
		solve(arr);
	}

}
