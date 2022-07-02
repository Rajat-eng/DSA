package DP;

public class Longestcommonsubsequence {
	
	public static int lcs(String a,String b) {
		int m=a.length();
		int n=b.length();
		int [][] storage=new int[1+m][1+n];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				storage[i][j]=-1;
			}
		}
		return lcsM(a,b,storage);
	}

	private static int lcsM(String a, String b, int[][] storage) {
		
		int m=a.length();
		int n=b.length();
		
		if(m==0||n==0) {
			storage[m][n]=0;
			return 0;
		}
		if(storage[m][n]!=-1) {
			return storage[m][n];
		}
			
		if(a.charAt(0)==b.charAt(0)) {
			storage[m][n]=1+lcsM(a.substring(1),b.substring(1),storage);
		}else {
			int op1=lcsM(a,b.substring(1),storage);
			int op2=lcsM(a.substring(1),b,storage);
			storage[m][n]=Math.max(op1,op2);
		}
		return storage[m][n];
	}
	
	private static int lcsDP(String a,String b) {
		int m=a.length();
		int n=b.length();
		int [][] storage=new int[1+m][1+n];
		for(int i=0;i<=m;i++) {
			storage[i][0]=0;
		}
		for(int i=0;i<=n;i++) {
			storage[0][i]=0;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(a.charAt(m-i)==b.charAt(n-j)) { 
//					checking last characcter while in memo we check first therefore i-1 can be replaced by m-i and j-1 bny n-j
					storage[i][j]=1+storage[i-1][j-1];
				}else {
					storage[i][j]=Math.max(storage[i-1][j], storage[i][j-1]);
				}
			}
		}
		return storage[m][n];
	}

	public static void main(String[] args) {
		String a="abcdeegidghs";
		String b="abdggheiehsj";
		System.out.println(lcs(a,b));
		System.out.println(lcsDP(a,b));
	}

}
