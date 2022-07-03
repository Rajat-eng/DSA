package BST;

import BT.BTUse;
import BT.BinaryTreeNode;

public class searchBST {
	
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if(root==null )
			return false;
		
		if(root.data==k)
			return true;
		
		else if(root.data>k)
			return searchInBST(root.left, k);
		
		else 
			return searchInBST(root.right, k);
		
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root= BTUse.takeinput();

	}

}
