package BT;
import java.util.*;

public class BTUse {
	
	public static BinaryTreeNode<Integer> takeinputrecursively(Scanner s) {
		// enter root data
		int rootdata;
		rootdata=s.nextInt();
		if(rootdata==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootdata);
		root.left=takeinputrecursively(s);
		root.right=takeinputrecursively(s);
		return root;
	}
	
	public static BinaryTreeNode<Integer> takeinput(){
		// enter root data
		Scanner s=new Scanner(System.in);
		int rootdata;
		rootdata=s.nextInt();
		if(rootdata==-1) {
			s.close();
			return null;
		}	
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootdata);
		Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		while(!q.isEmpty()) {
			// left child
			BinaryTreeNode<Integer> front=q.poll();
			int left=s.nextInt();
			if(left!=-1) {
				BinaryTreeNode<Integer> leftchild=new BinaryTreeNode<Integer>(left);
				q.add(leftchild);
				front.left=leftchild;
			}
			// right child
			int right=s.nextInt();
			if(right!=-1) {
				BinaryTreeNode<Integer> rightchild=new BinaryTreeNode<Integer>(right);
				q.add(rightchild);
				front.right=rightchild;
			}
		}
		return root;
	}
	
	public static void printlevelwise(BinaryTreeNode<Integer> root) {
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
	
	public static void print(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		String print= root.data + ":";
		if(root.left!=null) {
			print+= "L" + root.left.data + ",";
		}
		if(root.right!=null) {
			print+= "R" + root.right.data;
		}
		System.out.println(print);	
		print(root.left);
		print(root.right);
	}
	

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=takeinput();
		printlevelwise(root);	
	}

}
