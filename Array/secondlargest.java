import java.util.Scanner;

public class secondlargest {
	public static int secondLargestElement(int[] arr) {
		int n=arr.length;
		int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
		for (int i=0;i<arr.length;i++) {
			if(arr[i]>first) {
				second=first;
				first=arr[i];
			}else if(arr[i]>second && arr[i]!=first) {
				second=arr[i];
			}
		}
		if(second==Integer.MIN_VALUE)
			return -1;
		return second;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
	  for(int i=0;i<n;i++){
		  arr[i]=sc.nextInt();
	     }
	  int ans=secondLargestElement(arr);
	  System.out.println(ans);
	}
}
