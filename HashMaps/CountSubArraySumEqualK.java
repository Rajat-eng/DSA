package HashMap;
import java.util.HashMap;
public class CountSubArraySumEqualK {
	
	private static int solve(int[] arr,int n, int k) {
		int count=0;int sum=0;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(sum, 1); // 0 sum i found 1 time
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			map.put(sum, map.getOrDefault(sum, 0)+1);
			int remsum=sum-k;
			if(map.containsKey(remsum)) {
				count+=map.get(remsum);
			}
		}
		return count;
	}

	public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int sum=0;
        map.put(sum,-1);
        int maxLength=Integer.MIN_VALUE;
        int si=-1;
        for(int i=0;i<N;i++){
            
            sum+=A[i];
            if(!map.containsKey(sum))
            map.put(sum,i);
         
            int remsum=sum-K;
            if(map.containsKey(remsum)){
                int index=map.get(remsum);
                int plen=i-index;
                if(plen>maxLength) {
                	maxLength=plen;
                	si=1+index;
                }
            }
        }
        for(int i=si;i<=maxLength;i++){
        	System.out.print(A[i] + " ");
        }
        return maxLength;
    }
	public static void main(String[] args) {
		int[]arr= {3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1}; // k=5
		int arr1[]= {1,11, -6, 3, -2, 14, 0, 5, -16, -11, -16, -2, 14, -8 ,5, -12};
		int k=20;
		int ans=lenOfLongSubarr(arr1,arr1.length,k);
		System.out.println("maxLength is:"+ " " + ans);
	}

}
