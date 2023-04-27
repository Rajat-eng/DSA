
public class MaxPathSuminTwoArray {
	
	
	private static int solve(int[] arr1, int[] arr2) {
		int result=0;
		int i=0,j=0,sum1=0,sum2=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				sum1+=arr1[i];
				i++;
			}else if(arr1[i]>arr2[j]) {
				sum2+=arr2[j];
				j++;
			}else {
				result+=Math.max(sum1, sum2) + arr1[i];
				sum1=0;  
				sum2=0;
				i++;
				j++;
			}
		}
		
		while(i<arr1.length) {
			result+= arr1[i];
			i++;
		}
		while(j<arr2.length) {
			result+= arr2[j];
			j++;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int arr1[]= {2, 3, 7, 10, 12, 15, 30, 34};
		int arr2[]= {1, 5, 7, 8, 10, 15, 16, 19};	
		int ans=solve(arr1,arr2);
		System.out.println(ans);

	}

	

}
