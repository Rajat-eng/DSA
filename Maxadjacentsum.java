package DP;

public class Maxadjacentsum {

	public static int max(int[] arr) {
		int include=arr[0];
		int exclude=0;
		for(int i=1;i<arr.length;i++) {
			int newinclude=exclude+arr[i];
			int newexclude=Math.max(exclude, include);
			include=newinclude;
			exclude=newexclude;
		}
		int ans=Math.max(include, exclude);
		return ans;
	}
	public static void main(String[] args) {
		int arr[]= {5,10,10,100,6};
		System.out.println(max(arr));
	}

}
