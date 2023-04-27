import java.util.Scanner;

public class selectionsort {
	public static void selectionsort(int []arr){
		int i=0,j=0;
        int min=Integer.MAX_VALUE,minindex=0;
        for(i=0;i<arr.length;i++){
            min=arr[i];
            minindex=i;
            for(j=i+1;j<arr.length;j++){
                if(arr[j]<min)
                {
                    min=arr[j];
                    minindex=j;
                }
            }
            if(minindex!=i){
            	arr[minindex]=arr[i];   // cant use j bcoz j=i+1
            	arr[i]=min;           	  	              	           			 
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
      selectionsort(arr);
      printarray(arr);
	}
}
