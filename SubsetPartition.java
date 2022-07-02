package DP;

public class SubsetPartition {
	
	public static int equalSubsetPartition(int[] arr) {
		int leftsum=0,rightsum=0;
		int n=arr.length;
		for(int i=0;i<n;i++) {
			leftsum+=arr[i];
		}
		int splitindex=-1;
		for(int i=n-1;i>=0;i--) {
			rightsum+=arr[i];
			leftsum-=arr[i];
			if(leftsum==rightsum) {
				splitindex=i;
				break;
			}
		}
		return splitindex;
	}
	
	
	public static void print(int[] arr) {
		int splitindex=equalSubsetPartition(arr);
		if(splitindex==-1) {
			System.out.println("not possible");
			return;
		}
		
		for(int i=0;i<splitindex;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for(int i=splitindex;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	

	public static void main(String[] args) {
		int [] arr= {1,2,3,6};
		print(arr);
	}
}
