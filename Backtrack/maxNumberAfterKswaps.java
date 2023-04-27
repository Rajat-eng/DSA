package BACKTRACK;

 import java.util.Scanner;
public class maxNumberAfterKswaps {
	
	private static String findMax(String m, int k) {
		char[] max = m.toCharArray();
		char[] numArray = m.toCharArray();
		findMaxHelper(numArray, k, max, 0); 
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < max.length ; i++){
			result.append(max[i]);
		}
		return result.toString();
	}
      
	private static void findMaxHelper(char[] m, int k, char[] max, int curridx) {
		if(k==0) {
			return;
		}
		int len=m.length;
		if(curridx>len-1) {
			return;
		}
		char strmax=m[curridx];
		for(int i=curridx+1;i<len;i++) {
			if(m[i]>strmax) {
				strmax=m[i];
			}
		}
		if(m[curridx]!=strmax) { // if maxchar is not at sme position then it needs to be swapped
			--k; 
		}
		
		for(int i=curridx;i<len;i++) {
			if(m[i]==strmax) { // when reach ar maxchar in m
				char temp=m[i];
				m[i]=m[curridx];
				m[curridx]=temp;
				if(isGreater(m,max)) {
					for(int j=0;j<m.length;j++) {
						max[j]=m[j];
					}
				}
				findMaxHelper(m, k, max, curridx+1); // k is already decreased
				temp=m[i];
				m[i]=m[curridx];
				m[curridx]=temp;
			}
		}
	}
	

	private static boolean isGreater(char[] m, char[] max) {
		for(int i=0;i<m.length;i++) {
			if(m[i]>max[i])
				return true;
			else if(m[i]<max[i])
				return false;
		}
		return true; // both are equal
	}

	public static void main(String[] args) {
//		O[(n)^swaps]
		Scanner sc=new Scanner(System.in);
		String m=sc.next();
		int k=sc.nextInt();
		String ans=findMax(m,k);
		System.out.println(ans);
		sc.close();
	}
	



	
}
