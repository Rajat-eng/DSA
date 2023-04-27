import java.util.Scanner;
public class pushZerosAtEnd {
	 public static int[] pushZerosAtEnd(int[] arr) {
	    	int i=0,k=0;
	        int n=arr.length;
	        int []temp= new int[n];
	        for(i=0;i<n;i++){	        	
	        if(arr[i]!=0) {
	        	temp[k]=arr[i];
	        	k++;
	        }
	        else
	        	continue;
	        }
	       return temp;
	    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
	  for(int i=0;i<n;i++){
		  arr[i]=sc.nextInt();
	     }
	  int ans[]=pushZerosAtEnd(arr);
	  for(int i=0;i<n;i++) {
		  System.out.print(ans[i] + " ");
	  }
	}

}
