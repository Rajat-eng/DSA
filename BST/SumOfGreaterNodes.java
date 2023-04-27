package BST;

import BT.BTUse;
import BT.BinaryTreeNode;

public class SumOfGreaterNodes {

	  public static int largersum(BinaryTreeNode<Integer> root,int sum){
	    	if(root==null)
	    		return sum;
	    	sum=largersum(root.right,sum);
	    	sum+=root.data;
	    	root.data=sum;
	    	sum=largersum(root.left,sum);
	    	
	    	return sum;
	  }
	  
	  public static BinaryTreeNode<Integer> convertBstToGreaterSum(BinaryTreeNode<Integer> root){
			largersum(root,0);
			return root;
	  }
	public static void main(String[] args) {
//		4 3 7 1 2 5 8 -1 -1 -1 -1 -1 -1 -1 -1 
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		BinaryTreeNode<Integer> ans=convertBstToGreaterSum(root);
		BTUse.print(ans);
	}

}
