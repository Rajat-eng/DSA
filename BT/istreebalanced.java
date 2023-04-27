package BT;

class pair{
	int height;
	boolean isbalanced;
}

public class istreebalanced {
	
	public static pair isBalanced(BinaryTreeNode<Integer> root) {
		if(root==null) {
			pair ans=new pair();
			ans.height=0;
			ans.isbalanced=true;
			return ans;
		}
		pair left=isBalanced(root.left);
		pair right=isBalanced(root.right);
		pair ans=new pair();
		ans.isbalanced=Math.abs(left.height-right.height)<=1 && left.isbalanced && right.isbalanced;
		ans.height=(int)Math.pow(left.height,right.height)+1;
		return ans;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> head=BTUse.takeinput();
		BTUse.print(head);
		System.out.println(isBalanced(head).isbalanced);
	}
}
