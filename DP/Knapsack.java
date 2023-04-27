package DP;
import java.util.*;

class A{
	int i;
	int j;
	String psf;
	A(int i,int j,String psf){
		this.i=i;
		this.j=j;
		this.psf=psf;
	}
}

public class Knapsack {
	
//	find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
	
	public static int knapsack(int []weight,int[] value,int maxWeight) {
		int[][] storage=new int[1+weight.length][1+maxWeight];
		for(int i=0;i<storage.length;i++) {
			for(int j=0;j<storage[0].length;j++) {
				storage[i][j]=-1;
			}
		}
		return knapsackM(weight, value, storage, maxWeight,0);
	}
	
    private static int knapsackM(int[] weight, int[] value,int[][] storage, int maxWeight, int i) {
		
		if(i==weight.length||maxWeight==0) {	
			return 0;
		}
			
		if(storage[i][maxWeight]!=-1) {
			return storage[i][maxWeight];
		}
		
		if(weight[i]>maxWeight){ 
//			weight cannot come.  MOVE ON
			storage[i][maxWeight]=knapsackM(weight, value,storage, maxWeight,i+1);
			return storage[i][maxWeight];
		}else {
			int op1= value[i]+ knapsackM(weight, value,storage, maxWeight-weight[i],i+1);
			// for unbounded replace i+1 by i above only
			int op2=knapsackM(weight, value,storage, maxWeight,i+1);
			storage[i][maxWeight]= Math.max(op1, op2); 
			return storage[i][maxWeight];
		}
	}

	public static int knapsackDP(int[] weights, int[] values,int maxWeight) {// n is size
		int[][] dp=new int[1+weights.length][1+maxWeight];
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				dp[i][j]=dp[i-1][j]; // not selected
				if(j-weights[i-1]>=0) { // selected and check if maxwieght is left
					dp[i][j]= Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+ values[i-1]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		int ans=dp[weights.length][maxWeight];
		Queue<A> q=new LinkedList<A>();
		q.add(new A(weights.length,maxWeight, ""));
		
		while(!q.isEmpty()) {
			A rem=q.remove();
			if(rem.i==0 || rem.j==0) {
				System.out.println(rem.psf);
				break;
			}
			int exclude=dp[rem.i-1][rem.j];
			int include=dp[rem.i-1][rem.j-weights[rem.i-1]] + values[rem.i-1];
			if(dp[rem.i][rem.j]==include) {
				q.add( new A( rem.i-1,rem.j-weights[rem.i-1],values[rem.i-1] + " "+ rem.psf ) );
			}
			if(dp[rem.i][rem.j]==exclude) {
				q.add( new A( rem.i-1,rem.j,rem.psf +  " ") );
			}
		}
		
		return ans;
	}

	
	public static void main(String[] args) {
		int []v= {15,14,10,45,30};
		int []w= {2,5,1,3,4};
//		System.out.println(knapsack(w ,v, 7));
		System.out.println(knapsackDP(w ,v, 7));
	}

}
