package BT;

public class Cousin {
	public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
		if(root==null)
            return false;
        return (  (!isSibling(root,p,q)) && depth(root,p)==depth(root,q) );
	}
    
    public static boolean isSibling(BinaryTreeNode<Integer> root,int p,int q){
        if(root==null)
            return false;
        if(root.left!=null && root.right!=null){
            if(root.left.data==p && root.right.data==q)
                return true;
            else if(root.left.data==q && root.right.data==p)
                return true;
            else
            return isSibling(root.left,p,q) || isSibling(root.right,p,q); 
        }
        
        if(root.left!=null)
            return isSibling(root.left,p,q);
        else if(root.right!=null)
            return isSibling(root.right,p,q);
        else
            return false;
    }
    
    public static int depth(BinaryTreeNode<Integer> root,int node){
        if(root==null)
        return 0;
        if(root.data==node)
            return 1;
        int leftheight=depth(root.left,node);
        if(leftheight!=0)
            return 1+leftheight;
        if(leftheight==0) {
        	 int rightheight=depth(root.right,node);
             if(rightheight!=0)
                 return 1+rightheight;
        }
        return 0;
    }

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		System.out.println(isCousin(root, 4, 6));
//	    1 2 3 4 5 6 7 -1 -1 -1 8 -1 -1 -1 -1 -1 -1
	}

}
