import java.util.*;
public class rotateleft {
    public static void rotate(int []arr,int d) {
    	int temp[]=new int[d];
    	int i=0;
    	for(i=0;i<d;i++) {
    		temp[i]=arr[i];
    	}
    	for(i=0;i<arr.length-d;i++) {
    		arr[i]=arr[i+d];
    	}
       for(i=0;i<d;i++)
    	{
    		arr[arr.length-d+i]=temp[i];
    	}
    }
    public static void printarray(int []arr)
    {
    	for(int i=0;i<arr.length;i++) {
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
	  int d=sc.nextInt();
	  rotate(arr,d);
	  printarray(arr);
	}
}
