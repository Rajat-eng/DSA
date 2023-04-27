import java.util.Scanner;
public class NextGreaterNumber {
	
	private static void swap(char[] charList, int index1 , int index2) {

		char temp = charList[index1];
		charList[index1] = charList[index2];
		charList[index2] = temp;

	}
	
	public static long findSuccessor(long n) {
		String str=String.valueOf(n);
		char[] charList=str.toCharArray();
		int indexOfFirstSmallerDigit=-1;
		int indexTobeSwapped = -1;
		for(int i=str.length()-2;i>=0;i--) {
			if(str.charAt(i)<str.charAt(i+1)) {
				indexOfFirstSmallerDigit = i;
				break;
			}
		}
		
		if(indexOfFirstSmallerDigit==-1)
			return -1;
		
		for(int j=str.length()-1;j>indexOfFirstSmallerDigit;j--) {
			if(str.charAt(j)>str.charAt(indexOfFirstSmallerDigit)) {
				indexTobeSwapped=j;
				break;
			}			
		}
		swap(charList,indexOfFirstSmallerDigit,indexTobeSwapped);
		int i=indexOfFirstSmallerDigit+1;
		int j=str.length()-1;
		while(i<j) {
			swap(charList,i,j);
			i++;
			j--;
		}
		long ans=0;
		for(int k=0;k<str.length();k++) {
			ans=ans*10;
			ans+=(charList[k]-'0');
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n= sc.nextLong();
		System.out.println(findSuccessor(n));
		sc.close();
	}

}
