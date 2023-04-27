package DP;
// Given two strings S and T, find the length of the shortest subsequence in S which is not a subsequence in T.
public class ShortestUncommonsubsequence {
	
	public static  int solveDP(String S,String T){
        
	    int n=S.length(), m=T.length();
	        
	    int dp[][]=new int[n+1][m+1];
	        
	        int MAX = 600;
	        
	        for(int i=n;i>=0;i--) dp[i][m]=1; // last column when T is zero then shortest is 1
	        for(int i=m;i>=0;i--) dp[n][i]=MAX;  // last row when S is zero then shoretst is MAX bcoz we have to take Min
	        
	        for(int i=n-1;i>=0;i--) {       
	            for(int j=m-1;j>=0;j--) {
	                char ch=S.charAt(i);
	                int k;
	                for(k=j;k<m;k++) {
//	                	check all chars in T , if it occurs it can be included in answer of excluded
	                    if(T.charAt(k)==ch) break;
	                }
//	                  if char is S is not found in T then it is included in answer
	                if(k>=m) {
	                  dp[i][j]=1;
	                }else {                
	                  dp[i][j] = Math.min(dp[i+1][j], dp[i+1][k+1]+1);   
	                }
	            }
	        }
	        
	        if(dp[0][0] >= MAX) return -1;
	        return dp[0][0];    
	    }
	
	
	public static int solve(String S,String V){
        int[][]dp=new int [1+S.length()][1+V.length()];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return solvehelper(S,V,dp);
    }

	public static int solvehelper(String S,String V,int[][] dp){
        
        int m=S.length();
        int n=V.length();
          
        if(S.length() <= 0)
        {
            return 600;
        }
        
        if(V.length() <= 0)
        {
            return 1;
        }
        
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        
		char ch = S.charAt(0);
        
        int i = 0;
        while(i < V.length() && V.charAt(i) != ch)
        {
          	i++;
        }
        
        if(i>V.length()-1){
            return 1;
        }
        
        int exc = solvehelper(S.substring(1), V,dp); 

        int inc = 1 + solvehelper(S.substring(1), V.substring(i+1),dp); 
	
    	return dp[m][n]=Math.min(exc, inc);
        
    }

	public static void main(String[] args) {
		String s1="babab";
		String s2="babba";
//		aab is present is s1 but not is s2
		System.out.println(solveDP(s1, s2));
		System.out.println(solveDP("bab", "ab"));
	}

}
