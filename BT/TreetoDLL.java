package BT;

 public class TreetoDLL {
	 
	private static BinaryTreeNode<Integer> prev=null;
	
	public static void BTtoDLLhelper(BinaryTreeNode<Integer> root){
		if(root==null)
			return;
		
		BTtoDLLhelper(root.left);
		
		prev.right=root;
		root.left=prev;
		prev=root;
		
		BTtoDLLhelper(root.right);
	}
	
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root){
		BinaryTreeNode<Integer> dummy = new BinaryTreeNode<Integer>(-1);
		prev=dummy;
		BTtoDLLhelper(root);
		BinaryTreeNode<Integer> head=dummy.right;
		prev.right=head.left=null;
		return head;
	}
	

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
//		1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1	
		BinaryTreeNode<Integer> ans=BTtoDLL(root);
		while(ans!=null) {
			System.out.print(ans.data + " ");
			ans=ans.right;
		}
	}
}
