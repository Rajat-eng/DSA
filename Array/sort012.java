import java.util.Scanner;
public class sort012 {
	public static void swap(int []arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	 public static void sort012(int[] arr){
			int n=arr.length;  
		    int i=0;
	    	int t1=0;
	    	int t2=n-1;
	    
	        while(i<=t2){ 
	            if(arr[i]==0){  
	        	swap(arr,t1,i);
	        	i++;
	        	t1++;
	            }else if(arr[i]==2){    
	    		swap(arr,i,t2);
	            t2--;                	
	    	   }else {    // skip for 1
	    		   i++;
	    	   }
	    }
	 }
		public static void printarray(int[]arr) {
			  for(int i=0;i<arr.length;i++){
		        	System.out.print(arr[i] + " ");
		        }
		}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
	  for(int i=0;i<n;i++){
		  arr[i]=sc.nextInt();
	     }	
       sort012(arr);
       printarray(arr);
	}

}
