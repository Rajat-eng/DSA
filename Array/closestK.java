import java.util.*;
// k clost elements in array to reference integer
public class closestK {
	
	public static int findmid(int[] arr,int low,int high,int x) {
		if(x<arr[low]) {
			return low;
		}
		if(x>arr[high]) {
			return high;
		}
		int mid=(low+high)/2;
		if(arr[mid]<=x && arr[mid+1]>x) {
			return mid;
		}
		if(x>arr[mid]) {
			return findmid(arr, mid+1, high, x);
		}
		return findmid(arr, low, mid-1, x);
	}
	
	public static ArrayList<Integer> printkclosest(int [] arr,int x,int k) {
		int n=arr.length;
		ArrayList<Integer> list=new ArrayList<Integer>();
		int l=findmid(arr,0,arr.length-1,x);
		int r=l+1;
		if(arr[l]==x)l--;  // 0 diff is not allowed
		
		while(l>=0 && r<arr.length && k-->0) {
			if( Math.abs(arr[l]-x)<Math.abs(arr[r]-x) ) {
//				if diff is equal choose the one which has lower value
				list.add(arr[l]);
				l--;
			}else {
				list.add(arr[r]);
				r++;
			}
		}
		
		while(l>=0 && k-->0) {  // right>arr.length
			list.add(arr[l]);
			l--;
		}
		
		while(r<n && k-->0) { // left is -ve
			list.add(arr[r]);
			r++;
		}
		
		return list;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr= {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		ArrayList<Integer> ans=printkclosest(arr, 35, 4);
		Collections.sort(ans);
		for(int i:ans) {
			System.out.print(i +" ");
		}
		sc.close();
	}

}
