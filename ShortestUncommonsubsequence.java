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

	public static void main(String[] args) {
		String s1="babab";
		String s2="babba";
//		aab is present is s1 but not is s2
		System.out.println(solveDP(s1, s2));
		System.out.println(solveDP("bab", "ab"));
	}

}
