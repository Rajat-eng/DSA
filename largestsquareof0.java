package DP;

public class largestsquareof0 {
	
    public static int findMaxSquareWithAllZeros(int[][] input){
    	int ans=0;
    	int r=input.length;
      if(r==0)
    	  return ans;
      int c=input[0].length;
     int [][] dp=new int[r][c];
     
     for(int i=r-1;i>=0;i--) {
   	  for(int j=c-1;j>=0;j--) {
   		 if(i==r-1 && j==c-1) {
   			 if(input[i][j]==1) {
     				dp[i][j]=0;
     			}else {
     				dp[i][j]=1;
     			}
   		 } else if(i==r-1) {
   			if(input[i][j]==1) {
   				dp[i][j]=0;
   			}else {
   				dp[i][j]=1;
   			}
   		 } else if(j==c-1) {
   			 if(input[i][j]==1) {
    				dp[i][j]=0;
    			}else {
    				dp[i][j]=1;
    			}
   		 }else {
   			 if(input[i][j]==1) {
   				 dp[i][j]=0;
   			 }else {
   				 int min=Math.min(dp[i+1][j], Math.min(dp[i+1][j+1],dp[i][j+1]));
   				 dp[i][j]=1+min;
   			 }
   		 }
   		 if(dp[i][j]>ans)
   			 ans=dp[i][j];
   	  }
     }
      return ans;
	}	

	public static void main(String[] args) {
	 int [][] arr= {};
	 System.out.println(findMaxSquareWithAllZeros(arr));
	}

}
