import java.util.Scanner;

public class Binarysearch {
	public static int binarysearch(int[] arr, int x) {
		int start=0,mid=0;
        int end=arr.length-1;
         
        while(start<end){
        	
            if(x==arr[mid]){
                return mid;
            }
            else if(x>arr[mid]){
                start=mid+1;
                mid=(start+end)/2;
            }
            else {
            	end=mid-1;
                mid=(start+end)/2;
            }   	
        }
        return -1;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
	  for(int i=0;i<n;i++){
		  arr[i]=sc.nextInt();
	     } 
	  int x=sc.nextInt();
	 System.out.println(binarysearch(arr,x)); 
	 sc.close();
	}
}
