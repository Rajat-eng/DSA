package BST;
import java.util.LinkedList;
import java.util.Queue;

import BT.BinaryTreeNode;

public class BinarySearchTree {
	
	private BinaryTreeNode<Integer> root;
	
	private boolean hasDatahelper(int data,BinaryTreeNode<Integer> root) {
		if(root==null)
			return false;
		if(root.data==data)
			return true;
		else if(root.data<data)
			return hasDatahelper(data,root.right);
		else
			return hasDatahelper(data, root.left);
	}
	
	private BinaryTreeNode<Integer> insertDatahelper(int data,BinaryTreeNode<Integer> root) {
		
		if(root==null) {
			BinaryTreeNode<Integer> newnode=new BinaryTreeNode<Integer>(data);
			return newnode;
		}
		
		if(root.data>=data)
			root.left=insertDatahelper(data,root.left);
		
		else 
			root.right=insertDatahelper(data,root.right);
		
		return root;
	}
	
	private BinaryTreeNode<Integer> deleteDatahelper(int data, BinaryTreeNode<Integer> root) {
		if(root==null)
			return null;
		
		if(root.data>data) {
			root.left=deleteDatahelper(data, root.left);
		}else if(root.data<data) {
			root.right=deleteDatahelper(data, root.right);
		}else {
			if(root.right!=null && root.left!=null) {
				// return min from its right subtree and replace node with it
				// delete min from its right subtree
				int rmin=min(root.right);
				root.data=rmin;
				root.right=deleteDatahelper(rmin, root.right);
			}else if(root.left!=null) {  // has only left child then child becomes new node 
				return root.left;
			}else if(root.right!=null) {
				return root.right;
			}else {
				return null;
			}
		}
		
		return root;
	}
	
	private int min(BinaryTreeNode<Integer> root) {
//		find min in right
		if(root.left!=null) {
			return min(root.left);
		}	
		else {
			return root.data;
		}	
	}
	
	public boolean search(int data) {
		return hasDatahelper(data,root);
	}
	
	public void delete(int data) {
		root=deleteDatahelper(data, root); // if root is null assigning root the newnode otherwise no effect
	}
	
	public void insert(int data) {
		root=insertDatahelper(data,root);  
	}

	public void printTree(BinaryTreeNode<Integer> root) {
		
		if(root==null)
			return;
		Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);

		while(!q.isEmpty()) {
				BinaryTreeNode<Integer> front=q.poll();
				System.out.print(front.data + ":");
				if(front.left!=null) {
					System.out.print( "L:" + front.left.data + ",");
					q.add(front.left);
				}
				if(front.left==null) {
					System.out.print( "L:" + "-1" + ",");
				}
				if(front.right!=null) {
					System.out.print( "R:" + front.right.data);
					q.add(front.right);
				}
				if(front.right==null) {
					System.out.print( "R:" + "-1");
				}
			System.out.println();
		}
	}
	
}
