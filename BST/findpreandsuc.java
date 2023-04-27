package BST;
import java.util.Scanner;

import BT.BTUse;
import BT.BinaryTreeNode;
public class findpreandsuc {
	
	public static BinaryTreeNode<Integer> suc=null; 
	public static BinaryTreeNode<Integer> pre=null; 
	
    public static void PreSuc(BinaryTreeNode<Integer> root, int key) {
    	
    	if(root==null)
    		return;
	  
	    while(root!=null) {
			if(root.data==key) {	
				if(root.right!=null) {
					suc=root.right;
					while(suc.left!=null) {
						suc=suc.left;
					}
				}
				if(root.left!=null) {
					pre=root.left;
					while(pre.left!=null) {
						pre=pre.left;
					}
				}
				return;
			}else if(root.data>key) {
				suc=root;
				root=root.left;
			}else {
				pre=root;
				root=root.right;
			}
	    }
     }

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		BTUse.print(root);
		PreSuc(root,k);
		sc.close();
		System.out.println(pre!=null?pre.data:-1);
		System.out.println(suc!=null?suc.data:-1);
	}

}
