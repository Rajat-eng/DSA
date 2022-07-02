package DP;
//Given a string, count number of subsequences of the form a^i b^j c^k, i.e., 
//it consists of i ’a’ characters, followed by j ’b’ characters, followed by k ’c’ characters where i >= 1, j >=1 and k >= 1
public class countsubsequencesABC {
	
	public static int count(String s) {
		
		int aCount=0,bCount=0,cCount=0;
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch=='a') {
				aCount=2*aCount+1;
			}else if(ch=='b') {
				bCount=2*bCount+aCount;
			}else {
				cCount=2*cCount+bCount;
			}
		}
		return cCount;
	}

	public static void main(String[] args) {
		String s="abcabc";
//		Subsequences are abc, abc, abbc, aabc,abcc, abc and abc
		System.out.println(count(s));
	}

}
