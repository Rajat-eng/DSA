
public class merge2sortedarrays {
	public static int[] merge(int []arr1, int []arr2) {
		int i=0,j=0;
        int n=arr1.length;
        int m=arr2.length;
        int k=0;
        int arr[]=new int[n+m];
            while(i<n && j<m){
            if(arr1[i]>arr2[j]){ 
                arr[k]=arr2[j];
                j++; 
                k++;
            }
            else{
                arr[k]=arr1[i];
                i++;
                k++;
            }          
          }
            while(i<n) {
            	arr[k]=arr1[i];
            	k++;
            	i++;
            }
            while(j<m){
            	arr[k]=arr2[j];
            	k++;
            	j++;
            }      
       return arr; 
   }
	public static void main(String[] args) {
		int arr1[]= {1,3,5,7};
		int arr2[]= {2,4,6};
		int[] arr= merge(arr1,arr2);
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]+" ");
		}
   }
}
