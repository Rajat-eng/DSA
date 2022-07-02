package DP;

public class LongestRepeatingSubsequence {
//	LongestDuplicateSubstring
	private static int solve(String s) {
		int m=s.length();
		int [][] storage=new int[1+m][1+m];
		for(int i=0;i<=m;i++) {
			storage[i][0]=0;
		}
		for(int i=0;i<=m;i++) {
			storage[0][i]=0;
		}
		for(int i=s.length()-1;i>=0;i--) {
			for(int j=s.length()-1;j>=0;j--) {
				if(s.charAt(i)==s.charAt(j) && (i)!=(j)) { 
//					checking last characcter while in memo we check first therefore i-1 can be replaced by m-i and j-1 bny n-j
					storage[i][j]=1+storage[i+1][j+1];
				}else {
					storage[i][j]=Math.max(storage[i+1][j], storage[i][j+1]);
				}
			}
		}
		return storage[0][0];
	}

	public static void main(String[] args) {
		String s="abacbc";
//		abc is repeated two times but we  have to find lcs only when character at index matches but index does not matches
		System.out.println(solve(s));

	}

}
