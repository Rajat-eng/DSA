package HashMap;
import java.util.*;
public class ArrPairsDivByK {

	public static boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();
        if(arr.length%2==1){
            return false;
        }
        for(int val:arr){
            int rem=val%k;
            if(rem<0){
                rem=rem+k;
            }
            if(map.containsKey(rem)){
                map.put(rem,map.get(rem)+1);
            }else{
                map.put(rem,1);
            }
        }
        
        for(int val:arr){
            int rem=val%k;
            if(rem<0){
                rem=rem+k;
            }
            if(rem==0){
                int freq=map.get(rem);
                if(freq%2==1){
                    return false;
                }
            }else if(2*rem==k){ // if k is 11 the rem cannot be 5 alone.we have to find (5+6) not (5+5) ==>>  rem==k%2 holds good for even k
                int freq=map.get(rem);
                if(freq%2==1){
                    return false;
                }
            }else{
                int freq=map.get(rem);
                int ofreq=map.getOrDefault(k-rem,0);
                if(freq!=ofreq){
                    return false;
                }
            }
        }
        return true;
    }
	public static void main(String[] args) {
		int arr[] = { 92, 75, 65, 48, 45, 35 };
		System.out.println(canArrange(arr,10));
	}
	

}
