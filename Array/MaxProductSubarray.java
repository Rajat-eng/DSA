
public class MaxProductSubarray {
	
	public static int maxProduct(int[] nums) {
        
	       int n=nums.length;
	       if(n==0)
	           return 0;
	        
	        int max=nums[0];
	        int min=nums[0];
	        int ans=nums[0];
	        
	       for(int i=1;i<n;i++){
	          int x=nums[i];
	           
	          if(x<0) {
	        	int temp = max;
	  	        max = min;
	  	        min = temp;  
	          }
	            
	          max=Math.max(x,max*x);
	          min=Math.min(x,min*x);
	          ans=Math.max(ans,max);
	       }
	        
	       return ans;
	 }
	    
	

	public static void main(String[] args) {
		int nums[]= {-2,3,-4};
		int ans=maxProduct(nums);
		System.out.println(ans);

	}

}
