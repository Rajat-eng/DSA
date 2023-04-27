package BT;
import java.util.*;

class mpair{
	BinaryTreeNode<Integer> root;
	int horizontallevel;
	
	mpair(BinaryTreeNode<Integer> root, int horizontallevel){
		this.root=root;
		this.horizontallevel=horizontallevel;
	}
}
public class View {
	
	public static ArrayList<Integer> leftview(BinaryTreeNode<Integer> root){
		if(root==null)
			return null;
		ArrayList<Integer> ans=new ArrayList<Integer>();
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int n=q.size();
			ans.add(q.peek().data);
			while(n>0) {
				BinaryTreeNode<Integer> node= q.poll();
				if(node.left!=null) {
					q.add(node.left);
				}
				if(node.right!=null) {
					q.add(node.right);
				}
				n--;
			}
		}
		return ans;
//		for rightview add rightchild first in while loop
	}
	
	public static int shadowlength(BinaryTreeNode<Integer> root) {
		int width[]=new int[2];
//		width[0]--> maxhorizontal in left
//		width[1]--> maxhorizontal in right
		width(root,0,width);
		return width[1]-width[0]+1;
	}
	
	public static void width(BinaryTreeNode<Integer> root, int hl,int[] level) {
		if(root==null)
			return;
		
		width(root.left,hl-1,level);
		width(root.right,hl+1,level);
		
		level[0]=Math.min(level[0], hl);
		level[1]=Math.max(level[1], hl);
	} 
	
	public static ArrayList<ArrayList<Integer>> verticalorder(BinaryTreeNode<Integer> root){
		ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
		if(root==null)
			return ans;
		Queue<mpair> q=new LinkedList<>();
		
		int minmax[]=new int[2];
		width(root,0,minmax);
		int length=minmax[1]-minmax[0] + 1;
		
		
		for(int i=0;i<length;i++) {
			ans.add( new ArrayList<Integer>() );  // adding arraylist at every horizontal position
		}
		q.add( new mpair(root,Math.abs(minmax[0])) );
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				mpair curr=q.poll();
				BinaryTreeNode<Integer> top=curr.root;
				int level=curr.horizontallevel;
				ans.get(level).add(top.data);
				if(top.left!=null) {
					mpair leftapir=new mpair(top.left, level-1);
					q.add(leftapir);
				}
				if(top.right!=null) {
					mpair rightapir=new mpair(top.right, level+1);
					q.add(rightapir);
				}
			}
		}
		
		return ans;
		
	}
	
	public static ArrayList<Integer> bottomview(BinaryTreeNode<Integer> root){
		ArrayList<Integer> ans=new ArrayList<Integer>();
		if(root==null)
			return ans;
		Queue<mpair> q=new LinkedList<>();
		
		int minmax[]=new int[2];
		width(root,0,minmax);
		int length=minmax[1]-minmax[0] + 1;
		
		for(int i=0;i<length;i++) {
			ans.add(0);  // adding arraylist at every horizontal position
		}

		q.add( new mpair(root,Math.abs(minmax[0])) );
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				mpair curr=q.poll();
				BinaryTreeNode<Integer> top=curr.root;
				int level=curr.horizontallevel;
				ans.set(level,top.data);
				if(top.left!=null) {
					mpair leftapir=new mpair(top.left, level-1);
					q.add(leftapir);
				}
				if(top.right!=null) {
					mpair rightapir=new mpair(top.right, level+1);
					q.add(rightapir);
				}
			}
		}
		
		return ans;
		
	}
	
	public static ArrayList<Integer> topview(BinaryTreeNode<Integer> root){
		ArrayList<Integer> ans=new ArrayList<Integer>();
		if(root==null)
			return ans;
		Queue<mpair> q=new LinkedList<>();
		
		int minmax[]=new int[2];
		width(root,0,minmax);
		int length=minmax[1]-minmax[0] + 1;
		
		for(int i=0;i<length;i++) {
			ans.add(null);  // adding arraylist at every horizontal position
		}

		q.add( new mpair(root,Math.abs(minmax[0])) );
		while(!q.isEmpty()) {
			int size=q.size();
			while(size-->0) {
				mpair curr=q.poll();
				BinaryTreeNode<Integer> top=curr.root;
				int level=curr.horizontallevel;
				if(ans.get(level)==null) {
					ans.set(level, top.data);
				}
				if(top.left!=null) {
					mpair leftapir=new mpair(top.left, level-1);
					q.add(leftapir);
				}
				if(top.right!=null) {
					mpair rightapir=new mpair(top.right, level+1);
					q.add(rightapir);
				}
			}
		}
		
		return ans;
		
	}
	

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
//		BTUse.print(root);
		ArrayList<Integer> ans=leftview(root);
		for(int i=0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}

	}
}
