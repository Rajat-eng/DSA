package BST;

import BT.BTUse;
import BT.BinaryTreeNode;

class pair {
	long min;
    long max;
    boolean isBST;
  }


public class checkBST {
	
	public static pair get(BinaryTreeNode<Integer> root){
		if(root==null) {
			pair output=new pair();
			output.isBST=true;
			output.min=Long.MAX_VALUE;  //for min
			output.max=Long.MIN_VALUE; //for max
			return output;
		}
		
		 pair lans=get(root.left);
		 pair rans=get(root.right);
		 long min=Math.min(root.data, Math.min(lans.min, rans.min));
		 long max=Math.max(root.data, Math.max(lans.max, rans.max));
		 boolean ans= (root.data>lans.max && root.data<rans.min && lans.isBST && rans.isBST);  // isBST
		 
		 pair output=new pair();
			output.isBST=ans;
			output.min=min;  
			output.max=max; 
			return output;
		
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput(); // 2147483647
		BTUse.print(root);
		System.out.println(get(root).isBST);
	}

}
