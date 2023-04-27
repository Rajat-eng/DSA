package BT;

public class maxdepthsum {
	
	public static int maxdepth(BinaryTreeNode<Integer> root) {
		if(root==null)
			return 0;
		
		return 1+ Math.max( maxdepth(root.left),maxdepth(root.right) );
	}
	
	public static int deepestLeavesSum(BinaryTreeNode<Integer> root) {
		int depth=maxdepth(root);
		
		return findnodesum(root,depth);
	}
	
	public static int findnodesum(BinaryTreeNode<Integer> root, int depth) {
		if(root==null)
			return 0;
		
		if(depth==1)
			return root.data;
		
		int left=findnodesum(root.left,depth-1);
		int right=findnodesum(root.right,depth-1);
		
		return left+right;
			
	}
	

	public static void main(String[] args) {
//		1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1  
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		int ans=deepestLeavesSum(root);
		System.out.println(ans);

	}

}
