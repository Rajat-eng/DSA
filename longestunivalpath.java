package BT;

public class longestunivalpath {
	
	public static int max;
	public static int longestUnivaluePath(BinaryTreeNode<Integer> root) {
		max=0;
		helper(root);
		return max;
	}
	public static int helper(BinaryTreeNode<Integer> root){
		if(root==null)  return 0;
		int left=helper(root.left);
		int right=helper(root.right);
		int arrowleft=0,arrowright=0;
		if(root.left!=null && root.data==root.left.data)
			arrowleft=left+1;
		
		if(root.right!=null && root.data==root.right.data)
			arrowright=right+1;
		
		max=Math.max(max,arrowleft+arrowright);
		return Math.max(arrowleft,arrowright);
	}

	public static void main(String[] args) {
//		7 4 7 4 4 -1 7 4 4 -1 -1 -1 7 -1 -1 -1 -1 -1 7 -1 7 -1 -1 
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		System.out.println(longestUnivaluePath(root));

	}

}
