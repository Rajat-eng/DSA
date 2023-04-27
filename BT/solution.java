package BT;
import java.util.*;
public class solution {
	
	 	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
	 		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	         ArrayList<Integer> curr=new ArrayList<Integer>();
	         getAll(root,k,0,list,curr);
	         
	         int size = list.size();
	         System.out.println(list);
//	         for(int i=0;i<size;i++){
//	        	 
////	             for(int j=0;j<list.get(i).size();j++){
////	                 System.out.print(list.get(i).get(j)+" ");
////	             }
//	 			System.out.println();
//	         }
	 	}
	     
	    public static void getAll(BinaryTreeNode<Integer> root,int k,int sum,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> path){
	    	
	    	if(root==null) {
	    		return;
	    	}
	        if(root.left==null && root.right==null) {
	        	sum+=root.data;
		     	path.add(root.data);
	     		if(k==sum){
	                 list.add(new ArrayList<Integer>(path));   
	                 return;
	            }	
	     		return;
	     	}
	     	sum+=root.data;
	     	path.add(root.data);
	     	getAll(root.left, k, sum,list,path);
	     	
	     	getAll(root.right, k, sum,list, path);
	     	
	     	path.remove(path.size()-1);
	     	sum-=root.data;   	
	     	
	     }
	 

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		int k=6;
		rootToLeafPathsSumToK(root, k);
	}

}
