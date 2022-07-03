package BST;

import BT.BTUse;
import BT.BinaryTreeNode;

class pair {
	int min;
    int max;
    boolean isBST;
  }


public class checkBST {
	
	public static pair get(BinaryTreeNode<Integer> root){
		if(root==null) {
			pair output=new pair();
			output.isBST=true;
			output.min=Integer.MAX_VALUE;  //for min
			output.max=Integer.MIN_VALUE; //for max
			return output;
		}
		
		 pair lans=get(root.left);
		 pair rans=get(root.right);
		 int min=Math.min(root.data, Math.min(lans.min, rans.min));
		 int max=Math.max(root.data, Math.max(lans.max, rans.max));
		 boolean ans= (root.data>lans.max && root.data<rans.min && lans.isBST && rans.isBST);  // isBST
		 
		 pair output=new pair();
			output.isBST=ans;
			output.min=min;  
			output.max=max; 
			return output;
		
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);

	}

}
