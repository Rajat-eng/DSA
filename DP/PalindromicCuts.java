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





// import java.util.Scanner;

// public class ZumaGame {
//     static int[][] dp; // memoization array

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         int n = scanner.nextInt(); // number of gemstones
//         int[] colors = new int[n]; // array to store the colors of gemstones

//         for (int i = 0; i < n; i++) {
//             colors[i] = scanner.nextInt();
//         }

//         dp = new int[n][n]; // initialize the memoization array with -1

//         int minSeconds = calculateMinSeconds(colors, 0, n - 1); // calculate the minimum number of seconds

//         System.out.println(minSeconds);

//         scanner.close();
//     }

//     private static int calculateMinSeconds(int[] colors, int start, int end) {
//         if (start > end) {
//             return 0;
//         }

//         if (dp[start][end] != 0) {
//             return dp[start][end];
//         }

//         // Base case: A single gemstone is always a palindrome
//         if (start == end) {
//             dp[start][end] = 1;
//             return dp[start][end];
//         }

//         // If the colors at both ends are the same, we can remove the ends and get the result for the inner substring
//         if (colors[start] == colors[end]) {
//             if (start + 1 == end) {
//                 dp[start][end] = 1;
//             } else {
//                 dp[start][end] = calculateMinSeconds(colors, start + 1, end - 1);
//             }
            
//         }else{
// 	  dp[start][end] = end - start + 1; // initialize with the maximum possible value
	  
//         // Find the minimum number of seconds by splitting the substring at different positions and taking the minimum
       
//           for (int k = start; k < end; k++) {
//             dp[start][end] = Math.min(dp[start][end], calculateMinSeconds(colors, start, k) + calculateMinSeconds(colors, k + 1, end));
//           }
// 	}
//         return dp[start][end];
//     }
// }
