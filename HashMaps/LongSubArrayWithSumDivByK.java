package HashMap;
import java.util.HashMap;
public class LongSubArrayWithSumDivByK {
	
	private static int solve(int[] arr, int k) {
		int sum=0;
		int ans=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		map.put(sum, -1);
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			int rem=0;
			rem=sum%k;
			if(rem<0) {
				rem+=k;
			}
			if(map.containsKey(rem)) {
				int idx=map.get(rem);
				int length=i-idx;
				if(length>ans) {
					ans=length;
				}
			}else {
				map.put(rem, i);
			}
		}
		return ans;
	}
	

	private static int count(int[] arr, int k) {
		int ans=0,sum=0;
		HashMap<Integer,Integer> map=new HashMap<>();
		map.put(sum, 1); 
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			int rem=0;
			rem=sum%k;
			if(rem<0) {
				rem+=k;
			}
			if(map.containsKey(rem)) {
				ans+=map.get(rem);
				map.put(rem, map.get(rem)+1);
			}else {
				map.put(rem,1);
			}
			
		}
		return ans;
	}
	

	public static void main(String[] args) {
		int [] arr= {2,4,8,1,7,3,6,1,9,2,7,3};
		int k=5;
		int ans=solve(arr,k);
		System.out.println(ans);
		int total=count(arr,k);
		System.out.println(total);
	}
}
