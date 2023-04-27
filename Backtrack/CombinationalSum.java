package BACKTRACK;
import java.util.*;
public class CombinationalSum {
	
	public static ArrayList<ArrayList<Integer>> combSum1(int[] arr, int b) {
		 
		   ArrayList<ArrayList<Integer>> list = new ArrayList<>(); 
	       ArrayList<Integer> current = new ArrayList<>();
	       Arrays.sort(arr);
	 
	       solveDuplicates(0,arr,b,list,current);
	       
	       return list;
	}
	   
	private static void solveDuplicates(int start,int[] arr,int target, ArrayList<ArrayList<Integer>> list,ArrayList<Integer> current){
		// each elemnt can bu used more than once
	       if(target == 0){
	           list.add(new ArrayList<>(current));
	           return;
	       }
	       if(target < 0){
	           return;
	       }
	       
	       for(int i = start ; i < arr.length ; i++){
	           current.add(arr[i]);
	           solveDuplicates(i,arr,target-arr[i],list,current);
	           current.remove(current.size()-1);
	       }
	}
	
	public static ArrayList<ArrayList<Integer>> combSum2(int[] arr, int b) {
		 
		   ArrayList<ArrayList<Integer>> list = new ArrayList<>(); 
	       ArrayList<Integer> current = new ArrayList<>();
	       Arrays.sort(arr);
	 
	       solveNoDuplicates(0,arr,b,list,current);
	       
	       return list;
	}
	
	private static void solveNoDuplicates(int start,int[]arr,int target,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> current) {
			// each elemnt can be used once
		   if(target == 0){
	           list.add(new ArrayList<>(current));
	           return;
	       }
	       if(target < 0){
	           return;
	       }
		
	       for(int i = start ; i < arr.length ; i++){
	    	   if(i>start && arr[i]==arr[i-1]) {
	    		   continue;
	    	   }
	           current.add(arr[i]);
	           solveDuplicates(i+1,arr,target-arr[i],list,current);
	           current.remove(current.size()-1);
	       }
	}

	public static void main(String[] args) {
		
		int[]arr= {2,3,5,6,10};
		ArrayList<ArrayList<Integer>>ans1=combSum1(arr, 10);
		for(int i=0;i<ans1.size();i++) {
			System.out.println(ans1.get(i));
		}
		System.out.println("");
		ArrayList<ArrayList<Integer>>ans2=combSum2(arr, 10);
		for(int i=0;i<ans2.size();i++) {
			System.out.println(ans2.get(i));
		}
	}

}
