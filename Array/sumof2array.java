
public class sumof2array {
	 public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]) {
	    	int i=arr1.length-1;
	        int j=arr2.length-1;
	        int k=output.length-1;
	        int carry=0,sum=0;
	        int input=0;
	        while(j>=0){
	        sum=arr1[i]+arr2[j]+carry;
	        input=sum%10;
	        carry=sum/10;
	        output[k]=input;
	        i--;
	        j--;
	        k--;
	       }
	        while(i>=0){
	            sum=arr1[i]+carry;
	            input=sum%10;
	        	carry=sum/10;
	            output[k]=input;
	            i--;
	            k--;
	        }
	        output[k]=carry;
	    }

	public static void main(String[] args) {
		int arr1[]= {9,6,9,8};
		int arr2[]= {9,2,8};
		int []output= new int[1 + Math.max(arr1.length,arr2.length)];
		if(arr1.length>=arr2.length) {
			sumOfTwoArrays(arr1,arr2,output);
		}
		else
			sumOfTwoArrays(arr2,arr1,output);
		for(int k=0;k<output.length;k++)
		{System.out.print(output[k]);}
	}

}
