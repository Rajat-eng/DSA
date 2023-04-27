package BT;
import java.util.*;
public class evenoddtree {
//	all even levels have odd values which are strictly increasing
//	all odd levels have even values which are strictly decreasing
	public static  boolean isevenoddtree(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		boolean even=true;
		while(!q.isEmpty()) {
			int size=q.size();
			int preval=even? Integer.MIN_VALUE:Integer.MAX_VALUE;
			while(size>0) {
				System.out.println(size);
				BinaryTreeNode<Integer> front=q.poll();
				if(even && (front.data%2==0 || front.data<=preval)) return false;
				if(!even && (front.data%2==1 || front.data>=preval)) return false;
				preval=front.data;
				if(front.left!=null)
					q.add(front.left);
				if(front.right!=null)
					q.add(front.right);
				
				size--;
			}
			even=!even;
		}
		return true;
	}

	public static void main(String[] args) {
//		1 10 4 3 -1 7 9 12 8 6 -1 -1 2 -1 -1 -1 -1 -1 -1 -1 -1 
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		System.out.println(isevenoddtree(root));
	}

}
