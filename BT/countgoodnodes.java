package BT;
//  All nodes which are greator then max in its path
public class countgoodnodes {

	public static int count(BinaryTreeNode<Integer> root,int max) {
		if(root==null)
			return 0;
		int ans=0;
		if(root.data>=max) {
			ans=1;
		}
		max=Math.max(root.data,max);
		int left=count(root.left,max);
		int right=count(root.right,max);
		ans=ans+left+right;
		return ans;
	}
	public static void main(String[] args) {
//		3 1 4 6 -1 1 5 -1 -1 -1 -1 -1 -1 
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		System.out.println(count(root,Integer.MIN_VALUE));
	}

}
