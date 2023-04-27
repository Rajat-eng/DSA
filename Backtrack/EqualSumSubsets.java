package BACKTRACK;
import java.util.*;
public class EqualSumSubsets {
	
	private static void solution(int[] arr, int index, int n, int k, int[] subsetSum, int ssf, ArrayList<ArrayList<Integer>> ans) {
//		0[2^n]
		if(index==arr.length) {
			if(ssf==k) {
				boolean flag=true;
				for(int i=0;i<subsetSum.length-1;i++) {
					if(subsetSum[i]!=subsetSum[i+1]) {
						flag=false;
						break;
					}
				}
				if(flag) {
					for(ArrayList<Integer> partition:ans) {
						System.out.println(partition);
					}
				}
			}
			return;
		}
		
		for(int i=0;i<ans.size();i++) {
			if(ans.get(i).size()>0) {
				ans.get(i).add(arr[index]);
				subsetSum[i]+=arr[index]; // sum of subset in which element is added
				solution(arr,index+1,n,k,subsetSum,ssf,ans);
				subsetSum[i]-=arr[index];
				ans.get(i).remove(ans.get(i).size()-1);
			}else {
				ans.get(i).add(arr[index]);
				subsetSum[i]+=arr[index]; // sum of subset in which element is added
				solution(arr,index+1,n,k,subsetSum,ssf+1,ans);
				subsetSum[i]-=arr[index];
				ans.get(i).remove(ans.get(i).size()-1);
				break;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []arr=new int[n];
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt(); // 1 2 3 -- n
			sum+=arr[i];
		}
		int k=sc.nextInt();
		
		if(k>n || sum%k!=0) {
			System.out.println("not possible to have Equal Sum subsets");
			return;
		}
		if(k==1) {
			System.out.println("only one set possible");
			return;
		}
		int[] subsetSum=new int[k];
		ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<k;i++) {
			ans.add(new ArrayList<Integer>());
		}
//      Let n=6 k=3
		solution(arr,0,n,k,subsetSum,0,ans);
	}

	

}
