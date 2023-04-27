import java.util.*;
public class sort0and1 {
	
	public static void sort0and1(int[] arr) {
	  int left=0;
	  int right=arr.length-1;
	  int temp=0;
	  while(left<right) {
		  while(arr[left]==0  && left<right )
			  left++;
		  while(arr[right]==1 && left<right)
			  right--;
		  if(arr[left]==1 && arr[right]==0){
			temp=arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
		    left++;
		    right--;
		  }
	  }
     
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
	  for(int i=0;i<n;i++){
		  arr[i]=sc.nextInt();
	     }  
      sort0and1(arr);
      for(int i=0;i<n;i++){
		  System.out.print(arr[i] +" ");
	     }
	}
}
