import java.util.Scanner;

public class insertionsort {
	
	public static void insertionsort(int[] arr) {
    	for(int i=1;i<arr.length;i++){
            int j=i-1;
            int key=arr[i];
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
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
      insertionsort(arr);
      printarray(arr);

	}

}
