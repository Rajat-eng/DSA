package BT;

public class duplicate {
	
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root==null)
            return;
        
         BinaryTreeNode<Integer> newnode=new BinaryTreeNode<>(root.data); 
        
         newnode.left=root.left;
         root.left=newnode;
        
        insertDuplicateNode(newnode.left); 
        insertDuplicateNode(root.right);
             
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		insertDuplicateNode(root);
		BTUse.printlevelwise(root);	
	}

}
