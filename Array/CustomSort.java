import java.util.*;

public class CustomSort {
	
	public static class LargestNumberComparator implements Comparator<String>{
		public int compare(String a,String b) {
			String x=a+b;
			String y=b+a;
			return y.compareTo(x); // for largest
		}
	}
	
	
	private static long largestNumber(String[] arr) {
		
	    Arrays.sort(arr,new LargestNumberComparator());
		
		StringBuilder largest= new StringBuilder();
		for(String s:arr) {
			largest.append(s);
		}
		long x=Long.parseLong(largest.toString());
		return x;
	}
	

	public static void main(String[] args) {
		int[]nums= {54,546,548,60};
		String [] arr=new String[nums.length];
		
		for(int i=0;i<nums.length;i++) {
			arr[i]=String.valueOf(nums[i]);
		}
		
		long ans=largestNumber(arr);
		System.out.println(ans);
	
	}



	

	

}
