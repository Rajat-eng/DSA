package DP;
// min cuts to make string palindrome
public class PalindromicCuts {
	
	public static boolean isPalindrome(String input,int i,int j) {
		while(i<j) {
			if(input.charAt(i)!=input.charAt(j))
				return false;
			i++; j--;
		}
		return true;
	}
	
	public static  int countPalindrome(String input,int i,int j) {
//		O[n*2^n]
		if(i>=j || isPalindrome(input, i, j))
			return 0;
		int count=0;
		int ans=Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			count= countPalindrome(input, i, k) + countPalindrome(input, k+1, j) + 1;
			ans=Math.min(ans, count);
		}
	   return ans;
	}
	
	public static int countPalindromeDP(String input) {
		int n=input.length();
		boolean isPalindrome[][]=new boolean[n][n];
		for(int gap=0;gap<n;gap++) {
			for(int i=0,j=gap;j<n;j++,i++) {
				if(gap==0) {
					isPalindrome[i][j]=true;
				}else if(gap==1) {
					isPalindrome[i][j]=(input.charAt(i)==input.charAt(j));
				}else {
					isPalindrome[i][j]= (input.charAt(i)==input.charAt(j)) && isPalindrome[i+1][j-1];
				}
			}
		}
		
		int dpa[][]=new int[input.length()][input.length()];
		for(int gap=0;gap<n;gap++) {
			for(int i=0,j=gap;j<n;j++,i++) {
				if(gap==0) {
					dpa[i][j]=0;
				}else if(gap==1) {
					if(input.charAt(i)==input.charAt(j)) {
						dpa[i][j]=0; // no cuts
					}else {
						dpa[i][j]=1;
					}
				}else {
					if(isPalindrome[i][j]) {
						dpa[i][j]=0;
					}else {
						int min=Integer.MAX_VALUE;
						for(int k=i;k<j;k++) {
							int left=dpa[i][k];
							int right=dpa[k+1][j];
							int totalcuts=1+left+right;
							if(totalcuts<min)
								min=totalcuts;
						}
						dpa[i][j]=min;
					}
				}
			}
		}
	
		return dpa[0][input.length()-1];
		
		
//		int dp[]=new int[n];
//		dp[0]=0;
//		for(int j=1;j<input.length();j++) {	
//			if(isPalindrome[0][j]) { // whole string is palindrome
//				dp[j]=0;
//			}else {
//				int min=Integer.MAX_VALUE;
//				for(int i=j;i>=1;i--) { 
//// 					extracting palindromic suffix from last
////					abccb==  (b) + abcc    or   (bccb) + a
//					if(isPalindrome[i][j]) {
//						if(dp[i-1]<min) {
//							min=dp[i-1];
//						}
//					}		
//				}
//				dp[j]=1+min;
//			}
//			//System.out.print(dp[j] + " ");
//		}
//		return dp[n-1];
	}

	public static void main(String[] args) {
		String s="ababbbabbababa";
		String temp="abccbc";
//		test abccbc
		int ans=countPalindromeDP(temp);
		System.out.println("ans"+ans);
	}

}
