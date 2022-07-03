package BT;

public class subtreeofanothertree {
	
	public static boolean isSubtree(BinaryTreeNode<Integer> T, BinaryTreeNode<Integer> S) {
		if(T==null)
			return false;
		if(S==null)
			return true;
		
		boolean istreesame=istreeidentical(T,S);
		if(istreesame) return true;
		
		boolean left=isSubtree(T.left, S);
		boolean right=isSubtree(T.right, S);
		
		return left||right;
	}
	
	public static boolean istreeidentical(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2) {
		if(root1==null && root2==null)
			return true;
		
		else if(root1==null || root2==null)
		    return false;
		
		if((int)root1.data!=(int)root2.data)
			return false;
		
		boolean left=istreeidentical(root1.left, root2.left);
		boolean right=istreeidentical(root1.right, root2.right);
		
//		return ((int)root1.data==(int)root2.data && istreeidentical(root1.left, root2.left) && istreeidentical(root1.right, root2.right));
		return left && right;
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root1=BTUse.takeinput();
		BinaryTreeNode<Integer> root2=BTUse.takeinput();
		BTUse.print(root1);
		BTUse.print(root2);
		System.out.println(isSubtree(root1, root2));
	}

}
