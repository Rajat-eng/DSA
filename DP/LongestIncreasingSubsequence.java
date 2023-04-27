package DP;
import java.util.*;
class B{
	int index;
	int value;
	String psf;
	B(int index,int value,String psf){
		this.index=index;
		this.value=value;
		this.psf=psf;
	}
}


public class LongestIncreasingSubsequence {
	
	 public static int lis(int arr[]) {
		 int ans=0;
		 int n=arr.length;		 
	     int [] dp=new int[n];
	     for(int i=0;i<n;i++) {
	    	 int max=0;
	    	 for(int j=0;j<i;j++) {
	    		 if(arr[i]>arr[j]) {
	    			 if(dp[j]>max)
	    				 max=dp[j];
	    		 }
	    	 }
	    	 dp[i]=1+max;
	     }
	     
	     for(int i=0;i<n;i++) {
	    	 if(dp[i]>ans)
	    		 ans=dp[i];
	     }
	     
	     Queue<B> q=new LinkedList<B>();
	   
	     for(int i=0;i<dp.length;i++) {
	    	if(ans==dp[i]) {
	    		q.add(new B(i,ans,arr[i] + " "));
	    	}	
	    }
	    while(!q.isEmpty()) {
	    	B rem=q.remove();
	    	if(rem.value==1) {
	    		System.out.println(rem.psf);
	    	}
	    	for(int j=0;j<rem.index;j++) {
	    		if(dp[j]==rem.value-1 && arr[j]<arr[rem.index]) {
	    			q.add(new B(j,dp[j],arr[j] + " " +rem.psf));
	    		}		
	    	}	
	    }
	     
	     return ans;
	 }
	 
	 public static int lisSum(int[]arr) {
		
		 int n=arr.length;	
		 int [] dp=new int[n];
		 dp[0]=arr[0];
		 for(int i=1;i<n;i++) {
			 int maxsum=0;
			 for(int j=0;j<i;j++) {
				 if(arr[j]<arr[i]) {
					 int psum=dp[j]+arr[i];
					 if(psum>maxsum) {
						 maxsum=psum;
					 }
				 }
			 }
			 dp[i]=maxsum;
		 }
		 int max=-1;
		 for(int i=0;i<n;i++) {
//			 System.out.print(dp[i] + " " );
			 if(dp[i]>max) {
				 max=dp[i];
			 }
		 }
		 return max;
	 }
	 
	 private static int lds(int[] arr) {
//		 longest decreasing subsequence
		 int ans=0;
		 int n=arr.length;		 
	     int [] dp=new int[n];
	     for(int i=n-1;i>=0;i--) {
	    	 int max=0;
	    	 for(int j=n-1;j>i;j--) {
	    		 if(arr[i]>=arr[j]) {
	    			 if(dp[j]>max)
	    				 max=dp[j];
	    		 }
	    	 }
	    	 dp[i]=1+max;
	     }
	     
	     for(int i=0;i<n;i++) {
	    	 if(dp[i]>ans)
	    		 ans=dp[i];
	     }
	     return ans;
	 }
	 

	public static void main(String[] args) {
		int []a= {10,22,9,33,21,50,41,60,80,1};
		System.out.println(lis(a));
		System.out.println(lds(a));
		System.out.println("ans"+lisSum(a));
	}



	

}
