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
    
    public static int largersum(BinaryTreeNode<Integer> root,int sum){
    	if(root==null)
    		return sum;
    	sum=largersum(root.right,sum);
    	sum+=root.data;
    	root.data=sum;
    	sum=largersum(root.left,sum);
    	
    	return sum;
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
//		1 2 3 4 5 6 7 -1 -1 -1 -1
		BinaryTreeNode<Integer> ans=convertToSumTree(root);
		BTUse.print(ans);
	}

}
