package BT;
import java.util.*;
public class addrow {
	
	public static BinaryTreeNode<Integer> addOneRow(BinaryTreeNode<Integer> root, int data, int depth) {
		if(root==null)
			return null;
		
		if(depth==1) {
			BinaryTreeNode<Integer> newnode=new BinaryTreeNode<Integer>(data);
			newnode.left=root;
			return newnode;
		}
		else if(depth==2) {
			BinaryTreeNode<Integer> leftnewnode=new BinaryTreeNode<Integer>(data);
			leftnewnode.left=root.left;
			root.left=leftnewnode;
			BinaryTreeNode<Integer> rightnewnode=new BinaryTreeNode<Integer>(data);
			rightnewnode.right=root.right;
			root.right=rightnewnode;
			return root;
		}
		addOneRow(root.left, data, depth-1);
		addOneRow(root.right, data, depth-1);
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		//1 2 3 4 5 6 7  -1 -1 -1 -1 -1 -1 -1 -1
		BTUse.printlevelwise(root);
		System.out.println();
		BinaryTreeNode<Integer> result=addOneRow(root,11,3);
		BTUse.printlevelwise(result);
	}

}
