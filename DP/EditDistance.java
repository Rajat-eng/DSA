package DP;
// Given two strings word1 and word2 , return the minimum number of operations required to convert word1 to word2 .
public class EditDistance {
	
	public static int editDistance(String s1,String s2) {
		int m=s1.length();
		int n=s2.length();
		int [][]storage=new int[1+m][1+n];
		for(int i=0;i<storage.length;i++) {
			for(int j=0;j<storage[0].length;j++) {
				storage[i][j]=-1;
			}
		}
		return editDistanceM(s1, s2, storage);
	}
	
	public static int editDistanceM(String s1,String s2,int [][] storage) {
		int m=s1.length();
		int n=s2.length();
		
		if(m==0) {  // to convert s1 to s2 now it requires n operations
			return n;
		}
		if(n==0) {  // to convert s1 to s2 now it requires m operations
			return m;
		}
			
		if(storage[m][n]!=-1) {
			return storage[m][n];
		}
		
		if(s1.charAt(0)==s2.charAt(0)) {
			storage[m][n]= editDistanceM(s1.substring(1),s2.substring(1),storage);
		}else {
			int op1=editDistanceM(s1,s2.substring(1),storage);// insert
			int op2=editDistanceM(s1.substring(1),s2,storage);// delete
			int op3=editDistanceM(s1.substring(1),s2.substring(1),storage);// replace 
			storage[m][n]= 1 + Math.min(op1, Math.min(op2, op3));
		}
		return storage[m][n];
	}
	
	public static int editDistanceDP(String s1,String s2) {
		int m=s1.length();
		int n=s2.length();
		int [][]storage=new int[1+m][1+n];
		for(int i=0;i<=n;i++) {
			storage[i][0]=i;
		}
		for(int j=0;j<=m;j++) {
			storage[0][j]=j;
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=m;j++) {
				if(s1.charAt(m-i)==s2.charAt(n-j)) {
					storage[i][j]=storage[i-1][j-1];
				}else {
					storage[i][j]=1+ Math.min( storage[i][j-1], Math.min(storage[i-1][j-1],storage[i-1][j]) );
				}
			}
		}
		return storage[m][n];
	}

	public static void main(String[] args) {
		String s1="b";
		String s2="abcde";
		System.out.println(editDistance(s1, s2));
	}

}
