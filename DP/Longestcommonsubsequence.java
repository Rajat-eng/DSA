package DP;

class XYZ{
	String s1;
	String s2;
}
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
		for(int i=m-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				if(a.charAt(i)==b.charAt(j)) { 
//					checking last character while in memo we check first therefore i-1 can be replaced by m-i and j-1 bny n-j
					storage[i][j]=1+storage[i+1][j+1];
				}else {
					storage[i][j]=Math.max(storage[i+1][j], storage[i][j+1]);
				}
			}
		}
		int size=storage[0][0];
		String delchar=print(size, a, b, m, n, storage).s1;
		String lcs=print(size, a, b, m, n, storage).s2; 
		System.out.println("lcs string is:" + " "+ lcs);
		System.out.println("deleted chars are:" + " "+ delchar);
		return size;
	}
	
	private static XYZ print(int size, String a,String b,int m,int n, int[][] storage) {
		
		XYZ A=new XYZ(); 
		int i=0,j=0,index=0;
		char[] str=new char[size];
		String ne=""; 
		while(i<m && index<size) {
			while(j<n && index<size) {
				char ch1=a.charAt(i);
				char ch2=b.charAt(j);
				if(ch1==ch2) {
					str[index]=ch1;
					index++;
					i++;
					j++;
				}else{
					if(storage[i+1][j]>storage[i][j+1]) {
						ne+=a.charAt(i);
						i++;
					}else {	
						j++;
						
					}
				}
			}
		}
		
		StringBuilder s= new StringBuilder();
		for(int k=0;k<str.length;k++) {
			s.append(str[k]);
		}
		String lcs=s.toString();
		A.s1=ne; // non incorporated characters
		A.s2=lcs; // lcs string
		return A;
	}

	public static void main(String[] args) {
		String a="bbabcbcab";
		String b="bacbcbabb";
		
//		System.out.println(lcs(a,b));
		int size=lcsDP(a,b);
		System.out.println(size);
		
	}

}
