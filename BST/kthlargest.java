package BST;
import BT.*;
import java.util.*;
public class kthlargest {

	public static int method1(BinaryTreeNode<Integer> root, int k) {
		Stack<BinaryTreeNode<Integer>> s=new Stack<>();
        
        while(true){
            while(root!=null){
                s.push(root);
                root=root.right;
            }  
            if(s.size()==0 && k>0)
               return -1;
            
            root=s.pop();
            
            if(--k==0)
                return root.data;
            root=root.left;
        }
	}
	
	public static int method2(BinaryTreeNode<Integer> root,int k,int[] count) {
		// array is passed as refernece hence count cannot be integer. it keeps on adding to 1 only
		
		if(root==null)
			return -1;

	
		int right=method2(root.right,k,count);
		if (right != -1)
	    {
	    	return right;
	    }
		count[0]++;

		if(count[0]==k)
			return root.data;
		
		int left=method2(root.left,k,count);
		
		return left;
	
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=BTUse.takeinput();
		BTUse.print(root);
		int a[]=new int[1];
//		System.out.println(method1(root, 3));
		int k=method2(root, 4,a);
		System.out.println(k);
//    5 4 8 -1 -1 7 10 -1 -1 9 -1 -1 -1 
	}

}
