import java.util.*;
public class tripletsum {
	
	public static void tripletSum(int[] arr, int num) {
	     	int n=arr.length;
	        Arrays.sort(arr);
	        List<List<Integer>> list=new ArrayList<List<Integer>>();
	        HashMap<Integer,Boolean> map=new HashMap<>();
	        for(int i:arr) {
	        	map.put(i, false);
	        }
	        for(int i=0;i<n;i++){
	        	if(map.get(arr[i])) {
	        		continue;
	        	}
	        	map.put(arr[i], true);
	            int targetleft=num-arr[i];
	            pairSum(arr,i+1,n-1,arr[i],targetleft,list);
	        }
	        System.out.println(list);
	}
	    
	    
	public static void pairSum(int[] arr,int start,int end,int curr, int num, List<List<Integer>> list) {
	  
	         while (start< end){
	        	 
	             if(arr[start] + arr[end]> num){
	            	 end--;
	             }
	             else if (arr[start] + arr[end] < num) {
	            	 start++;
	             }
                   
	             else {
	            	List<Integer> ans=new ArrayList<Integer>();
            	 	if(arr[start]==arr[end]) {
	            		ans.add(curr);
	            		ans.add(arr[start]);
	            		ans.add(arr[end]);
	            		list.add(ans);
	            		return;
	            	}
	            	int elementatstart=arr[start];
		        	int elementatend=arr[end];
	            	int tsi=1+start;
	            	int tei=end-1;
	            	while( tsi<=tei && arr[tsi]==elementatstart) {
	            		tsi++;
	            	}
	            	while( tei>=tsi && arr[tei]==elementatend) {
	            		tei--;
	            	}
	            	ans.add(curr);
            		ans.add(arr[start]);
            		ans.add(arr[end]);
            		list.add(ans);
	            	start=tsi;
	            	end=tei;
	             }         
	        }
		}

  
	public static void main(String[] args){	
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
	    for(int i=0;i<n;i++){
		  arr[i]=sc.nextInt();
	     }
	    int x=sc.nextInt();
		tripletSum(arr, x);
		 
	}
}
