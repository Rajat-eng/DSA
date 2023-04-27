package BT;
public class tolargersumtree {

    public static BinaryTreeNode<Integer> convertToSumTree(BinaryTreeNode<Integer> root) {
        sum(root);
        return root;
    }
    
    public static int sum(BinaryTreeNode<Integer> root){
        if(root==null)
            return 0;
        
        int olddata=root.data;
        root.data=sum(root.left) + sum(root.right);
        return root.data+olddata;  
    }
    
  
    
    public static long leftSumhelper(BinaryTreeNode<Integer> root,long sum){
//    	sum of all left nodes
		if(root.left!=null){
			sum=leftSumhelper(root.left,sum + root.left.data);
		}
		if(root.right!=null){
			sum=leftSumhelper(root.right,sum);
		}
		
		return sum;
	}


	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);

//		BinaryTreeNode<Integer> ans=convertToSumTree(root);
		
		//System.out.println(ans);
	}

}
