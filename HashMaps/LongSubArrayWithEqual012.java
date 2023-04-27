package HashMap;
import java.util.HashMap;
public class LongSubArrayWithEqual012 {
	
private static String getkey(int delta10, int delta21) {
		
		return delta10 + "#" + delta21;
	}

	private static int solve(int[] arr) {
		int ans=0;
		int count0=0,count1=0,count2=0;
		int delta10=count1-count0;
		int delta21=count2-count1;
		String key=getkey(delta10,delta21);
		HashMap<String,Integer> map=new HashMap<String, Integer>();
		map.put(key, -1);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				count0++;	
			}else if(arr[i]==1) {
				count1++;
			}else {
				count2++;
			}
			delta10=count1-count0;
			delta21=count2-count1;
			key=getkey(delta10,delta21);
			if(map.containsKey(key)) {
				int length=i-map.get(key);
				if(length>ans) {
					ans=length;
				}
			}else {
				map.put(key, i);
			}
		}
		return ans;
	}

	
	

	public static void main(String[] args) {
		int[] arr= {1,1,2,0,1,0,1,2,1,2,2,0,1};
		int ans=solve(arr);
		System.out.println(ans);
	}
}
