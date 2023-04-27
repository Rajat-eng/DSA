package BT;
import java.util.*;
public class Diagnolorder {
	
	public static ArrayList<ArrayList<BinaryTreeNode<Integer>>> diagnolorder(BinaryTreeNode<Integer> root){
		ArrayList<ArrayList<BinaryTreeNode<Integer>>> ans=new ArrayList<ArrayList<BinaryTreeNode<Integer>>>();
		Queue<BinaryTreeNode<Integer>> q= new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		while(!q.isEmpty()) {
			int size=q.size();
			ArrayList<BinaryTreeNode<Integer>> smallans=new ArrayList<>();
			while(size-->0) {
				BinaryTreeNode<Integer> front=q.poll();
				while(front!=null) {
					smallans.add(front);
					if(front.left!=null) {
						q.add(front.left);
					}
					front=front.right;
				}
			}
			ans.add(smallans);
		}
		return ans;
		
	}
	
	public static ArrayList<Integer> sumofdiagnol(BinaryTreeNode<Integer> root){
		ArrayList<ArrayList<BinaryTreeNode<Integer>>> diagnol=diagnolorder(root);
		ArrayList<Integer> ans=new ArrayList<Integer>();
		for(int i=0;i<diagnol.size();i++) {
			int sum=0;
			ArrayList<BinaryTreeNode<Integer>> smallans=diagnol.get(i);
			for(int j=0;j<smallans.size();j++) {
				sum+=smallans.get(j).data;
			}
			ans.add(sum);
		}
		return ans;
	}
	
	public static void sumofdiagnolrecursive(BinaryTreeNode<Integer> root,int diagnolidx,ArrayList<Long> ans){
		if(root==null)
			return;
		
		if(diagnolidx==ans.size())
			ans.add(0L);
		
		ans.set(diagnolidx, ans.get(diagnolidx)+ root.data);
		
		sumofdiagnolrecursive(root.left, 1+diagnolidx, ans);  // add +1 to add in diagnolidx
		sumofdiagnolrecursive(root.right, diagnolidx, ans);		// add nothing to diagnolidx
		
	}

	public static void main(String[] args) {
//		10 30 20 60 50 70 90 8 9 -1 -1 -1 -1 6 100 -1 1 -1 7 5 2 -1 -1 -1 4 -1 -1 -1 -1 -1 -1 -1 -1
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.printlevelwise(root);
		ArrayList<ArrayList<BinaryTreeNode<Integer>>> ans=diagnolorder(root);
		for(int i=0;i<ans.size();i++) {
			ArrayList<BinaryTreeNode<Integer>> smallans=ans.get(i);
			for(int j=0;j<smallans.size();j++) {
				System.out.print(smallans.get(j).data + " ");
			}
			System.out.println();
		}
		
		ArrayList<Long> result=new ArrayList<Long>();
		sumofdiagnolrecursive(root, 0, result);
		for(int i=0;i<result.size();i++) {
			System.out.print(result.get(i) + " ");
		}
	}

}
